package Models.SortingAlgorithms;

public interface ISorterModel {
    boolean isTimerRunning();

    void setIsTimerRunning(boolean isTimerRunning);

    int getSpeedValue();

    void setSpeedValue(int speedValue);

    int getCurrentIndex();

    void setCurrentIndex(int currentIndex);
}
