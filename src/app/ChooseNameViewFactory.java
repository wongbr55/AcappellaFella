package app;

import interface_adapter.ChooseName.ChooseNameViewModel;
import interface_adapter.ChooseName.HostChooseNameViewModel;
import interface_adapter.ChooseName.JoinChooseNameViewModel;
import interface_adapter.EnterChooseName.HostEnterChooseName.HostEnterChooseNameController;
import interface_adapter.EnterChooseName.HostEnterChooseName.HostEnterChooseNamePresenter;
import interface_adapter.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomController;
import interface_adapter.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomPresenter;
import interface_adapter.ViewManagerModel;
import interface_adapter.WaitRoom.HostWaitRoomViewModel;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameInputBoundary;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameInteractor;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameOutputBoundary;
import use_case.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomInputBoundary;
import use_case.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomInteractor;
import use_case.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomOutputBoundary;
import view.HostChooseNameView;
import view.JoinChooseNameView;

public class ChooseNameViewFactory {
    private ChooseNameViewFactory() {
    }

    public static JoinChooseNameView createJoinView(JoinChooseNameViewModel startLobbyViewModel) {
        return new JoinChooseNameView(startLobbyViewModel);
    }

    public static HostChooseNameView createHostView(HostChooseNameViewModel startLobbyViewModel, HostWaitRoomViewModel hostWaitRoomViewModel, ViewManagerModel viewManagerModel) {
        HostEnterWaitRoomController hostEnterWaitRoomController = createEnterWaitRoomUseCase(hostWaitRoomViewModel, viewManagerModel);
        return new HostChooseNameView(startLobbyViewModel, hostEnterWaitRoomController);
    }

    private static HostEnterWaitRoomController createEnterWaitRoomUseCase(HostWaitRoomViewModel hostWaitRoomViewModel, ViewManagerModel viewManagerModel) {
        HostEnterWaitRoomOutputBoundary hostEnterWaitRoomPresenter = new HostEnterWaitRoomPresenter(hostWaitRoomViewModel, viewManagerModel);
        HostEnterWaitRoomInputBoundary hostEnterWaitRoomInteractor = new HostEnterWaitRoomInteractor(hostEnterWaitRoomPresenter);
        return new HostEnterWaitRoomController(hostEnterWaitRoomInteractor);
    }
}
