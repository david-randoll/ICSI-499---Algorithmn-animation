package Shared;

public interface ITimer {
    boolean isTimerRunning();
    void setIsTimerRunning(boolean isTimerRunning);

    int getSpeedValue();
    void setSpeedValue(int speedValue);

    int getCurrentIndex();
    void setCurrentIndex(int currentIndex);

    String getTitle();
    void setTitle(String title);
}
