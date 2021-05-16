package Controllers.SearchingAlgorithms;

import Models.SearchingAlgorithms.LinearSearchModel;
import Models.SearchingAlgorithms.SearchModel;
import Views.SearchingAlgorithms.LinearSearchView;
import Views.SearchingAlgorithms.SearchView;

import javax.swing.*;

public class LinearSearchController extends SearchController {

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

