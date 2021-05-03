package Controllers.SearchingAlgorithms;

import Models.SearchingAlgorithms.BinarySearchModel;
import Models.SearchingAlgorithms.SearchModel;
import Views.SearchingAlgorithms.BinarySearchView;
import Views.SearchingAlgorithms.SearchView;

import javax.swing.*;

public class BinarySearchController extends SearchController {

    public BinarySearchView view;
    public BinarySearchModel model;

    public BinarySearchController() {
        model = new BinarySearchModel();
        view = new BinarySearchView(model);
    }

    public void InitController() {
        super.InitController(model,view);
    }

}

