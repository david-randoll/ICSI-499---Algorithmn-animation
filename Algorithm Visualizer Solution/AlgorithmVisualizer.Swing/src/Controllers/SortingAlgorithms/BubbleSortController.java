package Controllers.SortingAlgorithms;

import Controllers.Controller;
import Models.SortingAlgorithms.BubbleSortModel;
import Views.SortingAlgorithms.BubbleSortView;

import javax.swing.*;

public class BubbleSortController implements Controller {

    private BubbleSortView view;
    private BubbleSortModel model;

    public void InitView() {
        Runnable runnable = new Runnable() {
            public void run() {
                view.animateBubbleSort(model);
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    public void InitController() {
        view = new BubbleSortView();
        model = new BubbleSortModel();
        InitView();
    }
}