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

    public InsertionSortModel() {
        setTitle("Insertion Sort");
        int[] data = DataAccess.GetData();
        ArrayList<PanelClone> panels = run(data);

        for (int i = 0; i < panels.size(); i++) {
            this.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<PanelClone> run(int arr[]) {
        ArrayList<PanelClone> output = new ArrayList<>();
        int n = arr.length;

        RectangleElement[] dataSetRectangle = InitializeRectangleElements(arr);

        output.add( new PanelClone(getTitle(), dataSetRectangle,  ""));

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
                        OutlineBorderWithBackground(output, dataSetRectangle, i, j,"");
                    }
                } else {
                    if (counter == 0) {
                        OutlineBorderWithNoBackground(output, dataSetRectangle, j);
                        OutlineBorderWithBackground(output, dataSetRectangle, i, j,"swap");
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
                        OutlineBorderWithBackground(output, dataSetRectangle, i, j,"swap");
                    } else {
                        OutlineBorderWithBackground(output, dataSetRectangle, i, j,"");
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
                    updateBorderColor(dataSetRectangle,new int[]{i, j},Styles.OUTLINE_COLOR);

                    output.add( new PanelClone(getTitle(), dataSetRectangle,  ""));

                    //remove the outline color
                    updateBorderColor(dataSetRectangle,new int[]{i, j},null);
                    break;
            }
        }

        for (int i = 0; i < dataSetRectangle.length; i++) {
            dataSetRectangle[i].setBackgroundColor(Styles.SORTED_BACKGROUND_COLOR);
        }

        output.add( new PanelClone(getTitle(), dataSetRectangle,  "sorted"));

        return output;
    }

    private void OutlineBorderWithBackground(ArrayList<PanelClone> output, RectangleElement[] dataSetRectangle, int i, int j, String instruction) {
        //add the outline color
        updateBorderColor(dataSetRectangle, new int[]{j, j+1}, Styles.SWAP_COLOR);

        //add background color
        updateBackgroundColor(dataSetRectangle, new int[]{i}, Styles.SORTED_BACKGROUND_COLOR);

        output.add( new PanelClone(getTitle(), dataSetRectangle,  instruction));

        //remove the outline color
        updateBorderColor(dataSetRectangle, new int[]{j, j+1}, null);

        //remove the background color
        updateBackgroundColor(dataSetRectangle, new int[]{i}, Styles.RECTANGLE_BACKGROUND_COLOR);
    }

    private void OutlineBorderWithNoBackground(ArrayList<PanelClone> output, RectangleElement[] dataSetRectangle, int j) {
        //add the outline color
        updateBorderColor(dataSetRectangle, new int[]{j, j+1}, Styles.OUTLINE_COLOR);

        output.add( new PanelClone(getTitle(), dataSetRectangle,  ""));

        //remove the outline color
        updateBorderColor(dataSetRectangle, new int[]{j, j+1}, null);
    }
}