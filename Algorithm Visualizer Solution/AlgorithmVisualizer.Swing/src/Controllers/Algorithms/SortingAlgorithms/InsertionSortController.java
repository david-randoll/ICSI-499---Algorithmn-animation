package Controllers.Algorithms.SortingAlgorithms;

import Models.Algorithms.SortingAlgorithms.InsertionSortModel;
import Views.Algorithms.SortingAlgorithms.InsertionSortView;

public class InsertionSortController extends BaseSorterController {

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