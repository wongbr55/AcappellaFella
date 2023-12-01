package data_access;

// libraries for working with APIs
import entity.Playlist;
import entity.Song;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.LoadPlaylist.LoadPlaylistDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class APIDataAccessObject implements LoadPlaylistDataAccessInterface {

    // load CLIENT_ID and CLIENT_SECRET from env variable.
    private static final String CLIENT_ID = System.getenv("CLIENT_ID");
    private static final String CLIENT_SECRET = System.getenv("CLIENT_SECRET");

    private Playlist playlist = new Playlist();

    public static String requestAccessToken() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();


        RequestBody formBody = new FormBody.Builder()
                .add("grant_type", "client_credentials")
                .add("client_id", CLIENT_ID)
                .add("client_secret", CLIENT_SECRET)
                .build();

        Request request = new Request.Builder()
                .url("https://accounts.spotify.com/api/token")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .post(formBody)
                .build();

        try {
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());

            return responseBody.getString("access_token");
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject requestPlaylistData(String accessToken, String playlistId) {
        // In this case, we are using playlistId = 37i9dQZF1DX5Ejj0EkURtP which refers to the "All Out 2010s" playlist

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/playlists/".concat(playlistId).concat("/tracks"))
                .addHeader("Authorization", "Bearer " + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static Song getSong(JSONObject playlistData, Integer trackNumber) {

        // navigate to specific track in the playlist based on trackNumber
        JSONObject playlistTrack = playlistData.getJSONArray("items").getJSONObject(trackNumber).getJSONObject("track");

        // retrieve name of the FIRST/MAIN artist in the track (there could be multiple artists per track)
        String artist = playlistTrack.getJSONObject("album").getJSONArray("artists").getJSONObject(0).getString("name");

        // retrieve the title of the track
        String title = playlistTrack.getString("name");

        // return a new Song object corresponding to the title and artist
        return new Song(artist, title);
    }


    @Override
    public Playlist getPlaylist() {
        Integer minTrackNumber = 0;
        Integer maxTrackNumber = 149;
        Integer numSongs = 3;

        // array to store three songs
        ArrayList<Song> threeSongs = new ArrayList<>();

        // request the access token using environment variables
        String accessToken = requestAccessToken();

        // main program
        JSONObject playlistData = requestPlaylistData(accessToken, "37i9dQZF1DX5Ejj0EkURtP");
        for (Integer i = 0; i < numSongs; i++) {
            Integer randomTrackNumber = ThreadLocalRandom.current().nextInt(minTrackNumber, maxTrackNumber + 1);
            System.out.println(randomTrackNumber);
            threeSongs.add(getSong(playlistData, randomTrackNumber));
        }
        playlist.setSongOne(threeSongs.get(0));
        playlist.setSongTwo(threeSongs.get(1));
        playlist.setSongThree(threeSongs.get(2));
        return playlist;
    }
}
