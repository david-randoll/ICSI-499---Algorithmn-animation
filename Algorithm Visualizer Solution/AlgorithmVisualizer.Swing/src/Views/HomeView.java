package Views;

import SharedComponents.CustomJPanel;
import SharedComponents.SubmitButton;

import javax.swing.*;
import java.awt.*;

public class HomeView extends CustomJPanel {
   public JLabel title = new JLabel();
    public SubmitButton settings = new SubmitButton("Settings");
    public HomeView() {
        super("Algorithm Animation");
        super.setLayout(null);
        settings.setBounds(400, 400, 100, 30);
        super.add(settings);
    }


}