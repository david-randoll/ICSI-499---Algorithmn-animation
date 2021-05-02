package Shared.Components;

import javax.swing.*;


public class InputBox extends JTextField {

    public InputBox(String placeHolder) {
        this.setText(placeHolder);
        this.setBorder(null);
        this.setVisible(true);
    }

}
