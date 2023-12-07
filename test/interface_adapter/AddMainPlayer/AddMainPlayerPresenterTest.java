package interface_adapter.AddMainPlayer;

import org.junit.Before;
import org.junit.Test;
import use_case.AddMainPlayer.AddMainPlayerOutputData;

import static org.junit.Assert.*;

public class AddMainPlayerPresenterTest {

    private AddMainPlayerPresenter addMainPlayerPresenter;
    @Before
    public void setUp() {
        AddMainPlayerLoggerModel addMainPlayerLoggerModel = new AddMainPlayerLoggerModel();
        addMainPlayerPresenter = new AddMainPlayerPresenter(addMainPlayerLoggerModel);
    }

    @Test
    public void updateChannel() {
        AddMainPlayerOutputData addMainPlayerOutputData = new AddMainPlayerOutputData("Brandon", true);
        addMainPlayerPresenter.updateChannel(addMainPlayerOutputData);

    }
}