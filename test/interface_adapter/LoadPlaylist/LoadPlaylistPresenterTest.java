package interface_adapter.LoadPlaylist;

import interface_adapter.WaitRoom.HostWaitRoomViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.LoadPlaylist.LoadPlaylistInputData;
import use_case.LoadPlaylist.LoadPlaylistOutputData;

import static org.junit.Assert.*;

public class LoadPlaylistPresenterTest {

    private LoadPlaylistPresenter loadPlaylistPresenter;
    private HostWaitRoomViewModel hostWaitRoomViewModel;
    @Before
    public void setUp() {
        hostWaitRoomViewModel = new HostWaitRoomViewModel();
        loadPlaylistPresenter = new LoadPlaylistPresenter(hostWaitRoomViewModel);
    }

    @Test
    public void prepareSuccessView() {

        loadPlaylistPresenter.prepareSuccessView(new LoadPlaylistOutputData());

    }

    @Test
    public void prepareFailView() {
        loadPlaylistPresenter.prepareFailView("error");
        assertEquals("error", hostWaitRoomViewModel.getState().getPlaylistError());
    }
}