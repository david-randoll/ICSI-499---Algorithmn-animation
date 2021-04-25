package Views;

import SharedComponents.CustomJPanel;
import SharedComponents.InputBox;
import SharedComponents.TextBox;

import javax.swing.*;


public class SettingsView extends CustomJPanel {

    public JButton submit = new JButton("Submit");
    public JButton fontSizeSubmit = new JButton("Submit");
    public JButton fontColorSubmit = new JButton("Submit");
    public TextBox feedbackForm = new TextBox("Enter feedback here");
    public InputBox fontSize = new InputBox("Enter size");
    public InputBox fontColor = new InputBox("Enter color");
    public JButton Home = new JButton("Back To Home");

    public SettingsView() {
        super("Settings");
        super.setLayout(null);
        submit.setBounds(100, 100, 50, 50);
        fontSizeSubmit.setBounds(200, 200, 50, 50);
        Home.setBounds(300, 300, 100, 100);
        super.add(submit);
        super.add(fontSizeSubmit);
        super.add(fontColorSubmit);
        super.add(feedbackForm);
        super.add(fontSize);
        super.add(fontColor);
        super.add(Home);
        super.setVisible(true);
    }


}
