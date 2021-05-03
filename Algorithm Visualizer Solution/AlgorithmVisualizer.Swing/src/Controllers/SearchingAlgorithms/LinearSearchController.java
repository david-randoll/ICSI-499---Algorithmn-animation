package Controllers.SearchingAlgorithms;

import Models.SearchingAlgorithms.LinearSearchModel;
import Views.SearchingAlgorithms.LinearSearchView;

public class LinearSearchController extends SearchController {

    public LinearSearchView view;
    public LinearSearchModel model;

    public LinearSearchController() {
        model = new LinearSearchModel();
        view = new LinearSearchView(model);
    }

    public void InitController() {
        super.InitController(model, view);
    }

}

