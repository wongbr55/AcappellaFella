package use_case.SingerChoose;

import data_access.InMemoryRoundStateDataAccessObject;
import entity.RoundState;
import interface_adapter.SingerChoose.SingerChoosePresenter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingerChooseInteractorTest {

    private SingerChooseInteractor singerChooseInteractor;
    private InMemoryRoundStateDataAccessObject inMemoryRoundStateDataAccessObject;
    @Before
    public void setUp() throws Exception {
        this.inMemoryRoundStateDataAccessObject = new InMemoryRoundStateDataAccessObject();
        this.inMemoryRoundStateDataAccessObject.addRound();
        SingerChooseOutputBoundary singerChooseOutputBoundary = new SingerChooseOutputBoundary() {
            @Override
            public void prepareSuccessView(SingerChooseOutputData singerChooseOutputData) {

            }

            @Override
            public void prepareFailView(String error) {

            }
        };

        this.singerChooseInteractor = new SingerChooseInteractor(inMemoryRoundStateDataAccessObject, singerChooseOutputBoundary);
    }

    @Test
    public void execute() {
        SingerChooseInputData singerChooseInputData = new SingerChooseInputData("American Idiot by Green Day");
        this.singerChooseInteractor.execute(singerChooseInputData);

        RoundState roundState = inMemoryRoundStateDataAccessObject.getCurrentRoundState();

        assertEquals( "American Idiot", roundState.getSong().getTitle());
        assertEquals(RoundState.SingerState.SINGING, roundState.getSingerState());
    }
}