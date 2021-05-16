package Controllers.Algorithms.SearchingAlgorithms;

import Models.Algorithms.SearchingAlgorithms.BinarySearchModel;
import Views.Algorithms.SearchingAlgorithms.BinarySearchView;

public class BinarySearchController extends BaseSearcherController {

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

