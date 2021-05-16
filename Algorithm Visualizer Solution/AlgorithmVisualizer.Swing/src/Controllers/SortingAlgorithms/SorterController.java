package Controllers.SortingAlgorithms;

import Controllers.HomeController;
import Models.SortingAlgorithms.IGeneratePanel;
import Models.SortingAlgorithms.SorterModel;
import Shared.AppFrame;
import Shared.Components.Panel;
import Shared.Components.toast;
import Shared.DataAccess;
import Views.SortingAlgorithms.SorterView;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SorterController implements ISorterController {
    private SorterView view;
    private SorterModel model;

    public void InitController(SorterModel model, SorterView view){
        this.model = model;
        this.view = view;
        InitView();

        Runnable runnable = new Runnable() {
            public void run() {
                view.runAnimation();
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    private void InitView(){
        view.addPreviousButtonListener(previousButtonEventListener());
        view.addNextButtonListener(nextButtonEventListener());
        view.addPlayPauseButtonListener(playPauseEventListener());
        view.addResetButtonListener(resetEventListener());
        view.addDataSetButtonListener(updateDataSetActionListener());
        view.addSpeedSliderListener(speedSliderStateChange());

        view.addHomeButtonListener(homePageListener());
    }

    private ActionListener nextButtonEventListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.PaintNewPanelOnScreen();
            }
        };
    }

    private ActionListener previousButtonEventListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //we going back by two because current index is always one ahead
                //if we go back by 1, that will put us back to the same slide so nothing change
                int currentIndex = model.getCurrentIndex();
                currentIndex -= 2;
                model.setCurrentIndex(currentIndex);
                view.PaintNewPanelOnScreen();
            }
        };
    }

    private ActionListener playPauseEventListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (model.isTimerRunning()) {
                    view.getTimer().Stop();
                } else {
                    view.getTimer().Start();
                }
            }
        };
    }

    private ActionListener resetEventListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.getTimer().Reset();
            }
        };
    }

    private ChangeListener speedSliderStateChange() {
        return new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                int speedValue = view.getSpeedSliderValue();
                model.setSpeedValue(speedValue);
                view.getTimer().setTimerDelay(speedValue);
            }
        };
    }

    protected ActionListener updateDataSetActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.getTimer().Stop();

                if (DataAccess.SetData(view.getDataSetTextBox().getText()) == false) {
                    toast t = new toast("Not valid input! Only comma separated numbers are valid", (int) (view.getScreenSize().width * 0.5), (int) (view.getScreenSize().height * 0.8));
                    t.showtoast();
                }
                model.Panels.removeAll();
                ArrayList<Panel> panels = ((IGeneratePanel)model).run(DataAccess.GetData());

                for (int i = 0; i < panels.size(); i++) {
                    model.Panels.add(panels.get(i), Integer.toString(i));
                }//Add all cards to the card panel so we can transition panels easily

                model.setCurrentIndex(0);

                view.UpdatePlayPauseButtonText("\u23F5");
                AppFrame.appFrame.revalidate();
                AppFrame.appFrame.repaint();
            }
        };
    }

    private ActionListener homePageListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.getTimer().Stop();
                AppFrame.appFrame.getContentPane().removeAll();
                AppFrame.appFrame.dispose();
                HomeController homeController = new HomeController();
            }
        };
    }
}