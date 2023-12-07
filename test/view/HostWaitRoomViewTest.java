package view;

import interface_adapter.LoadPlaylist.LoadPlaylistController;
import interface_adapter.StartGame.StartGameController;
import interface_adapter.WaitRoom.HostWaitRoomViewModel;
import interface_adapter.WaitRoom.WaitRoomViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.LoadPlaylist.LoadPlaylistInputBoundary;
import use_case.LoadPlaylist.LoadPlaylistInputData;
import use_case.StartGame.StartGameInputBoundary;
import use_case.StartGame.StartGameInputData;

import static org.junit.Assert.*;

public class HostWaitRoomViewTest {

    HostWaitRoomView hostWaitRoomView;
    HostWaitRoomViewModel hostWaitRoomViewModel;
    LoadPlaylistController loadPlaylistController;
    LoadPlaylistInputBoundary loadPlaylistInputBoundary;
    StartGameController startGameController;
    StartGameInputBoundary startGameInputBoundary;
    @Test
    public void setUp() {
       hostWaitRoomViewModel = new HostWaitRoomViewModel();
       loadPlaylistInputBoundary = new LoadPlaylistInputBoundary() {
           @Override
           public void execute(LoadPlaylistInputData loadPlaylistInputData) {

           }
       };
       loadPlaylistController = new LoadPlaylistController(loadPlaylistInputBoundary);
       startGameInputBoundary = new StartGameInputBoundary() {
           @Override
           public void execute(StartGameInputData startGameInputData) {

           }
       };
       startGameController = new StartGameController(startGameInputBoundary);
       hostWaitRoomView = new HostWaitRoomView(hostWaitRoomViewModel, startGameController, loadPlaylistController);

    }

    @Test
    public void actionPerformed() {
    }

    @Test
    public void propertyChange() {
    }
}