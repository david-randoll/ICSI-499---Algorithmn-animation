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
        //initialized event listeners
    }
}