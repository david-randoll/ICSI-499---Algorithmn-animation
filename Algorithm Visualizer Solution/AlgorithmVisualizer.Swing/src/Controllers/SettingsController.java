package Controllers;

import Models.SettingsModel;
import Views.SettingsView;

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

    }

}
