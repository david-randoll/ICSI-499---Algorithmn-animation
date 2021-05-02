package Controllers.SortingAlgorithms;

import Controllers.Controller;
import Controllers.HomeController;
import Models.SortingAlgorithms.BubbleSortModel;
import Shared.AppFrame;
import Shared.DataAccess;
import SharedComponents.Panel;
import SharedComponents.toast;
import Views.SortingAlgorithms.BubbleSortView;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BubbleSortController implements Controller {

    private BubbleSortView view;
    private BubbleSortModel model;

    public void InitController() {
        model = new BubbleSortModel();
        view = new BubbleSortView(model);
        InitView();

        Runnable runnable = new Runnable() {
            public void run() {
                view.animateBubbleSort();
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    public void InitView() {
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
                int currentIndex = view.getCurrentIndex();
                currentIndex -= 2;
                view.setCurrentIndex(currentIndex);
                view.PaintNewPanelOnScreen();
            }
        };
    }

    private ActionListener playPauseEventListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (view.isTimerRunning()) {
                    view.Stop();
                } else {
                    view.Start();
                }
            }
        };
    }

    private ActionListener resetEventListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.Reset();
            }
        };
    }

    public ChangeListener speedSliderStateChange() {
        return new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                int speedValue = view.getSpeedSliderValue();
                view.setSpeedValue(speedValue);
                view.setTimerDelay(speedValue);
            }
        };
    }

    private ActionListener updateDataSetActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.Stop();

                if (DataAccess.SetData(view.getDataSetTextBox().getText()) == false) {
                    toast t = new toast("Not valid input! Only comma separated numbers are valid", (int) (view.getScreenSize().width * 0.5), (int) (view.getScreenSize().height * 0.8));
                    t.showtoast();
                }
                model.Panels.removeAll();
                ArrayList<Panel> panels = model.run(DataAccess.GetData());

                for (int i = 0; i < panels.size(); i++) {
                    model.Panels.add(panels.get(i), Integer.toString(i));
                }//Add all cards to the card panel so we can transition panels easily

                view.setCurrentIndex(0);
                view.UpdatePlayPauseButtonText("\u23F5");
                AppFrame.appFrame.revalidate();
                AppFrame.appFrame.repaint();
            }
        };
    }

    public ActionListener homePageListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.Stop();
                AppFrame.appFrame.getContentPane().removeAll();
                AppFrame.appFrame.dispose();
                HomeController homeController = new HomeController();
            }
        };
    }
}