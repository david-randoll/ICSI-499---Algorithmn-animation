package Controllers.SortingAlgorithms;

import Models.SortingAlgorithms.SelectionSortModel;
import Views.SortingAlgorithms.SelectionSortView;

public class SelectionSortController extends SorterController {
    private SelectionSortView view;
    private SelectionSortModel model;

    public SelectionSortController() {
        model = new SelectionSortModel();
        view = new SelectionSortView(model);
    }

    public void InitController() {
        super.InitController(model, view);
    }
}
