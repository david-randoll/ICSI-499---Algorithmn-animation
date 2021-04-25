package Shared;

import SharedComponents.Frame;

import java.awt.*;

public class AppFrame {

    public static Frame appFrame = new Frame();

    public AppFrame() {
        appFrame.setLayout(new BorderLayout());
        appFrame.pack();
        appFrame.setVisible(true);
    }
}
