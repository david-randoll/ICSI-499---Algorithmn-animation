package Controllers.SortingAlgorithms;

import Controllers.Controller;
import Models.SortingAlgorithms.BubbleSortModel;
import Models.SortingAlgorithms.InsertionSortModel;
import Views.SortingAlgorithms.BubbleSortView;
import Views.SortingAlgorithms.InsertionSortView;

import javax.swing.*;

public class InsertionSortController implements Controller {

    private InsertionSortView view;
    private InsertionSortModel model;

    public void InitView() {
        Runnable runnable = new Runnable() {
            public void run() {
                view.animateInsertionSort(model);
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    public void InitController() {
        view = new InsertionSortView();
        model = new InsertionSortModel();
        InitView();
    }
}