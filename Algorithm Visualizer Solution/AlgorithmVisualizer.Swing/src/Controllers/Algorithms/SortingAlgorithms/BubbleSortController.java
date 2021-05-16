package Controllers.Algorithms.SortingAlgorithms;

import Models.Algorithms.SortingAlgorithms.BubbleSortModel;
import Views.Algorithms.SortingAlgorithms.BubbleSortView;

public class BubbleSortController extends BaseSorterController {

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