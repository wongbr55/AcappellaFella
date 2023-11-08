package interface_adapter.Home;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class HomeViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Acapella Fella";
    public static final String CREATE_BUTTON = "Create";
    public static final String JOIN_BUTTON = "Join";

    public HomeViewModel() {super("home");}


    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
