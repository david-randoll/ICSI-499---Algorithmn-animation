package SharedComponents;

import res.Styles;

import javax.swing.*;

public class Frame extends JFrame {

    public Frame() {
        this.setBackground(Styles.APP_BACKGROUNDCOLOR);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}