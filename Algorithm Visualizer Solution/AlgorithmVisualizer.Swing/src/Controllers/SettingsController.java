package Controllers;

import Models.SettingsModel;
import Views.HomeView;
import Views.SettingsView;
import res.Styles;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SettingsController implements ActionListener{
    public SettingsView settingsView;
    private SettingsModel settingsModel;

    public SettingsController(SettingsView settingsView, SettingsModel settingsModel) {
        this.settingsView = settingsView;
        this.settingsModel = settingsModel;
        InitView();
        InitController();
    }


    private void InitView(){
        this.settingsView.setSize(600,200);

        //homeView.add(frame);
    }

    private void InitController(){
        this.settingsView.submit.addActionListener(this);

        //Initialize DB connection
    }

    public void actionPerformed(ActionEvent e){
        //Feedback form submit button
        if(e.getSource() == this.settingsView.submit){
            System.out.println("Testing settings button");
            String feedback = this.settingsView.feedbackForm.getText();

            //Connecting to Java spring Rest API
            //send data to db
        }else if(e.getSource() == this.settingsView.fontSizeSubmit){ //fontSize button
            Styles.PAGE_TITLE_FONTSIZE = this.settingsView.fontSize.getColumns();
        }else if(e.getSource() == this.settingsView.fontColorSubmit){ //fontColor Color

        }
    }

}
