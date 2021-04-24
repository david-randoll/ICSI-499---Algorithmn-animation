package Models.SortingAlgorithms;

import Shared.DataAccess;
import SharedComponents.Panel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSortModel {

    public static JPanel Panels = new JPanel(new CardLayout());

    public BubbleSortModel() {
        DataAccess dataAccess = new DataAccess();
        int[] data = dataAccess.GetData();
        ArrayList<Panel> panels = run(data);

        for (int i = 0; i < panels.size(); i++) {
            this.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<Panel> run(int arr[]) {

        ArrayList<SharedComponents.Panel> output = new ArrayList<>();

        int l = 0, r = arr.length - 1;

        SharedComponents.Panel firstPanel = new SharedComponents.Panel("Bubble Sort", arr, null);
        output.add(firstPanel);

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                Integer[] indices = {j, j+1};
                SharedComponents.Panel newPanel = new Panel("Bubble Sort", arr, indices);
                output.add(newPanel);

                newPanel.setTitle("Is " + arr[j] +" grater than "+ arr[j + 1] + "?");
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    Integer[] swapIndices = {j+1, j};
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    SharedComponents.Panel swapPanel = new Panel("Yes so we swap!", arr, swapIndices);
                    output.add(swapPanel);
                }else{
                    newPanel.setTitle("Nope, so we compare next");
                }
            }
        }

        return output;
    }
}