package Controllers;

import Models.SettingsModel;
import Shared.Components.DefaultFrame;
import Views.SettingsView;
import Shared.res.Styles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import DB.ServerConnection;
import com.google.gson.JsonObject;

public class SettingsController implements ActionListener {
    public SettingsView view;
    private SettingsModel model = new SettingsModel();
    private DefaultFrame frame;

    private Color color;
    private Color dataColor;
    private Color backgroundColor;

    private Color titleDef = new Color(0x5D8EFF);
    private Color dataDef = new Color(Color.red.getRGB());
    private Color backgroundDef = new Color(0x343434);

    private String feedback;

    private Map<String, String> map = new HashMap<>();

    public SettingsController(DefaultFrame frame) {
        color = Styles.PAGE_TITLE_FOREGROUNGCOLOR;
        dataColor = Styles.DATA_COLOR;
        backgroundColor = Styles.APP_BACKGROUNDCOLOR;
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

        view.titleColors.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setColor(1);
            }
        });
        this.view.titleColorsButton.addActionListener(this);

        view.DataColor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setColor(2);
            }
        });
        this.view.DataColorSubmit.addActionListener(this);

        view.backgroundColor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setColor(3);
            }
        });
        view.backgroundColorButton.addActionListener(this);

        view.saveAll.addActionListener(this);
        view.def.addActionListener(this);

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
            this.feedback = this.view.feedback.getText();

            //Connecting to Java spring Rest API
            //send data to db
            ServerConnection pt = new ServerConnection();
            try {
                pt.post("http://localhost:8080/home/add", this.feedback);
            }catch(Exception t){
                t.getMessage();
            }
        }
        else if (e.getSource() == this.view.backgroundColorButton) { //background color button
            Styles.APP_BACKGROUNDCOLOR = this.backgroundColor;
            setStyles(backgroundColor , 1);
            JOptionPane.showMessageDialog(null, "Return Home to view the changes");
        }

        else if(e.getSource() == this.view.DataColorSubmit){
            Styles.DATA_COLOR = this.dataColor;
            setStyles(color, 2);
            JOptionPane.showMessageDialog(null, "Return Home to view the changes");
        }
        else if (e.getSource() == this.view.Home) {
            frame.getContentPane().removeAll();
            this.frame.repaint();
            HomeController homeController = new HomeController(this.frame);
        }

        else if(e.getSource() == this.view.saveAll){
            Styles.PAGE_TITLE_FOREGROUNGCOLOR = this.color;
            Styles.DATA_COLOR = this.dataColor;
            Styles.APP_BACKGROUNDCOLOR = this.backgroundColor;

            map.put("foreground", this.color.toString());
            map.put("dataColor", this.dataColor.toString());
            map.put("background", this.backgroundColor.toString());

            Properties prop = new Properties();

            for(Map.Entry<String, String> entry : map.entrySet()){
                prop.put(entry.getKey(), entry.getValue());
            }

            //make stylespref file to save user saved styles
            try {
                File file = new File("Algorithm Visualizer Solution/AlgorithmVisualizer.Swing/src/Shared/res", "stylepref.properties");
                prop.store(new FileOutputStream(file), null);
            }catch(IOException io){
                io.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Styles Saved. Return Home to view the changes");
        }

        else if (e.getSource() == this.view.titleColorsButton){
            Styles.PAGE_TITLE_FOREGROUNGCOLOR = this.color;
            setStyles(color, 3);
            JOptionPane.showMessageDialog(null, "Return Home to view the changes");
        }
        else if(e.getSource() == this.view.def){
            Styles.PAGE_TITLE_FOREGROUNGCOLOR = titleDef;
            Styles.DATA_COLOR = dataDef;
            Styles.APP_BACKGROUNDCOLOR = backgroundDef;

            map.put("foreground", this.titleDef.toString());
            map.put("dataColor", this.dataDef.toString());
            map.put("background", this.backgroundDef.toString());

            Properties prop = new Properties();

            for(Map.Entry<String, String> entry : map.entrySet()){
                prop.put(entry.getKey(), entry.getValue());
            }

            //make stylespref file to save user saved styles
            try {
                File file = new File("Algorithm Visualizer Solution/AlgorithmVisualizer.Swing/src/Shared/res", "stylepref.properties");
                prop.store(new FileOutputStream(file), null);
            }catch(IOException io){
                io.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Return Home to view the changes");

        }
    }

    public void setColor(int flag){
        if(flag == 1) { //title color
            this.color = JColorChooser.showDialog(this.frame, "Select a color", Color.BLUE);

            String hex = "#"+Integer.toHexString(this.color.getRGB()).substring(2);

            this.view.titleColors.setText(hex);

        }

        else if(flag == 2){ //data color
            this.dataColor=JColorChooser.showDialog(this.frame,"Select a color", Color.BLUE);

            String hex = "#"+Integer.toHexString(this.dataColor.getRGB()).substring(2);

            this.view.DataColor.setText(hex);
        }

        else if(flag == 3){ //Background color
            this.backgroundColor=JColorChooser.showDialog(this.frame,"Select a color", Color.BLUE);

            String hex = "#"+Integer.toHexString(this.backgroundColor.getRGB()).substring(2);

            this.view.backgroundColor.setText(hex);
        }

    }

    //Used when styles are individually saved
    public void setStyles(Color c, int flag) {
        if (flag == 1) { //background
            map.put("foreground", this.color.toString());
            map.put("dataColor", this.dataColor.toString());
            map.put("background", c.toString());
        }
        else if (flag == 2) { //datacolor
            map.put("foreground", this.color.toString());
            map.put("dataColor", c.toString());
            map.put("background", this.backgroundColor.toString());
        }
        else if (flag == 3) { //foreground
            map.put("foreground", c.toString());
            map.put("dataColor", this.dataColor.toString());
            map.put("background", this.backgroundColor.toString());
        }
           Properties prop = new Properties();

            for (Map.Entry<String, String> entry : map.entrySet()) {
                prop.put(entry.getKey(), entry.getValue());
            }

            //make stylespref file to save user saved styles
            try {
                File file = new File("Algorithm Visualizer Solution/AlgorithmVisualizer.Swing/src/Shared/res", "stylepref.properties");
                prop.store(new FileOutputStream(file), null);
            } catch (IOException io) {
                io.printStackTrace();
            }
        }



}
