package Controllers;

import Models.HomeModel;
import Views.HomeView;

public class HomeController {
    private HomeModel homeModel;
    private HomeView homeView;
    public HomeController(HomeModel homeModel, HomeView homeView) {
        this.homeModel = homeModel;
        this.homeView = homeView;
        InitView();
        InitController();
    }
    private void InitView() {
        //set default element value for the user
    }
    public void InitController() {
    
    }
/*
    private void actionPerformed(ActionEvent e){

        //go to settings page button
        else if(){//event is settings button. UPDATE
            JFrame frame = new JFrame();
            frame.setSize(600,200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(Startup.settingsView);
            // frame.add(homeView);
            frame.setVisible(true);
        }
    }
    */
}
