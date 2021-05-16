package Shared;

import Shared.Components.Frame;

import java.awt.*;

public class AppFrame {

    public static Frame appFrame = new Frame();

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static boolean isMacOs = System.getProperty("os.name").toLowerCase().startsWith("mac os x");

    public AppFrame() {
        appFrame.setLayout(new BorderLayout());
        appFrame.pack();
        appFrame.setVisible(true);
    }

    public static int getScreenHeight() {
        return screenSize.height;
    }
    public static int getScreenWidth() {
        return screenSize.width;
    }
}
