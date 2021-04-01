package SharedComponents;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class SubmitButton extends JButton {

    public SubmitButton(String buttonText){
        this.setText(buttonText);
        this.setLayout(null);
        this.setVisible(true);
    }
}
