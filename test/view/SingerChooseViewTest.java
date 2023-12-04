package view;

import interface_adapter.SingerChoose.SingerChooseController;
import interface_adapter.SingerChoose.SingerChooseViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.SingerChoose.SingerChooseInputBoundary;
import use_case.SingerChoose.SingerChooseInputData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.Assert.*;

public class SingerChooseViewTest {

    private SingerChooseView singerChooseView;
    private SingerChooseViewModel singerChooseViewModel;
    @Before
    public void init(){
        SingerChooseInputBoundary singerChooseInputBoundary = new SingerChooseInputBoundary() {
            @Override
            public void execute(SingerChooseInputData singerChooseInputdata) {

            }
        };
        SingerChooseController singerChooseController = new SingerChooseController(singerChooseInputBoundary);
        this.singerChooseViewModel = new SingerChooseViewModel();
        this.singerChooseView = new SingerChooseView(singerChooseViewModel, singerChooseController);
    }
    @Test
    public void propertyChange() {

        for (ActionListener actionListener: this.singerChooseView.getSong1().getActionListeners()){
            ActionEvent actionEvent = new ActionEvent(this.singerChooseView.getSong1(), 1, "song1");
            actionListener.actionPerformed(actionEvent);
        }

        for (ActionListener actionListener: this.singerChooseView.getSong2().getActionListeners()){
            ActionEvent actionEvent = new ActionEvent(this.singerChooseView.getSong2(), 2, "song2");
            actionListener.actionPerformed(actionEvent);
        }

        for (ActionListener actionListener: this.singerChooseView.getSong3().getActionListeners()){
            ActionEvent actionEvent = new ActionEvent(this.singerChooseView.getSong3(), 3, "song3");
            actionListener.actionPerformed(actionEvent);
        }

        singerChooseViewModel.firePropertyChanged();

    }
}