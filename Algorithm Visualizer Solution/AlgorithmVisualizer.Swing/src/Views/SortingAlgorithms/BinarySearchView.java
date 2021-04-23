package Views.SortingAlgorithms;
import Models.SortingAlgorithms.BinarySearchModel;
import Shared.AppFrame;
import SharedComponents.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Frame;

public class BinarySearchView extends CustomJPanel {

    public BinarySearchView() {
        super("Binary Search");
    }

    public void animatePanels(BinarySearchModel model){

        AppFrame.appFrame.add(model.Panels);
        CardLayout cardLayout = (CardLayout) model.Panels.getLayout();
        for(int i = 0; i < model.Panels.getComponentCount(); i++){
            cardLayout.show(model.Panels, Integer.toString(i));
            AppFrame.appFrame.repaint();
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
    }

}