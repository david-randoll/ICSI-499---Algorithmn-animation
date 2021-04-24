package Controllers;

import Controllers.SortingAlgorithms.BubbleSortController;
import Models.HomeModel;
import Models.SettingsModel;
import Models.SortingAlgorithms.BubbleSortModel;
import SharedComponents.Frame;
import SharedComponents.SubmitButton;
import Views.HomeView;
import Views.SettingsView;
import Views.SortingAlgorithms.BubbleSortView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeController implements ActionListener {
    private HomeModel homeModel;
    public HomeView homeView;
    private Frame frame;

    //Controlled from the home screen
    BubbleSortModel bubbleSortModel = new BubbleSortModel();
    BubbleSortView bubbleSortView = new BubbleSortView();
    BubbleSortController bubbleSortController = new BubbleSortController(bubbleSortModel, bubbleSortView);



    public HomeController() {
        InitView();
        InitController();
    }
    private void InitView() {
        homeView = new HomeView();
        homeModel = new HomeModel();
        this.frame = new Frame();
        frame.add(this.homeView);
        frame.setVisible(true);
        //homeView.add(frame);

    }
    public void InitController() {

       this.homeView.settings.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){

        //Settings Button
        SettingsController settingsController = new SettingsController(this.frame);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(settingsController.view);
        frame.setVisible(true);

    }
}
