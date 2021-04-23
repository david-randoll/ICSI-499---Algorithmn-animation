package Controllers.SortingAlgorithms;

import Models.SortingAlgorithms.BubbleSortModel;
import Shared.DataAccess;
import Views.SortingAlgorithms.BubbleSortView;
import res.Styles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSortController {
    private BubbleSortModel bubbleSortModel;
    private BubbleSortView bubbleSortView;
    public BubbleSortController(BubbleSortModel bubbleSortModel, BubbleSortView bubbleSortView) {
        this.bubbleSortModel = bubbleSortModel;
        this.bubbleSortView = bubbleSortView;
        InitView();
        InitController();
    }
    private void InitView() {
        //set default element value for the user
    }
    public void InitController() {
        //initialized event listeners
    }



}









