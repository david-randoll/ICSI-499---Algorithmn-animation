package Views;

import javax.swing.JButton;
import javax.swing.JPanel;

import SharedComponents.TextBox;

public class SettingsView extends JPanel {

    public JButton submit = new JButton("Submit");
    public JButton fontSizeSubmit = new JButton("Submit");
    public JButton fontColorSubmit = new JButton("Submit");
    private TextBox feedbackForm = new TextBox("Enter feedback here");
    private InputBox fontSize = new InputBox("Enter size");
    private InputBox fontColor = new InputBox("Enter color");

    public SettingsView(){
        this.add(submit);
        this.add(fontSizeSubmit);
        this.add(fontColorSubmit);
        this.add(feedbackForm);
        this.add(fontSize);
        this.add(fontColor);
    }
}
