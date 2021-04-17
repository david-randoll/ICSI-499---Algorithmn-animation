
package SharedComponents;

import javax.swing.JTextField;

public class InputBox extends JTextField{

    public InputBox(String placeHolder){
        this.setText(placeHolder);
        this.setLayout(null);
        this.setVisible(true);
    }

}
