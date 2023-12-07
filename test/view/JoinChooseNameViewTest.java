package view;

import interface_adapter.AddMainPlayer.AddMainPlayerController;
import interface_adapter.ChooseName.ChooseNameViewModel;
import interface_adapter.ChooseName.HostChooseNameViewModel;
import interface_adapter.ChooseName.JoinChooseNameViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.AddMainPlayer.AddMainPlayerInputBoundary;
import use_case.AddMainPlayer.AddMainPlayerInputData;

import static org.junit.Assert.*;

public class JoinChooseNameViewTest {
    JoinChooseNameView joinChooseNameView;
    JoinChooseNameViewModel joinChooseNameViewModel;
    AddMainPlayerController addMainPlayerController;
    AddMainPlayerInputBoundary addMainPlayerInputBoundary;

    @Test
    public void setUp() {
        joinChooseNameViewModel = new JoinChooseNameViewModel();
        addMainPlayerInputBoundary = new AddMainPlayerInputBoundary() {
            @Override
            public void execute(AddMainPlayerInputData addMainPlayerInputData) {

            }
        };
        addMainPlayerController = new AddMainPlayerController(addMainPlayerInputBoundary);
        joinChooseNameView = new JoinChooseNameView(joinChooseNameViewModel, addMainPlayerController);
    }
}