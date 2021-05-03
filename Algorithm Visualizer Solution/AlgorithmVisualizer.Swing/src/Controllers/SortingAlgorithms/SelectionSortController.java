package Controllers.SortingAlgorithms;

import Models.SortingAlgorithms.SelectionSortModel;
import Views.SortingAlgorithms.SelectionSortView;

import javax.swing.*;

public class SelectionSortController {
    private SelectionSortView view;
    private SelectionSortModel model;

    public void InitView() {
        Runnable runnable = new Runnable() {
            public void run() {
                view.animateSelectionSort(model);
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    public void InitController() {
        view = new SelectionSortView();
        model = new SelectionSortModel();
        InitView();
    }
}
