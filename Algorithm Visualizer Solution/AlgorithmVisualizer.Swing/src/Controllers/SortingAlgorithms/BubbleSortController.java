package Controllers.SortingAlgorithms;

import Controllers.Controller;
import Models.SortingAlgorithms.BubbleSortModel;
import Shared.DataAccess;
import Views.SortingAlgorithms.BubbleSortView;
import res.Styles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSortController implements Controller {
    private BubbleSortModel bubbleSortModel;
    private BubbleSortView bubbleSortView;
    public BubbleSortController(BubbleSortModel bubbleSortModel, BubbleSortView bubbleSortView) {
        this.bubbleSortModel = bubbleSortModel;
        this.bubbleSortView = bubbleSortView;
        InitView();
        InitController();
    }
    public void InitView() {
        //set default element value for the user
    }
    public void InitController() {
        //initialized event listeners
    }



}









