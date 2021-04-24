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
        //this.setBackground(new Color(Styles.APP_BACKGROUNDCOLOR));
        this.setPreferredSize(new Dimension(500, 600));



    }
}