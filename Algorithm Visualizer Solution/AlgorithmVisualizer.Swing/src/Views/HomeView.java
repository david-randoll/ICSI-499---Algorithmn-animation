package Views;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeView extends JPanel {
    private JButton bubbleSort = new JButton("Bubble Sort");
    public HomeView() {
        this.add(bubbleSort);
    }
}