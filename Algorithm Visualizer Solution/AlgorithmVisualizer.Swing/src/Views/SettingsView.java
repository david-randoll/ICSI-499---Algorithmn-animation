package Views;

import javax.swing.JButton;
import javax.swing.JPanel;

import SharedComponents.*;


public class SettingsView extends JPanel {

    public JButton submit = new JButton("Submit");
    public JButton fontSizeSubmit = new JButton("Submit");
    public JButton fontColorSubmit = new JButton("Submit");
    public TextBox feedbackForm = new TextBox("Enter feedback here");
    public InputBox fontSize = new InputBox("Enter size");
    public InputBox fontColor = new InputBox("Enter color");

    public SettingsView(){
        JPanel panel = new JPanel();
        panel.add(submit);
        panel.add(fontSizeSubmit);
        panel.add(fontColorSubmit);
        panel.add(feedbackForm);
        panel.add(fontSize);
        panel.add(fontColor);
    }
}
