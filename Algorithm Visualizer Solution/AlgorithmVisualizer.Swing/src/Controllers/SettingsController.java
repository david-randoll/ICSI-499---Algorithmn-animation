package Controllers;

import Models.SettingsModel;
import Views.SettingsView;
import res.Styles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsController implements ActionListener {
    public SettingsView view;
    public JFrame frame;
    private SettingsModel model = new SettingsModel();


    public SettingsController(JFrame frame) {
        this.frame = frame;
        InitView();
        InitController();
    }


    private void InitView() {
        view = new SettingsView();
    }

    private void InitController() {

        this.view.submit.addActionListener(this);
        this.view.Home.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        //Feedback form submit button
        if (e.getSource() == this.view.submit) {
            System.out.println("Testing settings button");
            String feedback = this.view.feedbackForm.getText();

            //Connecting to Java spring Rest API
            //send data to db
        } else if (e.getSource() == this.view.fontSizeSubmit) { //fontSize button
            Styles.PAGE_TITLE_FONTSIZE = this.view.fontSize.getColumns();
        } else if (e.getSource() == this.view.fontColorSubmit) { //fontColor Color

        } else if (e.getSource() == this.view.Home) {
            System.out.println("TEST");
            HomeController homeController = new HomeController();
            this.frame.getContentPane().removeAll();
            this.frame.getContentPane().add(homeController.homeView);
            this.frame.setVisible(true);
        }
    }

}
