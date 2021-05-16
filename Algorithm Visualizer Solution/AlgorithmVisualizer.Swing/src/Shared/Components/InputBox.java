package Shared.Components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class InputBox extends JTextField {

    public InputBox(String placeHolder) {
        this.setText(placeHolder);
        this.setBorder(null);
        this.setBorder(new EmptyBorder(5, 5, 5, 0));
        this.setVisible(true);
    }

}
