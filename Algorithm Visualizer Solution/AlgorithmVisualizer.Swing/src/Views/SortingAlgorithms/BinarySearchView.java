package Views.SortingAlgorithms;
import SharedComponents.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Frame;

public class BinarySearchView extends CustomJPanel {

    public BinarySearchView() {
        super("Binary Search");
    }

    public void animatePanels(Frame main, JPanel cards){
        main.add(cards);
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        for(int i = 0; i < cards.getComponentCount(); i++){
            cardLayout.show(cards, Integer.toString(i));
            main.repaint();
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