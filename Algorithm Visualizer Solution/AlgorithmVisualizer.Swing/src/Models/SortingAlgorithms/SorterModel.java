package Models.SortingAlgorithms;

import javax.swing.*;
import java.awt.*;

public class SorterModel implements ISorterModel {
    public JPanel Panels = new JPanel(new CardLayout());

    private boolean isTimerRunning = false;
    private int speedValue;
    private int currentIndex = 0;

    @Override
    public boolean isTimerRunning() {
        return this.isTimerRunning;
    }

    @Override
    public void setIsTimerRunning(boolean isTimerRunning) {
        this.isTimerRunning = isTimerRunning;
    }

    @Override
    public int getSpeedValue() {
        return this.speedValue;
    }

    @Override
    public void setSpeedValue(int speedValue) {
        this.speedValue = speedValue;
    }

    @Override
    public int getCurrentIndex() {
        return this.currentIndex;
    }

    @Override
    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
}
