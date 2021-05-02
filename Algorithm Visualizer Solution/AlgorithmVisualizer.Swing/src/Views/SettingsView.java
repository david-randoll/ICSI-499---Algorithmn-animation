package Views;

import Shared.Components.HomeSettingsLabel;
import Shared.Components.InputBox;
import Shared.res.Styles;

import javax.swing.*;
import java.awt.*;


public class SettingsView extends JPanel {
    private HomeSettingsLabel title = new HomeSettingsLabel("Settings");
    public JButton titleColorsButton = new JButton("Save");
    public InputBox titleColors = new InputBox("");
    public JLabel titleColorsLabel = new JLabel("Headings Color");
    public JButton submit = new JButton("Submit");
    public JButton fontSizeSubmit = new JButton("Submit");
    public JButton fontColorSubmit = new JButton("Submit");
    public InputBox fontSize = new InputBox("Enter size");
    public InputBox fontColor = new InputBox("Enter color");
    public JButton Home = new JButton("Home");
    public JTextArea feedback = new JTextArea(5, 20);

    public SettingsView() {
        //Panel styles
        title.setBounds(100, 0, 700, 200);
        super.add(title);
        super.setLayout(null);
        super.setBackground(Styles.APP_BACKGROUNDCOLOR);
        super.setSize(800, 700);

        titleColorsLabel.setBounds(100, 200, 100, 25);
        titleColorsLabel.setFont(new Font(this.getFont().getFamily(), Font.PLAIN, 15));
        titleColorsLabel.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        titleColors.setBounds(225, 200, 100, 25);
        titleColorsButton.setBounds(350, 200, 75, 25);

        titleColorsLabel.setBounds(100, 200, 100, 25);
        titleColorsLabel.setFont(new Font(this.getFont().getFamily(), Font.PLAIN, 15));
        titleColorsLabel.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        titleColors.setBounds(225, 200, 100, 25);
        titleColorsButton.setBounds(350, 200, 75, 25);



        submit.setBounds(100, 565, 100, 25);
        Home.setBounds(675, 625, 100, 30);
        feedback.setText("Enter feedback");
        feedback.setBounds(100, 450, 575, 100);

        super.add(submit);
        super.add(feedback);
        super.add(Home);
        super.add(titleColorsLabel);
        super.add(titleColors);
        super.add(titleColorsButton);
        super.setVisible(true);
    }


}
