package Controllers.SortingAlgorithms;

import Controllers.Controller;
import Models.SortingAlgorithms.BinarySearchModel;
import Views.SortingAlgorithms.BinarySearchView;

import javax.swing.*;

public class BinarySearchController implements Controller {

    public BinarySearchView view;
    public BinarySearchModel model;

    public void InitView() {
        Runnable runnable = new Runnable() {
            public void run() {
                view.animateBinarySearch(model);
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    public void InitController() {
        view = new BinarySearchView();
        model = new BinarySearchModel();
        InitView();
    }

}

