package Controllers.SortingAlgorithms;

import Controllers.Controller;
import Models.SortingAlgorithms.BubbleSortModel;
import Views.SortingAlgorithms.BubbleSortView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
}