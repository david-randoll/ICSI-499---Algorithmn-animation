package Views.SortingAlgorithms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Models.SortingAlgorithms.BubbleSortModel;
import Shared.AppFrame;
import Shared.DataAccess;
import SharedComponents.CustomJPanel;
import SharedComponents.Panel;
import res.Styles;

public class BubbleSortView extends CustomJPanel {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int currentIndex = 0;
    boolean IsPause = false;

    JButton playPauseButton;
    JButton resetButton;
    JSlider speedSlider;
    JTextField dataSetTextBox;
    private boolean isTimerRunning = false;
    private Timer timer;
    private int speedValue;
    private JPanel Panels;

    BubbleSortModel model;

    public BubbleSortView() {
        super("Bubble Sort");
        speedValue = 1000;
    }

    private ActionListener timerAction = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            CardLayout cardLayout = (CardLayout) Panels.getLayout();
            if(currentIndex < Panels.getComponentCount()){
                cardLayout.show(Panels, Integer.toString(currentIndex));

                AppFrame.appFrame.repaint();

                currentIndex++;
            }
        }
    };

    public void animateBubbleSort(BubbleSortModel model){
        this.Panels = model.Panels;
        this.model = model;
        AppFrame.appFrame.add(Panels,BorderLayout.NORTH);

        InitializeToolBar();
        PaintFirstPanelOnUI();

//        AppFrame.appFrame.setBackground(Styles.APP_BACKGROUNDCOLOR);
        AppFrame.appFrame.pack();
        AppFrame.appFrame.setVisible(true);

        timer = new Timer(speedValue,timerAction);
    }

    private void PaintFirstPanelOnUI() {
        CardLayout cardLayout = (CardLayout) Panels.getLayout();
        if(currentIndex < Panels.getComponentCount()){
            cardLayout.show(Panels, Integer.toString(currentIndex));

            currentIndex++;
        }
    }

    private void InitializeToolBar() {
        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Styles.APP_BACKGROUNDCOLOR);
        buttonPanel.setPreferredSize(new Dimension(screenSize.width, (int) (screenSize.height * 0.15)));

        playPauseButton = new JButton("Play");
        resetButton = new JButton("Reset");

        speedSlider = new JSlider(0,2000);
        // paint the ticks and tracks
        speedSlider.setPaintTrack(true);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.setValue(speedValue);
        // set spacing
        speedSlider.setMajorTickSpacing(500);
        speedSlider.setMinorTickSpacing(5);

        dataSetTextBox = new JTextField();
        dataSetTextBox.setText(model.dataAccess.GetCommaSeparatedData());
        dataSetTextBox.setPreferredSize(new Dimension(500,25));

        buttonPanel.add(playPauseButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(speedSlider);
        buttonPanel.add(dataSetTextBox);

        AppFrame.appFrame.add(buttonPanel,BorderLayout.SOUTH);

        playPauseButton.addActionListener(pausePlayEventListener());
        resetButton.addActionListener(resetEventListener());
        speedSlider.addChangeListener(speedSliderStateChange());
    }

    private ActionListener resetEventListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Reset();
            }
        };
    }

    private ActionListener pausePlayEventListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(isTimerRunning){
                    Stop();
                    playPauseButton.setText("Play");
                }else{
                    Start();
                    playPauseButton.setText("Pause");
                }
            }
        };
    }
    public ChangeListener speedSliderStateChange()
    {
        return new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                speedValue = speedSlider.getValue();
                timer.setDelay(speedValue);
            }
        };
    }

    public void Start(){
        isTimerRunning = true;
        timer.start();
    }
    public void Stop(){
        isTimerRunning = false;
        timer.stop();
    }
    public void Reset(){
        currentIndex = 0;
        speedSlider.setValue(speedValue);
        timer.restart();
        isTimerRunning = true;
    }


    public void animatePanels(BubbleSortModel model) {
        initToolBar(model);

        AppFrame.appFrame.add(model.Panels);
        CardLayout cardLayout = (CardLayout) model.Panels.getLayout();
        while (currentIndex < model.Panels.getComponentCount()){
            cardLayout.show(model.Panels, Integer.toString(currentIndex));

            AppFrame.appFrame.repaint();
            if(IsPause){
                break;
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            currentIndex++;
        }
    }
    private void initToolBar(BubbleSortModel model){
        for (int i = currentIndex; i < model.Panels.getComponentCount(); i++) {
            Panel panel = (Panel) model.Panels.getComponent(i);
            panel.setLayout(new BorderLayout());

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

            playPauseButton = new JButton("Play");
            buttonPanel.add(playPauseButton);

            panel.add(buttonPanel,BorderLayout.NORTH);

            playPauseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    if(IsPause){
                        IsPause = false;
                        playPauseButton.setText("Play");
                    }else{
                        playPauseButton.setText("Pause");
                        IsPause = true;
                    }
                }
            });
        }
    }
}