import Controllers.HomeController;
import Shared.DataAccess;

public class Startup {
    public static void main(String[] args) {
        DataAccess.InitDefaultDataSet();
        HomeController homeController = new HomeController();
        homeController.InitController();
    }
}