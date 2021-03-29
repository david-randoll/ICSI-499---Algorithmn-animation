import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controllers.HomeController;
import Controllers.SortingAlgorithms.BubbleSortController;
import Models.HomeModel;
import Models.SortingAlgorithms.BubbleSortModel;
import Views.HomeView;
import Views.SortingAlgorithms.BubbleSortView;

public class Startup {
    public static void main(String[] args) {
        HomeModel homeModel = new HomeModel();
        HomeView homeView = new HomeView();
        HomeController homeController = new HomeController(homeModel, homeView);
        
        BubbleSortModel bubbleSortModel = new BubbleSortModel();
        BubbleSortView bubbleSortView = new BubbleSortView();
        BubbleSortController bubbleSortController = new BubbleSortController(bubbleSortModel, bubbleSortView);

        JFrame frame = new JFrame();
        frame.setSize(600,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(bubbleSortView);
        // frame.add(homeView);
        frame.setVisible(true);
    }
}