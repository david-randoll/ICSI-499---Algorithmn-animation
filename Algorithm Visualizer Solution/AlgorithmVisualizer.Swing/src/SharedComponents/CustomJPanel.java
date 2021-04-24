package SharedComponents;

import res.Styles;

import javax.swing.*;
import java.awt.*;

public class CustomJPanel extends JPanel {
    JLabel titleLabel;
    public CustomJPanel(String titleName, FlowLayout flow) {
        titleLabel = new TitleLablel(titleName);
        this.setLayout(null);
        titleLabel.setLocation(250,50);
        this.add(this.titleLabel);
        this.setBackground(Styles.APP_BACKGROUNDCOLOR);
    }
}