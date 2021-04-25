package Controllers.SortingAlgorithms;

import Controllers.Controller;
import Models.SortingAlgorithms.BinarySearchModel;
import Shared.DataAccess;
import Views.SortingAlgorithms.BinarySearchView;

public class BinarySearchController implements Controller {

    private BinarySearchView view = new BinarySearchView();
    private BinarySearchModel model = new BinarySearchModel();

    public void InitView() {
        view.animatePanels(model);
    }

    public void InitController() {
        InitView();
    }

}

