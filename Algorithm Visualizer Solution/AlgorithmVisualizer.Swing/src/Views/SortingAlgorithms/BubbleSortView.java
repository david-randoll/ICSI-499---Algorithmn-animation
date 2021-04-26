package Views.SortingAlgorithms;

import Controllers.HomeController;
import Models.SortingAlgorithms.BubbleSortModel;
import Shared.AppFrame;
import Shared.DataAccess;
import SharedComponents.CustomJPanel;
import SharedComponents.Panel;
import SharedComponents.toast;
import res.Styles;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.ArrayList;

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

    BubbleSortModel model;

    public BubbleSortView() {
        super("Bubble Sort");
        speedValue = 1000;
    }

    private ActionListener timerAction = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            CardLayout cardLayout = (CardLayout) model.Panels.getLayout();
            if (currentIndex < model.Panels.getComponentCount()) {
                cardLayout.show(model.Panels, Integer.toString(currentIndex));

                AppFrame.appFrame.repaint();

                currentIndex++;
            }else {
                Stop();
                currentIndex = 0;
                playPauseButton.setText("\u23F5");
            }
        }
    };

    public void animateBubbleSort(BubbleSortModel model) {
        this.model = model;
        AppFrame.appFrame.add(model.Panels, BorderLayout.NORTH);
        AppFrame.appFrame.getContentPane().setBackground(Styles.APP_BACKGROUNDCOLOR);

        InitializeToolBar();
        PaintFirstPanelOnUI();

        AppFrame.appFrame.setBackground(Styles.APP_BACKGROUNDCOLOR);
        AppFrame.appFrame.pack();
        AppFrame.appFrame.setVisible(true);

        timer = new Timer(speedValue, timerAction);
    }

    private void PaintFirstPanelOnUI() {
        CardLayout cardLayout = (CardLayout) model.Panels.getLayout();
        if (currentIndex < model.Panels.getComponentCount()) {
            cardLayout.show(model.Panels, Integer.toString(currentIndex));

            currentIndex++;
        }
    }

    private void InitializeToolBar() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Styles.APP_BACKGROUNDCOLOR);
        buttonPanel.setPreferredSize(new Dimension(screenSize.width, (int) (screenSize.height * 0.15)));

        backToHome = new JButton("Home");

        playPauseButton = new JButton("\u23F5");
        Font unicodeFont = new Font("Code2000", Font.PLAIN, 16);
        playPauseButton.setFont(unicodeFont);

        resetButton = new JButton("\uD83D\uDD03");
        resetButton.setFont(unicodeFont);

        Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
        Font sliderFont = new Font("Arial", Font.PLAIN, 15);

        JLabel label = new JLabel("Faster");
        label.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        table.put (0, label);

        label = new JLabel("0");
        label.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        table.put (1000, label);

        label = new JLabel("Slower");
        label.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        table.put (2000, label);

        speedSlider = new JSlider(0, 2000);
        speedSlider.setLabelTable(table);
        speedSlider.setPaintTrack(true);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.setValue(speedValue);
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
                Stop();
                if(DataAccess.SetData(dataSetTextBox.getText()) == false){
//                    JOptionPane.showMessageDialog(AppFrame.appFrame,"Input is not valid");
                    toast t = new toast("Not valid input! Only comma separated numbers are valid", (int) (screenSize.width * 0.5), (int) (screenSize.height * 0.8));
                    t.showtoast();
                }
                model.Panels.removeAll();
                ArrayList<Panel> panels = model.run(DataAccess.GetData());

                for (int i = 0; i < panels.size(); i++) {
                    model.Panels.add(panels.get(i), Integer.toString(i));
                }//Add all cards to the card panel so we can transition panels easily

                currentIndex = 0;
                playPauseButton.setText("Play");
                AppFrame.appFrame.revalidate();
                AppFrame.appFrame.repaint();
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
                    playPauseButton.setText("\u23F5");
                } else {
                    Start();
                    playPauseButton.setText("\u23F8");
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