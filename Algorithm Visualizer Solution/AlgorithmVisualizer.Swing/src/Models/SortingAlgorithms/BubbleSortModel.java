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

    public BubbleSortModel() {
        super();
        setTitle("Bubble Sort");
        int[] data = DataAccess.GetData();
        ArrayList<PanelClone> panels = run(data);

        for (int i = 0; i < panels.size(); i++) {
            super.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<PanelClone> run(int arr[]) {
        ArrayList<PanelClone> output = new ArrayList<>();

        int l = 0, r = arr.length - 1;

        RectangleElement[] dataSetRectangle = InitializeRectangleElements(arr);

        output.add( new PanelClone(getTitle(), dataSetRectangle,  ""));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {

                //we will need to remove outline at the end of the loop when finish
                updateBorderColor(dataSetRectangle, new int[]{j, j+1}, Styles.OUTLINE_COLOR);

                output.add(new PanelClone(getTitle(), dataSetRectangle,  "Is "+arr[j]+" greater than "+arr[j+1]+"?"));

                if (arr[j] > arr[j + 1]) {
                    swap(dataSetRectangle,arr, j, j + 1);
                    //outline the swap color
                    updateBorderColor(dataSetRectangle,new int[]{j,j+1},Styles.SWAP_COLOR);

                    output.add(new PanelClone(getTitle(), dataSetRectangle, "Yes, so we swap!"));
                }else {
                    output.add(new PanelClone(getTitle(), dataSetRectangle, "Nope"));
                }
                //remove the outline that was applied above
                updateBorderColor(dataSetRectangle, new int[]{j, j+1},null);

            }
            updateBackgroundColor(dataSetRectangle, new int[]{arr.length - i - 1}, Styles.SORTED_BACKGROUND_COLOR);
            updateForegroundColor(dataSetRectangle, new int[]{arr.length - i - 1}, Styles.SORTED_DATA_COLOR);
        }
        output.add(new PanelClone(getTitle(), dataSetRectangle, "Sorted"));

        return output;
    }
}