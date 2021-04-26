package Views.SortingAlgorithms;

import Controllers.HomeController;
import Controllers.SortingAlgorithms.BinarySearchController;
import Models.SortingAlgorithms.BinarySearchModel;
import Shared.AppFrame;
import Shared.DataAccess;
import SharedComponents.CustomJPanel;
import res.Styles;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

public class BinarySearchView extends CustomJPanel {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int currentIndex = 0;
    boolean IsPause = false;

    JButton backToHome;
    JButton playPauseButton;
    JButton resetButton;
    JButton searchValueSubmit;
    JSlider speedSlider;
    JTextField dataSetTextBox;
    JTextField searchTextBox;
    private boolean isTimerRunning = false;
    private Timer timer;
    private int speedValue;
    //private JPanel Panels;

    BinarySearchModel model;

    public BinarySearchView() {
        super("Binary Search");
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

    public void animateBinarySearch(BinarySearchModel model) {
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
        JPanel toolBarPanel = new JPanel();
        toolBarPanel.setBackground(Styles.APP_BACKGROUNDCOLOR);
        toolBarPanel.setPreferredSize(new Dimension(screenSize.width, (int) (screenSize.height * 0.15)));

        backToHome = new JButton("Home");

        playPauseButton = new JButton("\u23F5");
        Font unicodeFont = new Font("Code2000", Font.PLAIN, 16);
        playPauseButton.setFont(unicodeFont);

        resetButton = new JButton("\uD83D\uDD03");
        resetButton.setFont(unicodeFont);

        searchValueSubmit = new JButton("Submit");

        Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
        Font sliderFont = new Font("Arial", Font.PLAIN, 15);

        JLabel label = new JLabel("Faster");
        label.setForeground(Color.red);
        table.put (0, label);

        label = new JLabel("0");
        label.setForeground(Color.red);
        table.put (1000, label);

        label = new JLabel("Slower");
        label.setForeground(Color.red);
        table.put (2000, label);

        speedSlider = new JSlider(0, 2000);
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

        searchTextBox = new JTextField();
        searchTextBox.setText(Integer.toString(model.getSearchValue()));

        toolBarPanel.add(playPauseButton);
        toolBarPanel.add(resetButton);
        toolBarPanel.add(speedSlider);
        toolBarPanel.add(dataSetTextBox);
        toolBarPanel.add(searchTextBox);
        toolBarPanel.add(searchValueSubmit);
        toolBarPanel.add(backToHome);

        AppFrame.appFrame.add(toolBarPanel, BorderLayout.SOUTH);

        playPauseButton.addActionListener(pausePlayEventListener());
        resetButton.addActionListener(resetEventListener());
        searchValueSubmit.addActionListener(newSearchValueListener());
        speedSlider.addChangeListener(speedSliderStateChange());
        backToHome.addActionListener(homePage());
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

    private ActionListener newSearchValueListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int newSearchValue = Integer.parseInt(searchTextBox.getText());
                model.Panels.removeAll();
                DataAccess access = new DataAccess();
                ArrayList<SharedComponents.Panel> panels = model.run(DataAccess.GetSortedData(), newSearchValue);
                model.setSearchValue(newSearchValue);

                for (int i = 0; i < panels.size(); i++) {
                    model.Panels.add(panels.get(i), Integer.toString(i));
                }//Add all cards to the card panel so we can transition panels easily

                Reset();
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