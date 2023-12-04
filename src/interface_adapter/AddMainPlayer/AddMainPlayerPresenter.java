package interface_adapter.AddMainPlayer;

import use_case.AddMainPlayer.AddMainPlayerInputBoundary;
import use_case.AddMainPlayer.AddMainPlayerInputData;
import use_case.AddMainPlayer.AddMainPlayerOutputBoundary;
import use_case.AddMainPlayer.AddMainPlayerOutputData;

public class AddMainPlayerPresenter implements AddMainPlayerOutputBoundary {
    private final AddMainPlayerLoggerModel addMainPlayerLoggerModel;

    public AddMainPlayerPresenter(AddMainPlayerLoggerModel addMainPlayerLoggerModel) {
        this.addMainPlayerLoggerModel = addMainPlayerLoggerModel;
    }

    @Override
    public void updateChannel(AddMainPlayerOutputData addMainPlayerOutputData) {
        addMainPlayerLoggerModel.getState().setPlayerName(addMainPlayerOutputData.getPlayerName());
        addMainPlayerLoggerModel.firePropertyChanged();
    }
}
