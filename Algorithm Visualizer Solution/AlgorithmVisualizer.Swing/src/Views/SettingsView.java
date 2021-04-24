package Views;

import javax.swing.*;

import SharedComponents.*;


public class SettingsView extends JPanel {

    JPanel panel;
    public JButton submit = new JButton("Submit");
    public JButton fontSizeSubmit = new JButton("Submit");
    public JButton fontColorSubmit = new JButton("Submit");
    public TextBox feedbackForm = new TextBox("Enter feedback here");
    public InputBox fontSize = new InputBox("Enter size");
    public InputBox fontColor = new InputBox("Enter color");

    public SettingsView(){
        panel = new JPanel();
        panel.add(submit);
        this.add(this.panel);
    }
}
