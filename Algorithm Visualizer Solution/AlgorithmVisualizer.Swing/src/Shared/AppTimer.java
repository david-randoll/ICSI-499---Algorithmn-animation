package Shared;

import Views.IAlgorithmView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppTimer {
    private final IAlgorithmView view;
    private final ITimer model;
    private Timer timer;

    public AppTimer(IAlgorithmView view, ITimer model) {
        this.view = view;
        this.model = model;

        this.timer = new Timer(model.getSpeedValue(), timerAction);
    }

    private ActionListener timerAction = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            view.PaintNewPanelOnScreen();
        }
    };

    public void Start() {
        model.setIsTimerRunning(true);
        view.UpdatePlayPauseButtonText("\u23F8");
        timer.start();
    }

    public void Stop() {
        model.setIsTimerRunning(false);
        view.UpdatePlayPauseButtonText("\u23F5");
        timer.stop();
    }

    public void Reset() {
        model.setCurrentIndex(0);
        timer.restart();
        model.setIsTimerRunning(true);
        view.UpdatePlayPauseButtonText("\u23F8");
    }
    public void setTimerDelay(int value) {
        timer.setDelay(value);
    }
}