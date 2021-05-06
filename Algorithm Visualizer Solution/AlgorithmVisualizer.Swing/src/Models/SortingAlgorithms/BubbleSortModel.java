package Models.SortingAlgorithms;

import Shared.Components.PanelClone;
import Shared.DataAccess;
import Shared.Components.Panel;
import Shared.RectangleElement;
import Shared.res.Styles;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSortModel extends SorterModel implements IGeneratePanel {

    String TITLE = "Bubble Sort";

    public BubbleSortModel() {
        super();
        int[] data = DataAccess.GetData();
        ArrayList<PanelClone> panels = runClone(data);

        for (int i = 0; i < panels.size(); i++) {
            super.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<PanelClone> runClone(int arr[]) {
        ArrayList<PanelClone> output = new ArrayList<>();

        int l = 0, r = arr.length - 1;

        RectangleElement[] dataSetRectangle = new RectangleElement[arr.length];
        for(int i = 0; i < arr.length; i++){
            dataSetRectangle[i] = new RectangleElement();
            dataSetRectangle[i].setDataValue(arr[i]);
            dataSetRectangle[i].setBackgroundColor(Styles.RECTANGLE_BACKGROUND_COLOR);
            dataSetRectangle[i].setForegroundColor(Styles.DATA_COLOR);
        }

        output.add( new PanelClone(TITLE, dataSetRectangle,  ""));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {

                //we will need to remove outline at the end of the loop when finish
                dataSetRectangle[j].setBorderColor(Styles.OUTLINE_COLOR);
                dataSetRectangle[j + 1].setBorderColor(Styles.OUTLINE_COLOR);

                output.add(new PanelClone(TITLE, dataSetRectangle,  "Is "+arr[j]+" greater than "+arr[j+1]+"?"));

                if (arr[j] > arr[j + 1]) {
                    //remove the outline that was applied above
                    dataSetRectangle[j].setBorderColor(null);
                    dataSetRectangle[j + 1].setBorderColor(null);

                    swap(dataSetRectangle,arr, j, j + 1);

                    //outline the swap color
                    dataSetRectangle[j].setBorderColor(Styles.SWAP_COLOR);
                    dataSetRectangle[j + 1].setBorderColor(Styles.SWAP_COLOR);

                    output.add(new PanelClone(TITLE, dataSetRectangle, "Yes, so we swap!"));

                    //remove the swap color
                    dataSetRectangle[j].setBorderColor(null);
                    dataSetRectangle[j + 1].setBorderColor(null);
                }else {
                    output.add(new PanelClone(TITLE, dataSetRectangle, "Nope"));
                    //remove the outline that was applied above
                    dataSetRectangle[j].setBorderColor(null);
                    dataSetRectangle[j + 1].setBorderColor(null);
                }
            }
            dataSetRectangle[arr.length - i - 1].setBackgroundColor(Styles.SORTED_BACKGROUND_COLOR);
            dataSetRectangle[arr.length - i - 1].setForegroundColor(Styles.SORTED_DATA_COLOR);
        }
        output.add(new PanelClone(TITLE, dataSetRectangle, "Sorted"));

        return output;
    }

    private void swap(RectangleElement[] dataSetRectangle,int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

        //swap the rectangle elements as well
        RectangleElement temRec = dataSetRectangle[index1];
        dataSetRectangle[index1] = dataSetRectangle[index2];
        dataSetRectangle[index2] = temRec;
    }

//    public BubbleSortModel() {
//        super();
//        int[] data = DataAccess.GetData();
//        ArrayList<Panel> panels = run(data);
//
//        for (int i = 0; i < panels.size(); i++) {
//            super.Panels.add(panels.get(i), Integer.toString(i));
//        }//Add all cards to the card panel so we can transition panels easily
//    }

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

                Panel newPanel = new Panel(TITLE, arr, sortedIndices , indices, "Is "+arr[j]+" greater than "+arr[j+1]+"?");
                output.add(newPanel);


                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    Integer[] swapIndices = {j + 1, j};
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    Panel swapPanel = new Panel(TITLE, arr, sortedIndices, swapIndices, "Yes, so we swap!");
                    output.add(swapPanel);
                }else {
                    Panel noSwapPanel = new Panel(TITLE, arr, sortedIndices , indices, "Nope");
                    output.add(noSwapPanel);
                }
            }
        }

        Integer[] sortedIndices = new Integer[arr.length];
        for(int i =0; i < sortedIndices.length;i++){
            sortedIndices[i] = i;
        }

        Panel lastPanel = new Panel(TITLE, arr, sortedIndices,null, "Sorted");
        output.add(lastPanel);

        return output;
    }
}