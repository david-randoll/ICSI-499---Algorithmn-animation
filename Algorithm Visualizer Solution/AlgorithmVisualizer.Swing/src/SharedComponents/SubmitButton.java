package SharedComponents;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class SubmitButton extends JButton {
    JButton button;
    public SubmitButton(String buttonText){
        button = new JButton();
        button.setAlignmentX(CENTER);
        button.setAlignmentY(CENTER);
        this.setText(buttonText);
        this.setVisible(true);
    }
}
