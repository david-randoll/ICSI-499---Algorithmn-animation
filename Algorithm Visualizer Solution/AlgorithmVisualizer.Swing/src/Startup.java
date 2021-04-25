import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controllers.HomeController;
import Controllers.SettingsController;
import Controllers.SortingAlgorithms.BinarySearchController;
import Controllers.SortingAlgorithms.BubbleSortController;
import Models.HomeModel;
import Models.SortingAlgorithms.BinarySearchModel;
import Models.SortingAlgorithms.BubbleSortModel;
import Shared.AppFrame;
import Shared.DataAccess;
import SharedComponents.Frame;
import Views.HomeView;
import Views.SortingAlgorithms.BinarySearchView;
import Views.SortingAlgorithms.BubbleSortView;
import SharedComponents.*;

public class Startup {
    public static void main(String[] args) {
        //HomeModel homeModel = new HomeModel();
        //HomeView homeView = new HomeView();
        //HomeController homeController = new HomeController(homeModel, homeView);
        //
        //BubbleSortModel bubbleSortModel = new BubbleSortModel();
        //BubbleSortView bubbleSortView = new BubbleSortView();
        //BubbleSortController bubbleSortController = new BubbleSortController(bubbleSortModel, bubbleSortView);

        //JFrame frame = new JFrame();
        //frame.setSize(600,200);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.add(bubbleSortView);
        //// frame.add(homeView);
        //frame.setVisible(true);

        //Initialize application's frame
        AppFrame appFrame = new AppFrame();
        HomeController homeController = new HomeController();
        DataAccess.Run();
    }
}