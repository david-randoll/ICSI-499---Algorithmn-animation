import Shared.DataAccess;
import res.Styles;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class BinarySearch {

    public static void main(String[] args){
        DataAccess dataAccess = new DataAccess();
        int [] data = dataAccess.GetData();
        Arrays.sort(data);
        int searchFor = 6; //0-100

        Frame main = new Frame();
        JPanel cards = new JPanel(new CardLayout()); //create panel with card layout
        ArrayList<Panel> panels  = binarySearch(data, searchFor);

        for(int i = 0; i < panels.size(); i++){
            cards.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
        main.add(cards);

        main.setVisible(true); //Set the frame to visible
        animatePanels(main, cards);
    }

    static void animatePanels(Frame main, JPanel cards){
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        for(int i = 0; i < cards.getComponentCount(); i++){
            main.setBackground(new Color(Styles.APP_BACKGROUNDCOLOR));
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

    static ArrayList<Panel> binarySearch(int arr[], int x) {

        ArrayList<Panel> output = new ArrayList<>();

        int l = 0, r = arr.length - 1;

        Panel firstPanel = new Panel(arr, null);
        output.add(firstPanel);

        while (l <= r) {

            int m = l + (r - l) / 2;

            Panel newPanel = new Panel(arr, m);
            output.add(newPanel);

            // Check if x is present at mid
            if (arr[m] == x)
                return output;

            // If x greater, ignore left half
            if (arr[m] < x){
                l = m + 1;
            }
                // If x is smaller, ignore right half
            else
                r = m - 1;

        }

        // if we reach here, then element was
        // not present
        return output;
    }

    static class Frame extends JFrame {

        public Frame() {
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }
}

