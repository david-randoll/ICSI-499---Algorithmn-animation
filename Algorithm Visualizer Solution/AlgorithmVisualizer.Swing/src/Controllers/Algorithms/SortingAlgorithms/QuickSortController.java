package Controllers.Algorithms.SortingAlgorithms;

import Models.Algorithms.SortingAlgorithms.QuickSortModel;
import Views.Algorithms.SortingAlgorithms.QuickSortView;

public class QuickSortController extends BaseSorterController {
    QuickSortModel model;
    QuickSortView view;

    public QuickSortController() {
        model = new QuickSortModel();
        view = new QuickSortView(model);
    }

    public void InitController(){
        super.InitController(model,view);
    }
}
