package view;

import interface_adapter.AddMainPlayer.AddMainPlayerController;
import interface_adapter.ChooseName.HostChooseNameViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.AddMainPlayer.AddMainPlayerInputBoundary;
import use_case.AddMainPlayer.AddMainPlayerInputData;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameInputBoundary;

import static org.junit.Assert.*;

public class HostChooseNameViewTest {
    HostChooseNameView hostChooseNameView;

    HostChooseNameViewModel hostChooseNameViewModel;

    AddMainPlayerController addMainPlayerController;

    AddMainPlayerInputBoundary addMainPlayerInputBoundary;

    @Test
    public void setUp() {
        hostChooseNameViewModel = new HostChooseNameViewModel();
        addMainPlayerInputBoundary = new AddMainPlayerInputBoundary() {
            @Override
            public void execute(AddMainPlayerInputData addMainPlayerInputData) {

            }
        };
        addMainPlayerController = new AddMainPlayerController(addMainPlayerInputBoundary);
        hostChooseNameView = new HostChooseNameView(hostChooseNameViewModel, addMainPlayerController);
    }
}