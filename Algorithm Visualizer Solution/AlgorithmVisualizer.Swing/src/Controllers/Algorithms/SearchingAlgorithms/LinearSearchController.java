package Controllers.Algorithms.SearchingAlgorithms;

import Models.Algorithms.SearchingAlgorithms.LinearSearchModel;
import Views.Algorithms.SearchingAlgorithms.LinearSearchView;

public class LinearSearchController extends BaseSearcherController {

    public LinearSearchView view;
    public LinearSearchModel model;

    public LinearSearchController() {
        model = new LinearSearchModel();
        view = new LinearSearchView(model);
    }

    public void InitController() {
        super.InitController(model,view);
    }

}

