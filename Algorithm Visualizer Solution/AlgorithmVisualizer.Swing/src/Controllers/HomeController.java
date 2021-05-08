package Controllers;

import Controllers.SearchingAlgorithms.BinarySearchController;
import Controllers.SearchingAlgorithms.LinearSearchController;
import Controllers.SortingAlgorithms.BubbleSortController;
import Controllers.SortingAlgorithms.InsertionSortController;
import Controllers.SortingAlgorithms.QuickSortController;
import Controllers.SortingAlgorithms.SelectionSortController;
import Models.HomeModel;
import Shared.AppFrame;
import Shared.Components.toast;
import Shared.DataAccess;
import Shared.Components.DefaultFrame;
import Views.HomeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeController implements ActionListener {
    private HomeModel homeModel;
    public HomeView homeView;
    private DefaultFrame frame;
    private int flag = 0;

    public HomeController() {
        this.frame = new DefaultFrame();
        InitView();
        InitController();
    }

    //For settings page
    public HomeController(DefaultFrame frame){
        this.frame = frame;
        InitView();
        InitController();
    }

    private void InitView() {
        homeView = new HomeView();
        homeModel = new HomeModel();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ADJUSTED_MIDPOINT_HORIZONTAL = (screenSize.width / 2) - (frame.getWidth() / 2);

        this.frame.add(this.homeView);
        this.frame.setBounds(ADJUSTED_MIDPOINT_HORIZONTAL, 0, frame.getWidth(), frame.getHeight());
        this.frame.setVisible(true);
    }

    public void InitController() {
        this.homeView.settings.addActionListener(this);
        this.homeView.LinearSearch.addActionListener(this);
        this.homeView.BinarySearch.addActionListener(this);
        this.homeView.BubbleSort.addActionListener(this);
        this.homeView.InsertionSort.addActionListener(this);
        this.homeView.SelectionSort.addActionListener(this);
        this.homeView.QuickSort.addActionListener(this);

        homeView.setData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DataAccess.SetData(homeView.data.getText()) == false) {
                    toast t = new toast("Not valid input! Only comma separated numbers are valid", (int) (AppFrame.getScreenWidth() * 0.5), (int) (AppFrame.getScreenHeight() * 0.8));
                    t.showtoast();
                }
            }
        });

        //Brings the user to the github
        this.homeView.gitHub.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("http://www.github.com")); //Will link to the github repo so other students can add more if they wish to

                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });


    }

    public void actionPerformed(ActionEvent e) {

        //Settings button
        if (e.getSource() == this.homeView.settings) {
            this.frame.getContentPane().removeAll();
            this.frame.repaint();
            SettingsController settingsController = new SettingsController(this.frame);
        } else if (e.getSource() == this.homeView.LinearSearch) { //Linear Search Button
            frame.getContentPane().removeAll();
            frame.dispose();
            AppFrame appFrame = new AppFrame();
            LinearSearchController linearSearch = new LinearSearchController();
            linearSearch.InitController();
        }  else if (e.getSource() == this.homeView.BinarySearch) { //Binary Search Button
            frame.getContentPane().removeAll();
            frame.dispose();
            AppFrame appFrame = new AppFrame();
            BinarySearchController binarySearch = new BinarySearchController();
            binarySearch.InitController();
        } else if (e.getSource() == this.homeView.BubbleSort) {  //Bubble Sort
            frame.getContentPane().removeAll();
            frame.dispose();
            AppFrame appFrame = new AppFrame();
            BubbleSortController bubbleSortController = new BubbleSortController();
            bubbleSortController.InitController();
        } else if (e.getSource() == this.homeView.InsertionSort) {  //Insertion Sort
            frame.getContentPane().removeAll();
            frame.dispose();
            AppFrame appFrame = new AppFrame();
            InsertionSortController insertionSortController = new InsertionSortController();
            insertionSortController.InitController();
        } else if (e.getSource() == this.homeView.SelectionSort) {  //Selection Sort
            frame.getContentPane().removeAll();
            frame.dispose();
            AppFrame appFrame = new AppFrame();
            SelectionSortController selectionSortController = new SelectionSortController();
            selectionSortController.InitController();
        } else if (e.getSource() == this.homeView.QuickSort) {  //Quick Sort
            frame.getContentPane().removeAll();
            frame.dispose();
            AppFrame appFrame = new AppFrame();
            QuickSortController quickSortController = new QuickSortController();
            quickSortController.InitController();
        }
    }
}
