package data_access;

// libraries for working with APIs

import entity.Song;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.ReceiveMessage.ReceiveMessagePlaylistDataAccessInterface;
import use_case.RunGame.RunGamePlaylistDataAccessInterface;
import use_case.LoadPlaylist.LoadPlaylistPlaylistDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PlaylistSpotifyAPIDataAccessObject implements LoadPlaylistPlaylistDataAccessInterface, ReceiveMessagePlaylistDataAccessInterface, RunGamePlaylistDataAccessInterface {
    private static final String CLIENT_ID = System.getenv("CLIENT_ID");
    private static final String CLIENT_SECRET = System.getenv("CLIENT_SECRET");
    private static final String accessToken = requestAccessToken();
    private static final List<Song> playlist = new ArrayList<>();

    private static String requestAccessToken() {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        RequestBody formBody = new FormBody.Builder().add("grant_type", "client_credentials").add("client_id", CLIENT_ID).add("client_secret", CLIENT_SECRET).build();

        Request request = new Request.Builder().url("https://accounts.spotify.com/api/token").addHeader("Content-Type", "application/x-www-form-urlencoded").post(formBody).build();

        try {
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());

            return responseBody.getString("access_token");
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private JSONObject requestPlaylistData(String playlistId) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url("https://api.spotify.com/v1/playlists/".concat(playlistId).concat("/tracks")).addHeader("Authorization", "Bearer " + accessToken).build();
        try {
            Response response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean loadPlaylist(String playlistId) {
        JSONObject playlistData = requestPlaylistData("37i9dQZF1DX5Ejj0EkURtP");
        if (playlistData.has("error")) {
            return false;
        }
        JSONArray jsonSongs = playlistData.getJSONArray("items");
        playlist.clear();
        for (int i = 0; i < jsonSongs.length(); i++) {
            JSONObject jsonSong = jsonSongs.getJSONObject(i);
            Song song = new Song(jsonSong.getJSONObject("track").getJSONArray("artists").getJSONObject(0).getString("name"),
                    jsonSong.getJSONObject("track").getString("name"));
            playlist.add(song);
        }
        return true;
    }

    @Override
    public List<Song> getThreeSongs() {
        Collections.shuffle(playlist);
        return playlist.subList(0, 3);
    }
}
