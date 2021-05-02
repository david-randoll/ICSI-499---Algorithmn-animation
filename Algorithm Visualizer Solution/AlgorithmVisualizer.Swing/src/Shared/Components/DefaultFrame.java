package Shared.Components;

import res.Styles;

import javax.swing.*;

public class DefaultFrame extends JFrame {

    public DefaultFrame() {
        this.setBackground(Styles.APP_BACKGROUNDCOLOR);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 700);
        this.setLayout(null);
        this.setResizable(false);
    }

}
