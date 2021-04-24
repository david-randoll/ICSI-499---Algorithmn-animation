package Controllers;

import Controllers.SortingAlgorithms.BubbleSortController;
import Models.HomeModel;
import Models.SettingsModel;
import Models.SortingAlgorithms.BubbleSortModel;
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
    private HomeView homeView;
    private JFrame frame;

    //Controlled from the home screen
    BubbleSortModel bubbleSortModel = new BubbleSortModel();
    BubbleSortView bubbleSortView = new BubbleSortView();
    BubbleSortController bubbleSortController = new BubbleSortController(bubbleSortModel, bubbleSortView);



    public HomeController(HomeModel homeModel, HomeView homeView) {
        this.homeModel = homeModel;
        this.homeView = homeView;
        InitController();
        InitView();

    }
    private void InitView() {
        this.frame = new JFrame();
        frame.setPreferredSize(new Dimension(600, 550));
        frame.setLayout(null);
        frame.add(this.homeView);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        //homeView.add(frame);

    }
    public void InitController() {

       this.homeView.settings.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){

        //Settings Button
        SettingsModel settingsModel = new SettingsModel();
        SettingsView settingsView = new SettingsView();
        SettingsController settingsController = new SettingsController(settingsView, settingsModel);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(settingsController.settingsView);
        frame.repaint();

    }
}
