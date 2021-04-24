package SharedComponents;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class SubmitButton extends JButton {
    JButton button;
    public SubmitButton(String buttonText){
        button = new JButton();
        button.setLayout(null);
        this.setText(buttonText);
        this.setVisible(true);
       // this.setLocation(100,100);
       // this.add(this.button);
       // this.setLayout(null);
        //this.setVisible(true);
    }
}
