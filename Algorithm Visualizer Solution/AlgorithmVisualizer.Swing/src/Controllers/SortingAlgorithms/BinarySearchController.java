package Controllers.SortingAlgorithms;

import Models.SortingAlgorithms.BinarySearchModel;
import SharedComponents.Frame;
import Views.SortingAlgorithms.BinarySearchView;

public class BinarySearchController {

    private Frame appFrame = new Frame();
    private BinarySearchView view = new BinarySearchView();
    private BinarySearchModel model = new BinarySearchModel();

    private void InitView() {
        //set default element value for the user
        appFrame.setVisible(true);
        view.animatePanels(appFrame, model.Panels);

    }
    public void InitController() {
        //initialized event listeners
        InitView();
    }


}

