package Shared;

import Models.SortingAlgorithms.BinarySearchModel;
import SharedComponents.Frame;
import Views.SortingAlgorithms.BinarySearchView;

import java.awt.*;

public class AppFrame {

    public static Frame appFrame = new Frame();

    public AppFrame(){
        appFrame.setLayout(new BorderLayout());
        appFrame.pack();
        appFrame.setVisible(true);
    }
}
