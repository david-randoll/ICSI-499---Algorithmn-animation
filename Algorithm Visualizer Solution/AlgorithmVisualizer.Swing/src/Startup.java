import Controllers.HomeController;
import Shared.DataAccess;

public class Startup {
    public static void main(String[] args) {
        //HomeModel homeModel = new HomeModel();
        //HomeView homeView = new HomeView();
        //HomeController homeController = new HomeController(homeModel, homeView);
        //
        //BubbleSortModel bubbleSortModel = new BubbleSortModel();
        //BubbleSortView bubbleSortView = new BubbleSortView();
        //BubbleSortController bubbleSortController = new BubbleSortController(bubbleSortModel, bubbleSortView);

        //JFrame frame = new JFrame();
        //frame.setSize(600,200);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.add(bubbleSortView);
        //// frame.add(homeView);
        //frame.setVisible(true);

        //Initialize application's frame
//        AppFrame appFrame = new AppFrame();
        HomeController homeController = new HomeController();
        DataAccess.Run();

    }
}