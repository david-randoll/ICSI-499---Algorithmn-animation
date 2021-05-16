import Controllers.HomeController;
import Shared.DataAccess;
import Shared.*;
import Shared.res.Styles;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;


public class Startup {
    public static void main(String[] args) {
        DataAccess.Run();

        //Get saved styles
        Map<String, String> map = new HashMap<>();
        Properties prop = new Properties();

        try {
            File file = new File("Algorithm Visualizer Solution/AlgorithmVisualizer.Swing/src/Shared/res/", "stylepref.properties");
            prop.load(new FileInputStream(file));
            for(String key : prop.stringPropertyNames()){
                map.put(key, prop.getProperty(key).toString());
            }
            Scanner s1 = new Scanner(map.get("foreground"));
            s1.useDelimiter("\\D+");
            Color c1 = new Color(s1.nextInt(), s1.nextInt(), s1.nextInt());
            Styles.PAGE_TITLE_FOREGROUNGCOLOR = c1;

            Scanner s2 = new Scanner(map.get("dataColor"));
            s2.useDelimiter("\\D+");
            Color c2 = new Color(s2.nextInt(), s2.nextInt(), s2.nextInt());
            Styles.DATA_COLOR = c2;

            Scanner s3 = new Scanner(map.get("background"));
            s3.useDelimiter("\\D+");
            Color c3 = new Color(s3.nextInt(), s3.nextInt(), s3.nextInt());
            Styles.APP_BACKGROUNDCOLOR = c3;

        }catch (IOException io){
            io.printStackTrace();
        }
        HomeController homeController = new HomeController();

    }
}