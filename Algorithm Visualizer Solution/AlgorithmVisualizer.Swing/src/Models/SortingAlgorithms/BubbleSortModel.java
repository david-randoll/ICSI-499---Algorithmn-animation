package Models.SortingAlgorithms;

import Shared.DataAccess;
import Shared.Components.Panel;

import java.util.ArrayList;

public class BubbleSortModel extends SorterModel implements IGeneratePanel {

    String TITLE = "Bubble Sort";

    public BubbleSortModel() {
        super();
        int[] data = DataAccess.GetData();
        ArrayList<Panel> panels = run(data);

        for (int i = 0; i < panels.size(); i++) {
            super.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<Panel> run(int arr[]) {

        ArrayList<Panel> output = new ArrayList<>();

        int l = 0, r = arr.length - 1;

        Panel firstPanel = new Panel(TITLE, arr, null, "");
        output.add(firstPanel);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                Integer[] indices = {j, j + 1};

                ArrayList<Integer> list = new ArrayList<>();

                for (int index = arr.length - i ; index < arr.length; index++) {
                    list.add(index);
                }
                Integer[] sortedIndices = new Integer[list.size()];
                sortedIndices = list.toArray(sortedIndices);

                Panel newPanel = new Panel(TITLE, arr, sortedIndices , indices, "none");
                output.add(newPanel);

                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    Integer[] swapIndices = {j + 1, j};
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    Panel swapPanel = new Panel(TITLE, arr, sortedIndices, swapIndices, "swap");
                    output.add(swapPanel);
                }
            }
        }

        Integer[] sortedIndices = new Integer[arr.length];
        for(int i =0; i < sortedIndices.length;i++){
           sortedIndices[i] = i;
        }

        Panel lastPanel = new Panel(TITLE, arr, sortedIndices,null, "");
        output.add(lastPanel);

        return output;
    }
}