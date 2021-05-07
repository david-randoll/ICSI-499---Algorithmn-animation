package Views;

import Shared.Components.HomeSettingsLabel;
import Shared.Components.InputBox;
import Shared.res.Styles;

import javax.swing.*;
import java.awt.*;


public class SettingsView extends JPanel {
    private final HomeSettingsLabel title = new HomeSettingsLabel("Settings");

    public InputBox titleColors = new InputBox("");
    public JLabel titleColorsLabel = new JLabel("Title Color");
    public JButton titleColorsButton = new JButton("Save");

    public InputBox backgroundColor = new InputBox("");
    public JLabel backgroundColorLabel = new JLabel("Background");
    public JButton backgroundColorButton = new JButton("Save");

    public JButton fontSizeSubmit = new JButton("Submit");;
    public InputBox fontSize = new InputBox("Enter size");

    public JLabel DataColorLabel = new JLabel("Data Color");
    public InputBox DataColor = new InputBox("");
    public JButton DataColorSubmit = new JButton("Save");

    public JButton saveAll = new JButton("Save All Styles");

    public JTextArea feedback = new JTextArea(5, 20);
    public JButton submit = new JButton("Submit");

    public JButton Home = new JButton("Home");

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

        backgroundColorLabel.setBounds(100, 250, 100, 25);
        backgroundColorLabel.setFont(new Font(this.getFont().getFamily(), Font.PLAIN, 15));
        backgroundColorLabel.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        backgroundColor.setBounds(225,250,100,25);
        backgroundColorButton.setBounds(350,250,75,25);

        DataColorLabel.setBounds(100, 300, 100, 25);
        DataColorLabel.setFont(new Font(this.getFont().getFamily(), Font.PLAIN, 15));
        DataColorLabel.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        DataColor.setBounds(225,300,100,25);
        DataColorSubmit.setBounds(350,300,75,25);

        saveAll.setBounds(100, 350, 150, 25);


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
        super.add(backgroundColorLabel);
        super.add(backgroundColor);
        super.add(backgroundColorButton);
        super.add(DataColorLabel);
        super.add(DataColor);
        super.add(DataColorSubmit);
        super.add(saveAll);
        super.setVisible(true);
    }


}
