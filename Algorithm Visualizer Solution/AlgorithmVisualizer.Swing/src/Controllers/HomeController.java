package Controllers;

import Controllers.SortingAlgorithms.BinarySearchController;
import Controllers.SortingAlgorithms.BubbleSortController;
import Models.HomeModel;
import Shared.AppFrame;
import Shared.DataAccess;
import SharedComponents.DefaultFrame;
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
        InitView();
        InitController();
    }

    private void InitView() {
        homeView = new HomeView();
        homeModel = new HomeModel();
        this.frame = new DefaultFrame();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ADJUSTED_MIDPOINT_HORIZONTAL = (screenSize.width / 2) - (frame.getWidth() / 2);
        
        frame.add(this.homeView);
        frame.setBounds(ADJUSTED_MIDPOINT_HORIZONTAL, 0, frame.getWidth(), frame.getHeight());
        frame.setVisible(true);
    }

    public void InitController() {
        this.homeView.settings.addActionListener(this);
        this.homeView.BinarySearch.addActionListener(this);
        this.homeView.BubbleSort.addActionListener(this);

        homeView.setData.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 0;
                if(homeView.data.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a valid data set");
                    flag = 1;
                }
                if(flag != 1) {
                    flag = 0;
                    String dataSet = homeView.data.getText();

                    //Checking to make sure it is a comma separated list
                    String pattern = "^(\\d+(,\\d+)*)?$";
                    Pattern r = Pattern.compile(pattern);
                    Matcher m = r.matcher(dataSet);
                    if(m.find()) {
                        homeModel.setInputtedElementsList(dataSet);
                        DataAccess.SetData(homeModel.getInputtedElementsList());
                        flag = 0;
                    }
                    else{
                        flag = 1;
                        JOptionPane.showMessageDialog(null, "Please enter a valid data set");
                    }
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
            SettingsController settingsController = new SettingsController(this.frame);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(settingsController.view);
            frame.setVisible(true);
        } else if (e.getSource() == this.homeView.BinarySearch) { //Binary Search Button
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
        }
    }
}
