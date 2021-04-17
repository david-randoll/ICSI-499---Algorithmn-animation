package Views;

import javax.swing.JButton;
import javax.swing.JPanel;

import SharedComponents.TextBox;

public class SettingsView extends JPanel {

    private JButton submit = new JButton("Submit");
    private TextBox feedbackForm = new TextBox("Enter feedback here");

    public SettingsView(){
        this.add(submit);
    }
}
