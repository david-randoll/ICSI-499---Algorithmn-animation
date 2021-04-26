package Controllers.SortingAlgorithms;

import Controllers.Controller;
import Models.SortingAlgorithms.BinarySearchModel;
import Views.SortingAlgorithms.BinarySearchView;

import javax.swing.*;

public class BinarySearchController implements Controller {

    public BinarySearchView view = new BinarySearchView();
    public BinarySearchModel model = new BinarySearchModel();

    public void InitView() {
        Runnable runnable = new Runnable() {
            public void run() {
                view.animateBinarySearch(model);
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    public void InitController() {
        model = new BinarySearchModel();
        InitView();
    }

}

