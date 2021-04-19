package Controllers;

import Models.SettingsModel;
import Views.SettingsView;
import res.Styles;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class SettingsController {
    private SettingsView settingsView;
    private SettingsModel settingsModel;

    public SettingsController(SettingsView settingsView, SettingsModel settingsModel) {
        this.settingsView = settingsView;
        this.settingsModel = settingsModel;
        InitView();
        InitController();
    }


    private void InitView(){

    }

    private void InitController(){
        this.settingsView.submit.addActionEventListener(this);

        //Initialize DB connection
    }

    private void actionPerformed(ActionEvent e){
        //Feedback form submit buton
        if(e.getSource() == this.settingsView.submit){
            String feedback = this.settingsView.feedbackForm;

            //Connecting to Java spring Rest API
            RestTemplate rest = new RestTemplate();
            rest.postForObject("http://localhost:8080/WebApp/ServiceName", requestBean, Response.class);
            //send data to db
        }else if(e.getSource() == this.settingsView.fontSizeSubmit){ //fontSize button
            Styles.PAGE_TITLE_FONTSIZE = this.settingsView.fontSize;
        }else if(e.getSource() == this.settingsView.fontColorSubmit){ //fontColor Color

        }
    }

}
