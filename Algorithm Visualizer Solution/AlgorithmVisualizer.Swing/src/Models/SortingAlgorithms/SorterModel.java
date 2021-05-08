package Models.SortingAlgorithms;

import Shared.Components.Panel;
import Shared.RectangleElement;
import Shared.res.Styles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SorterModel implements ISorterModel {
    public JPanel Panels = new JPanel(new CardLayout());

    private String title;
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

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    protected RectangleElement[] InitializeRectangleElements(int[] arr) {
        RectangleElement[] dataSetRectangle = new RectangleElement[arr.length];
        for(int i = 0; i < arr.length; i++){
            dataSetRectangle[i] = new RectangleElement();
            dataSetRectangle[i].setDataValue(arr[i]);
            dataSetRectangle[i].setBackgroundColor(Styles.RECTANGLE_BACKGROUND_COLOR);
            dataSetRectangle[i].setFontColor(Styles.DATA_COLOR);
        }
        return dataSetRectangle;
    }

    protected void swap(RectangleElement[] dataSetRectangle,int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

        //swap the rectangle elements as well
        RectangleElement temRec = dataSetRectangle[index1];
        dataSetRectangle[index1] = dataSetRectangle[index2];
        dataSetRectangle[index2] = temRec;
    }

    protected void updateBackgroundColor(RectangleElement[] rectangleElements, int [] indexes, Color color){
        for (int i = 0; i < indexes.length; i++){
            if(indexes[i] < 0){
                continue;
            }
            rectangleElements[indexes[i]].setBackgroundColor(color);
        }
    }
    protected void updateForegroundColor(RectangleElement[] rectangleElements, int [] indexes, Color color){
        for (int i = 0; i < indexes.length; i++){
            if(indexes[i] < 0){
                continue;
            }
            rectangleElements[indexes[i]].setFontColor(color);
        }
    }
    protected void updateBorderColor(RectangleElement[] rectangleElements, int [] indexes, Color color){
        for (int i = 0; i < indexes.length; i++){
            if(indexes[i] < 0){
                continue;
            }
            rectangleElements[indexes[i]].setBorderColor(color);
        }
    }

    protected void UpdateBorderColorAndAddToOutput(RectangleElement[] dataSetRectangle, ArrayList<Panel> output, int[] indexes, String instruction, Color color) {
        updateBorderColor(dataSetRectangle, indexes, color);
        output.add(new Panel(getTitle(), dataSetRectangle, instruction));
        updateBorderColor(dataSetRectangle, indexes, null);
    }
}
