package Controllers;

import Controllers.SortingAlgorithms.BinarySearchController;
import Controllers.SortingAlgorithms.BubbleSortController;
import Models.HomeModel;
import Shared.AppFrame;
import SharedComponents.DefaultFrame;
import Views.HomeView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HomeController implements ActionListener {
    private HomeModel homeModel;
    public HomeView homeView;
    private DefaultFrame frame;

    public HomeController() {
        InitView();
        InitController();
    }

    private void InitView() {
        homeView = new HomeView();
        homeModel = new HomeModel();
        this.frame = new DefaultFrame();
        frame.add(this.homeView);
        frame.setVisible(true);
    }

    public void InitController() {
        this.homeView.settings.addActionListener(this);
        this.homeView.BinarySearch.addActionListener(this);
        this.homeView.BubbleSort.addActionListener(this);

        homeView.data.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homeView.data.setText("");
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
            SettingsController settingsController = new SettingsController(this.frame);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(settingsController.view);
            frame.setVisible(true);
        } else if (e.getSource() == this.homeView.BinarySearch) { //Binary Search Button
            frame.dispose();
            AppFrame appFrame = new AppFrame();
            BinarySearchController binarySearch = new BinarySearchController();
            binarySearch.InitController();
        } else if (e.getSource() == this.homeView.BubbleSort) {  //Bubble Sort
            frame.dispose();
            AppFrame appFrame = new AppFrame();
            BubbleSortController bubbleSortController = new BubbleSortController();
            bubbleSortController.InitController();
        }
    }
}
