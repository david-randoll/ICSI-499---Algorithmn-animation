package Controllers.SortingAlgorithms;

import Models.SortingAlgorithms.InsertionSortModel;
import Views.SortingAlgorithms.InsertionSortView;

import javax.swing.*;

public class InsertionSortController extends SorterController {

    private InsertionSortView view;
    private InsertionSortModel model;

    public InsertionSortController() {
        model = new InsertionSortModel();
        view = new InsertionSortView(model);
    }

    public void InitController() {
        super.InitController(model,view);
    }
}