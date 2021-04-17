package SharedComponents;

import javax.swing.*;
import java.awt.*;

public class TextBox extends TextArea{

    public TextBox(String placeHolder){
        this.setText(placeHolder);
        this.setVisible(true);
    }
}
