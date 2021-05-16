package Controllers.SortingAlgorithms;

import Models.SortingAlgorithms.BubbleSortModel;
import Views.SortingAlgorithms.BubbleSortView;

public class BubbleSortController extends SorterController {

    private BubbleSortView view;
    private BubbleSortModel model;

    public BubbleSortController() {
        model = new BubbleSortModel();
        view = new BubbleSortView(model);
    }
    public void InitController(){
        super.InitController(model,view);
    }
}