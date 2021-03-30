package SharedComponents;

import res.Styles;

import javax.swing.*;
import java.awt.*;

public class CustomJPanel extends JPanel {
    JLabel titleLabel;
    public CustomJPanel(String titleName) {
        titleLabel = new TitleLablel(titleName);
        this.add(this.titleLabel);
        this.setBackground(new Color(Styles.APP_BACKGROUNDCOLOR));
    }
}