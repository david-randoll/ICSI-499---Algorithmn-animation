package Models.SortingAlgorithms;

import Shared.Components.PanelClone;
import Shared.DataAccess;
import Shared.Components.Panel;
import Shared.RectangleElement;
import Shared.res.Styles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InsertionSortModel extends SorterModel implements IGeneratePanel {

    String TITLE = "Insertion Sort";

    public InsertionSortModel() {
        int[] data = DataAccess.GetData();
        ArrayList<PanelClone> panels = runClone(data);

        for (int i = 0; i < panels.size(); i++) {
            this.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<PanelClone> runClone(int arr[]) {
        ArrayList<PanelClone> output = new ArrayList<>();
        int n = arr.length;

        RectangleElement[] dataSetRectangle = new RectangleElement[arr.length];
        for(int i = 0; i < arr.length; i++){
            dataSetRectangle[i] = new RectangleElement();
            dataSetRectangle[i].setDataValue(arr[i]);
            dataSetRectangle[i].setBackgroundColor(Styles.RECTANGLE_BACKGROUND_COLOR);
            dataSetRectangle[i].setForegroundColor(Styles.DATA_COLOR);
        }

        output.add( new PanelClone(TITLE, dataSetRectangle,  ""));

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            RectangleElement keyRec = dataSetRectangle[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            int counter = 0;
            while (j >= 0 && arr[j] > key) {
                if (arr[j + 1] > key) {
                    if(counter == 0){
                        OutlineBorderWithNoBackground(output, dataSetRectangle, j);
                    }else{
                        OutlineBorderWithBackground(output, dataSetRectangle, dataSetRectangle[i], j,"");
                    }
                } else {
                    if (counter == 0) {
                        OutlineBorderWithNoBackground(output, dataSetRectangle, j);
                        OutlineBorderWithBackground(output, dataSetRectangle, dataSetRectangle[i], j,"swap");
                    }
                }

                counter++; //used for the first case of highlighting

                arr[j + 1] = arr[j];
                dataSetRectangle[j + 1] = dataSetRectangle[j];

                arr[j] = key;//arr[i]
                dataSetRectangle[j] = keyRec;//dataSetRectangle[i]

                j = j - 1;

                if (j > -1) {
                    if (arr[j] > key) {
                        OutlineBorderWithBackground(output, dataSetRectangle, dataSetRectangle[i], j,"swap");
                    } else {
                        OutlineBorderWithBackground(output, dataSetRectangle, dataSetRectangle[i], j,"");
                    }
                }
            }
            arr[j + 1] = key;
            dataSetRectangle[j + 1] = keyRec;

            switch (i - j) {
                case 1:
                case -1:
                case 0:
                    //add the outline color
                    dataSetRectangle[i].setBorderColor(Styles.OUTLINE_COLOR);
                    dataSetRectangle[j].setBorderColor(Styles.OUTLINE_COLOR);

                    output.add( new PanelClone(TITLE, dataSetRectangle,  ""));

                    //remove the outline color
                    dataSetRectangle[i].setBorderColor(null);
                    dataSetRectangle[j].setBorderColor(null);
                    break;
            }
        }

        for (int i = 0; i < dataSetRectangle.length; i++) {
            dataSetRectangle[i].setBackgroundColor(Styles.SORTED_BACKGROUND_COLOR);
        }

        output.add( new PanelClone(TITLE, dataSetRectangle,  "sorted"));

        return output;
    }

    private void OutlineBorderWithBackground(ArrayList<PanelClone> output, RectangleElement[] dataSetRectangle, RectangleElement rectangleElement, int j, String instruction) {
        //add the outline color
        dataSetRectangle[j].setBorderColor(Styles.SWAP_COLOR);
        dataSetRectangle[j + 1].setBorderColor(Styles.SWAP_COLOR);

        //add background color
        rectangleElement.setBackgroundColor(Styles.SORTED_BACKGROUND_COLOR);

        output.add( new PanelClone(TITLE, dataSetRectangle,  instruction));

        //remove the outline color
        dataSetRectangle[j].setBorderColor(null);
        dataSetRectangle[j + 1].setBorderColor(null);

        //remove the background color
        rectangleElement.setBackgroundColor(Styles.RECTANGLE_BACKGROUND_COLOR);
    }

    private void OutlineBorderWithNoBackground(ArrayList<PanelClone> output, RectangleElement[] dataSetRectangle, int j) {
        //add the outline color
        dataSetRectangle[j].setBorderColor(Styles.OUTLINE_COLOR);
        dataSetRectangle[j + 1].setBorderColor(Styles.OUTLINE_COLOR);

        output.add( new PanelClone(TITLE, dataSetRectangle,  ""));

        //remove the outline color
        dataSetRectangle[j].setBorderColor(null);
        dataSetRectangle[j + 1].setBorderColor(null);
    }


    //    public InsertionSortModel() {
//        int[] data = DataAccess.GetData();
//        ArrayList<Panel> panels = run(data);
//
//        for (int i = 0; i < panels.size(); i++) {
//            this.Panels.add(panels.get(i), Integer.toString(i));
//        }//Add all cards to the card panel so we can transition panels easily
//    }
//
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