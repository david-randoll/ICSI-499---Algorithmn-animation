package Models.SortingAlgorithms;

import Shared.Components.Panel;
import Shared.DataAccess;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SelectionSortModel {
    public static JPanel Panels = new JPanel(new CardLayout());

    String TITLE = "Selection Sort";

    public SelectionSortModel() {
        int[] data = DataAccess.GetData();
        ArrayList<Shared.Components.Panel> panels = run(data);

        for (int i = 0; i < panels.size(); i++) {
            this.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<Shared.Components.Panel> run(int arr[]) {
        ArrayList<Shared.Components.Panel> output = new ArrayList<>();
        int n = arr.length;

        Shared.Components.Panel firstPanel = new Shared.Components.Panel(TITLE, arr, null, "");
        output.add(firstPanel);

        for (int i = 0; i < n - 1; i++) {
            Panel preSwapPanel;
            Panel swapPanel;
            Panel searchingPanel;

            Integer[] sortedIndices = new Integer[i];
            for (int k = 0; k < i; k++) {
                sortedIndices[k] = k;
            }

            // Find the minimum element in unsorted array
            int min_idx = i;


            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
                searchingPanel = new Panel(TITLE, arr, sortedIndices, new Integer[]{min_idx, j}, String.valueOf(arr[min_idx]));
                output.add(searchingPanel);
            }

            preSwapPanel = new Panel(TITLE, arr, sortedIndices, new Integer[]{min_idx, i}, "");
            output.add(preSwapPanel);

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            swapPanel = new Panel(TITLE, arr, sortedIndices, new Integer[]{min_idx, i}, "swap");
            output.add(swapPanel);
        }

        Integer[] sortedIndices = new Integer[arr.length];
        for (int k = 0; k < sortedIndices.length; k++) {
            sortedIndices[k] = k;
        }
        Shared.Components.Panel lastPanel = new Panel(TITLE, arr, sortedIndices, null, "");
        output.add(lastPanel);

        return output;
    }
}
