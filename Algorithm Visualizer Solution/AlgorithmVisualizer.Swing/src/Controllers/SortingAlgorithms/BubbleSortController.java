package Controllers.SortingAlgorithms;

import Controllers.Controller;
import Models.SortingAlgorithms.BinarySearchModel;
import Models.SortingAlgorithms.BubbleSortModel;
import Shared.DataAccess;
import Views.SortingAlgorithms.BinarySearchView;
import Views.SortingAlgorithms.BubbleSortView;
import res.Styles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSortController implements Controller {

    private BubbleSortView view = new BubbleSortView();
    private BubbleSortModel model = new BubbleSortModel();

    public void InitView() {
        view.animatePanels(model);
    }

    public void InitController() {
        InitView();
    }
}