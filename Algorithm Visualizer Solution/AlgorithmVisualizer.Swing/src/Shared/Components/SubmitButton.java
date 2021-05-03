package Shared.Components;

import javax.swing.*;

public class SubmitButton extends JButton {
    JButton button;

    public SubmitButton(String buttonText) {
        button = new JButton();
        button.setAlignmentX(CENTER);
        button.setAlignmentY(CENTER);
        this.setText(buttonText);
        this.setVisible(true);
    }
}
