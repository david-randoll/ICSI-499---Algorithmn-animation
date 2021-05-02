package Models.SortingAlgorithms;

import Shared.DataAccess;
import Shared.Components.Panel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InsertionSortModel {

    public static JPanel Panels = new JPanel(new CardLayout());

    String TITLE = "Insertion Sort";

    public InsertionSortModel() {
        int[] data = DataAccess.GetData();
        ArrayList<Panel> panels = run(data);

        for (int i = 0; i < panels.size(); i++) {
            this.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<Panel> run(int arr[]) {
        ArrayList<Panel> output = new ArrayList<>();
        int n = arr.length;

        Panel firstPanel = new Panel(TITLE, arr, null, "");
        output.add(firstPanel);

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            int counter = 0;
            while (j >= 0 && arr[j] > key) {
                Panel swapPanel;

                Panel preSwapPanel;
                if (arr[j + 1] > key) {
                    if (counter == 0) {
                        preSwapPanel = new Panel(TITLE, arr, new Integer[]{}, new Integer[]{j, j + 1}, "");
                    } else {
                        preSwapPanel = new Panel(TITLE, arr, new Integer[]{i}, new Integer[]{j, j + 1}, "");
                    }
                    output.add(preSwapPanel);
                } else {
                    if (counter == 0) {
                        preSwapPanel = new Panel(TITLE, arr, new Integer[]{}, new Integer[]{j, j + 1}, "");
                        output.add(preSwapPanel);
                        preSwapPanel = new Panel(TITLE, arr, new Integer[]{i}, new Integer[]{j, j + 1}, "swap");
                        output.add(preSwapPanel);
                    }
                }

                counter++; //used for the first case of highlighting

                arr[j + 1] = arr[j];
                arr[j] = key;
                j = j - 1;

                if (j > -1) {
                    if (arr[j] > key) {
                        swapPanel = new Panel(TITLE, arr, new Integer[]{i}, new Integer[]{j, j + 1}, "swap");
                    } else {
                        swapPanel = new Panel(TITLE, arr, new Integer[]{i}, new Integer[]{j, j + 1}, "");
                    }
                    output.add(swapPanel);
                }
            }
            arr[j + 1] = key;

            switch (i - j) {
                case 1:
                case -1:
                case 0:
                    Panel comparePanel = new Panel(TITLE, arr, new Integer[]{i, j}, "");
                    output.add(comparePanel);
                    break;
            }

        }

        Integer[] sortedIndices = new Integer[arr.length];
        for (int i = 0; i < sortedIndices.length; i++) {
            sortedIndices[i] = i;
        }

        Panel lastPanel = new Panel(TITLE, arr, sortedIndices, null, "");
        output.add(lastPanel);

        return output;
    }

}