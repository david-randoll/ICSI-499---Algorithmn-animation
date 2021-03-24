package Views.SortingAlgorithms;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import SharedComponents.TitleLablel;

public class BubbleSortView extends JPanel {
    JLabel title = new TitleLablel("Bubble Sort");
    public BubbleSortView() {
        this.add(title);
        this.setBackground(new Color(0x343434));
    }
}