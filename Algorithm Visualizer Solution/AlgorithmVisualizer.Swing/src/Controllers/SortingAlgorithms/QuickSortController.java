package Controllers.SortingAlgorithms;

import Models.SortingAlgorithms.QuickSortModel;
import Views.SortingAlgorithms.QuickSortView;

public class QuickSortController extends SorterController {
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
