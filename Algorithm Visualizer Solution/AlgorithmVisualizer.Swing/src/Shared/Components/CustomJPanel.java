package Shared.Components;

import Shared.res.Styles;

import javax.swing.*;

public class CustomJPanel extends JPanel {
    JLabel titleLabel;

    public CustomJPanel(String titleName) {
        titleLabel = new TitleLabel(titleName);
        this.add(this.titleLabel);
        this.setBackground(Styles.APP_BACKGROUNDCOLOR);
    }
}