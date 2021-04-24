package Views;

import SharedComponents.CustomJPanel;
import SharedComponents.SubmitButton;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JPanel {
   // private JButton bubbleSort = new JButton("Bubble Sort");
    public SubmitButton settings = new SubmitButton("Settings");
    public CustomJPanel panel;
    public HomeView() {
        panel = new CustomJPanel("Algorithm Animation",new FlowLayout(FlowLayout.LEFT,0,0));
        //Settings button
        settings.setLayout(null);
        settings.setLocation( 50, 10);
        panel.add(settings);
        this.add(this.panel);
       // this.add(bubbleSort);
    }


}