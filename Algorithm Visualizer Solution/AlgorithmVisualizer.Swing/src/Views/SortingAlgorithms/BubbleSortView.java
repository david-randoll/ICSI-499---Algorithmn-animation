package Views.SortingAlgorithms;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Models.SortingAlgorithms.BinarySearchModel;
import Models.SortingAlgorithms.BubbleSortModel;
import Shared.AppFrame;
import SharedComponents.CustomJPanel;
import SharedComponents.TitleLablel;

public class BubbleSortView extends CustomJPanel {
    public BubbleSortView() {
        super("Bubble Sort");
    }
    public void animatePanels(BubbleSortModel model) {

        AppFrame.appFrame.add(model.Panels);
        CardLayout cardLayout = (CardLayout) model.Panels.getLayout();
        for (int i = 0; i < model.Panels.getComponentCount(); i++) {
            cardLayout.show(model.Panels, Integer.toString(i));
            AppFrame.appFrame.repaint();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

}