import Controllers.HomeController;
import Shared.DataAccess;

public class Startup {
    public static void main(String[] args) {
        DataAccess.Run();
        HomeController homeController = new HomeController();

    }
}