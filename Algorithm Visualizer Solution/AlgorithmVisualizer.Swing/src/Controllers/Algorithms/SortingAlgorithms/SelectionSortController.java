package Controllers.Algorithms.SortingAlgorithms;

import Models.Algorithms.SortingAlgorithms.SelectionSortModel;
import Views.Algorithms.SortingAlgorithms.SelectionSortView;

public class SelectionSortController extends BaseSorterController {
    private SelectionSortView view;
    private SelectionSortModel model;

    public SelectionSortController() {
        model = new SelectionSortModel();
        view = new SelectionSortView(model);
    }

    public void InitController() {
        super.InitController(model,view);
    }
}
