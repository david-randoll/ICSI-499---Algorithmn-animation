package Views.Algorithms;

import Models.Algorithms.AlgorithmModel;
import Shared.AppFrame;
import Shared.AppTimer;
import Shared.DataAccess;
import Shared.res.Styles;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class AlgorithmView extends JPanel implements IAlgorithmView {
    private JButton previousButton;
    private JButton nextButton;
    private JButton playPauseButton;
    private JButton resetButton;
    private JSlider speedSlider;
    private JTextField dataSetTextBox;
    private JButton backToHome;
    private JButton changeDataSetButton;
    JPanel toolBarPanel;

    private AppTimer timer;
    private AlgorithmModel model;

    public AlgorithmView(AlgorithmModel model, int defaultSpeed) {
        this.model = model;
        model.setSpeedValue(defaultSpeed);
        InitializeToolBar();
        InitializeBackButton();
    }

    public void PaintNewPanelOnScreen() {
        CardLayout cardLayout = (CardLayout) model.Panels.getLayout();
        if (model.getCurrentIndex() >= 0 && model.getCurrentIndex() < model.Panels.getComponentCount()) {
            cardLayout.show(model.Panels, Integer.toString(model.getCurrentIndex()));

            AppFrame.appFrame.repaint();

            model.setCurrentIndex(model.getCurrentIndex() + 1);
        } else {
            timer.Stop();
            model.setCurrentIndex(0);
            UpdatePlayPauseButtonText("\u23F5");
        }
    }

    public void runAnimation() {
        AppFrame.appFrame.add(toolBarPanel, BorderLayout.SOUTH);
        AppFrame.appFrame.setBackground(Styles.APP_BACKGROUNDCOLOR);
        AppFrame.appFrame.pack();
        AppFrame.appFrame.setVisible(true);

        this.timer = new AppTimer(this, model);
    }

    private void InitializeBackButton() {
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(Styles.APP_BACKGROUNDCOLOR);
        topPanel.setPreferredSize(new Dimension(AppFrame.getScreenWidth(), (int) (AppFrame.getScreenHeight() * 0.10)));

        backToHome = new JButton("\uD83E\uDC44");
        backToHome.setFont(Styles.MEDIA_CONTROL_FONT);
        int buttonFontSize = Styles.MEDIA_CONTROL_FONT.getSize();
        topPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 0, 0));
        backToHome.setPreferredSize(new Dimension(buttonFontSize * 3, buttonFontSize + 10));
        topPanel.add(backToHome);

        AppFrame.appFrame.add(topPanel, BorderLayout.NORTH);
    }

    private void InitializeToolBar() {
        toolBarPanel = new JPanel();
        toolBarPanel.setBackground(Styles.APP_BACKGROUNDCOLOR);
        toolBarPanel.setPreferredSize(new Dimension(AppFrame.getScreenWidth(), (int) (AppFrame.getScreenHeight() * 0.13)));

        playPauseButton = new JButton("\u23F5");
        playPauseButton.setFont(Styles.MEDIA_CONTROL_FONT);

        resetButton = new JButton("\uD83D\uDD03");
        resetButton.setFont(Styles.MEDIA_CONTROL_FONT);

        previousButton = new JButton("\u23EA");
        previousButton.setFont(Styles.MEDIA_CONTROL_FONT);

        nextButton = new JButton("\u23E9");
        nextButton.setFont(Styles.MEDIA_CONTROL_FONT);

        Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();

        JLabel label = new JLabel("Faster");
        label.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        table.put(0, label);

        label = new JLabel("0");
        label.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        table.put(1000, label);

        label = new JLabel("Slower");
        label.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        table.put(2000, label);

        speedSlider = new JSlider(0, 2000);
        speedSlider.setLabelTable(table);
        speedSlider.setPaintTrack(true);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.setValue(model.getSpeedValue());
        speedSlider.setMajorTickSpacing(500);
        speedSlider.setMinorTickSpacing(5);
        speedSlider.setBackground(Styles.APP_BACKGROUNDCOLOR);
        speedSlider.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        speedSlider.setInverted(true);
        speedSlider.setBorder(new EmptyBorder(0, 0, 0, 50));
        speedSlider.setPreferredSize(new Dimension(340, 40));

        label = new JLabel("");
//        label.setForeground(Styles.COLOR_WHITE);
        label.setBorder(new EmptyBorder(0, 50, 0, 0));
//        label.setFont(Styles.APP_FONT);

        dataSetTextBox = new JTextField();
        dataSetTextBox.setText(DataAccess.GetCommaSeparatedData());
        dataSetTextBox.setPreferredSize(new Dimension(290, 30));
        dataSetTextBox.setBorder(new EmptyBorder(5, 5, 5, 0));

        changeDataSetButton = new JButton("Change DataSet");
        changeDataSetButton.setPreferredSize(new Dimension(130, 30));

        toolBarPanel.add(speedSlider);

        toolBarPanel.add(previousButton);
        toolBarPanel.add(playPauseButton);
        toolBarPanel.add(nextButton);
        toolBarPanel.add(resetButton);

        toolBarPanel.add(label);
        toolBarPanel.add(dataSetTextBox);
        toolBarPanel.add(changeDataSetButton);
    }

    /*
        Add event listener
     */
    public void addNextButtonListener(ActionListener listener) {
        nextButton.addActionListener(listener);
    }

    public void addPreviousButtonListener(ActionListener listener) {
        previousButton.addActionListener(listener);
    }

    public void addPlayPauseButtonListener(ActionListener listener) {
        playPauseButton.addActionListener(listener);
    }

    public void addResetButtonListener(ActionListener listener) {
        resetButton.addActionListener(listener);
    }

    public void addSpeedSliderListener(ChangeListener listener) {
        speedSlider.addChangeListener(listener);
    }

    public void addDataSetButtonListener(ActionListener listener) {
        changeDataSetButton.addActionListener(listener);
    }

    public void addHomeButtonListener(ActionListener listener) {
        backToHome.addActionListener(listener);
    }

    /*
     App timer
  */
    public AppTimer getTimer() {
        return timer;
    }

    public void setTimer(AppTimer timer) {
        this.timer = timer;
    }

    /*
        update play/pause button text
    */
    public void UpdatePlayPauseButtonText(String s) {
        this.playPauseButton.setText(s);//play
    }

    /*
        Data set textbox
     */
    public JTextField getDataSetTextBox() {
        return this.dataSetTextBox;
    }

    public void setDataSetTextBox(String text) {
        this.dataSetTextBox.setText(text);
    }

    /*
        set data button
     */
    public JButton getChangeDataSetButton() {
        return changeDataSetButton;
    }

    /*
        speed slider
     */
    public int getSpeedSliderValue() {
        return this.speedSlider.getValue();
    }

    /*
        get the toolbar panel
     */
    public JPanel getToolBarPanel() {
        return toolBarPanel;
    }
}
