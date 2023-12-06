package interface_adapter.LoadPlaylist;

import interface_adapter.WaitRoom.HostWaitRoomViewModel;
import use_case.LoadPlaylist.LoadPlaylistOutputBoundary;
import use_case.LoadPlaylist.LoadPlaylistOutputData;

public class LoadPlaylistPresenter implements LoadPlaylistOutputBoundary {
    private final HostWaitRoomViewModel hostWaitRoomViewModel;

    public LoadPlaylistPresenter(HostWaitRoomViewModel hostWaitRoomViewModel) {
        this.hostWaitRoomViewModel = hostWaitRoomViewModel;
    }

    @Override
    public void prepareSuccessView(LoadPlaylistOutputData loadPlaylistOutputData) {
        hostWaitRoomViewModel.getState().setPlaylistLoaded(true);
        hostWaitRoomViewModel.getState().setPlaylistError(null);
        hostWaitRoomViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        hostWaitRoomViewModel.getState().setPlaylistError(error);
        hostWaitRoomViewModel.firePropertyChanged();
    }
}
