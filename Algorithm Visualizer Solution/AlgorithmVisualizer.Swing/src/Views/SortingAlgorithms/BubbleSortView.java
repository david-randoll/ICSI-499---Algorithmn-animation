package Views.SortingAlgorithms;

import Controllers.HomeController;
import Models.SortingAlgorithms.BubbleSortModel;
import Shared.AppFrame;
import Shared.DataAccess;
import SharedComponents.CustomJPanel;
import SharedComponents.toast;
import res.Styles;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BubbleSortView extends CustomJPanel {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int currentIndex = 0;

    JButton backToHome;
    JButton playPauseButton;
    JButton resetButton;
    JSlider speedSlider;
    JTextField dataSetTextBox;
    private JButton changeDatasetButton;

    private boolean isTimerRunning = false;
    private Timer timer;
    private int speedValue;
    private JPanel Panels;

    BubbleSortModel model;

    public BubbleSortView() {
        super("Bubble Sort");
        speedValue = 1000;
    }

    private ActionListener timerAction = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            CardLayout cardLayout = (CardLayout) Panels.getLayout();
            if (currentIndex < Panels.getComponentCount()) {
                cardLayout.show(Panels, Integer.toString(currentIndex));

                AppFrame.appFrame.repaint();

                currentIndex++;
            }else {
                Stop();
                currentIndex = 0;
                playPauseButton.setText("Play");
            }
        }
    };

    public void animateBubbleSort(BubbleSortModel model) {
        this.Panels = model.Panels;
        this.model = model;
        AppFrame.appFrame.add(Panels, BorderLayout.NORTH);
        AppFrame.appFrame.getContentPane().setBackground(Styles.APP_BACKGROUNDCOLOR);

        InitializeToolBar();
        PaintFirstPanelOnUI();

        AppFrame.appFrame.setBackground(Styles.APP_BACKGROUNDCOLOR);
        AppFrame.appFrame.pack();
        AppFrame.appFrame.setVisible(true);

        timer = new Timer(speedValue, timerAction);
    }

    private void PaintFirstPanelOnUI() {
        CardLayout cardLayout = (CardLayout) Panels.getLayout();
        if (currentIndex < Panels.getComponentCount()) {
            cardLayout.show(Panels, Integer.toString(currentIndex));

            currentIndex++;
        }
    }

    private void InitializeToolBar() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Styles.APP_BACKGROUNDCOLOR);
        buttonPanel.setPreferredSize(new Dimension(screenSize.width, (int) (screenSize.height * 0.15)));

        backToHome = new JButton("Home");
        playPauseButton = new JButton("Play");
        resetButton = new JButton("Reset");

        speedSlider = new JSlider(0, 2000);
        // paint the ticks and tracks
        speedSlider.setPaintTrack(true);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.setValue(speedValue);
        // set spacing
        speedSlider.setMajorTickSpacing(500);
        speedSlider.setMinorTickSpacing(5);
        speedSlider.setBackground(Styles.APP_BACKGROUNDCOLOR);
        speedSlider.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        speedSlider.setInverted(true);

        dataSetTextBox = new JTextField();
        dataSetTextBox.setText(DataAccess.GetCommaSeparatedData());
        dataSetTextBox.setPreferredSize(new Dimension(500, 25));

        changeDatasetButton = new JButton("Change DataSet");

        buttonPanel.add(playPauseButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(speedSlider);
        buttonPanel.add(dataSetTextBox);
        buttonPanel.add(changeDatasetButton);
        buttonPanel.add(backToHome);

        AppFrame.appFrame.add(buttonPanel, BorderLayout.SOUTH);

        playPauseButton.addActionListener(pausePlayEventListener());
        resetButton.addActionListener(resetEventListener());
        speedSlider.addChangeListener(speedSliderStateChange());
        backToHome.addActionListener(homePage());
        changeDatasetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(DataAccess.SetData(dataSetTextBox.getText()) == false){
//                    JOptionPane.showMessageDialog(AppFrame.appFrame,"Input is not valid");
                    toast t = new toast("Not valid input! Only comma separated numbers are valid", (int) (screenSize.width * 0.5), (int) (screenSize.height * 0.8));
                    t.showtoast();
                }
            }
        });
    }

    private ActionListener homePage() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Stop();
                AppFrame.appFrame.getContentPane().removeAll();
                AppFrame.appFrame.dispose();
                HomeController homeController = new HomeController();
            }
        };
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

                if (isTimerRunning) {
                    Stop();
                    playPauseButton.setText("Play");
                } else {
                    Start();
                    playPauseButton.setText("Pause");
                }
            }
        };
    }

    public ChangeListener speedSliderStateChange() {
        return new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                speedValue = speedSlider.getValue();
                timer.setDelay(speedValue);
            }
        };
    }

    public void Start() {
        isTimerRunning = true;
        timer.start();
    }

    public void Stop() {
        isTimerRunning = false;
        timer.stop();
    }

    public void Reset() {
        currentIndex = 0;
        speedSlider.setValue(speedValue);
        timer.restart();
        isTimerRunning = true;
    }
}