package use_case.LoadPlaylist;

import entity.Song;

import java.util.ArrayList;

public interface LoadPlaylistDataAccessInterface {
    public ArrayList<Song> getPlaylist();

}
