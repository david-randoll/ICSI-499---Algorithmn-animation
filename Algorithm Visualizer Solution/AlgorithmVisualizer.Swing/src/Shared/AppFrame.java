package Shared;

import Shared.Components.Frame;

import java.awt.*;

public class AppFrame {

    public static Frame appFrame = new Frame();

    public AppFrame() {
        appFrame.setLayout(new BorderLayout());
        appFrame.pack();
        appFrame.setVisible(true);
    }
}
