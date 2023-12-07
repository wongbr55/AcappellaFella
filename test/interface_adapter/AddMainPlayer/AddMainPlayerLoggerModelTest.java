package interface_adapter.AddMainPlayer;

import interface_adapter.Home.HomeViewModel;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import org.junit.Before;
import org.junit.Test;
import view.SingerSingView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.Assert.*;

public class AddMainPlayerLoggerModelTest {

    private AddMainPlayerLoggerModel addMainPlayerLoggerModel;
    @Before
    public void setUp() {
        addMainPlayerLoggerModel = new AddMainPlayerLoggerModel();
    }

    @Test
    public void firePropertyChanged() {
        addMainPlayerLoggerModel.firePropertyChanged();
    }

    @Test
    public void addPropertyChangeListener() {
        addMainPlayerLoggerModel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

            }
        });
    }

    @Test
    public void getState() {
        AddMainPlayerState addMainPlayerState = addMainPlayerLoggerModel.getState();
    }

    @Test
    public void setState() {
        addMainPlayerLoggerModel.setState(new AddMainPlayerState());
    }
}