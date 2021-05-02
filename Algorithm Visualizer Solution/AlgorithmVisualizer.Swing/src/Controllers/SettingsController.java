package Controllers;

import Models.SettingsModel;
import Shared.Components.DefaultFrame;
import Views.SettingsView;
import res.Styles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingsController implements ActionListener {
    public SettingsView view;
    private SettingsModel model = new SettingsModel();
    private DefaultFrame frame;
    private Color color;

    public SettingsController(DefaultFrame frame) {
        this.frame = frame;
        InitView();
        InitController();
    }


    private void InitView() {
        view = new SettingsView();
        this.frame.add(this.view);
        this.frame.setVisible(true);
        this.frame.repaint();
    }

    private void InitController() {

        this.view.submit.addActionListener(this);
        this.view.Home.addActionListener(this);
        this.view.titleColorsButton.addActionListener(this);

        view.titleColors.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setColor();
            }
        });
        view.feedback.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view.feedback.setText("");
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        //Feedback form submit button
        if (e.getSource() == this.view.submit) {
            //String feedback = this.view.feedbackForm.getText();

            //Connecting to Java spring Rest API
            //send data to db
        } else if (e.getSource() == this.view.fontSizeSubmit) { //fontSize button
            Styles.PAGE_TITLE_FONTSIZE = this.view.fontSize.getColumns();
        } else if (e.getSource() == this.view.fontColorSubmit) { //fontColor Color

        } else if (e.getSource() == this.view.Home) {
            frame.getContentPane().removeAll();
            this.frame.repaint();
            HomeController homeController = new HomeController(this.frame);
        }
        else if (e.getSource() == this.view.titleColors){
            this.color=JColorChooser.showDialog(this.frame,"Select a color", Color.BLUE);
            this.view.titleColors.setText(color.toString());
        }
        else if (e.getSource() == this.view.titleColorsButton){
            Styles.PAGE_TITLE_FOREGROUNGCOLOR = color;
            JOptionPane.showMessageDialog(null, "Return Home to view the changes");
        }
    }

    public void setColor(){
        this.color=JColorChooser.showDialog(this.frame,"Select a color", Color.BLUE);
        this.view.titleColors.setText(color.toString());
    }

}
