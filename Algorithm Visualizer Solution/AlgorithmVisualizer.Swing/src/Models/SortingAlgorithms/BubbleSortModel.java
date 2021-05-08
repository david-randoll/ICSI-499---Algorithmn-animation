package Models.SortingAlgorithms;

import Shared.Components.Panel;
import Shared.DataAccess;
import Shared.RectangleElement;
import Shared.res.Styles;

import java.util.ArrayList;

public class BubbleSortModel extends SorterModel implements IGeneratePanel {

    public BubbleSortModel() {
        super();
        setTitle("Bubble Sort");
        int[] data = DataAccess.GetData();
        ArrayList<Panel> panels = run(data);

        for (int i = 0; i < panels.size(); i++) {
            super.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<Panel> run(int arr[]) {
        ArrayList<Panel> output = new ArrayList<>();

        RectangleElement[] dataSetRectangle = InitializeRectangleElements(arr);

        output.add(new Panel(getTitle(), dataSetRectangle, ""));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {

                UpdateBorderColorAndAddToOutput(dataSetRectangle, output, new int[]{j, j + 1}, "Is " + arr[j] + " greater than " + arr[j + 1] + "?", Styles.OUTLINE_COLOR);

                if (arr[j] > arr[j + 1]) {
                    swap(dataSetRectangle, arr, j, j + 1);
                    UpdateBorderColorAndAddToOutput(dataSetRectangle, output, new int[]{j, j + 1}, "Yes, so we swap!", Styles.SWAP_COLOR);
                } else {
                    UpdateBorderColorAndAddToOutput(dataSetRectangle, output, new int[]{j, j + 1}, "Nope", Styles.OUTLINE_COLOR);
                }
            }
            updateBackgroundColor(dataSetRectangle, new int[]{arr.length - i - 1}, Styles.SORTED_BACKGROUND_COLOR);
            updateForegroundColor(dataSetRectangle, new int[]{arr.length - i - 1}, Styles.SORTED_DATA_COLOR);
        }
        output.add(new Panel(getTitle(), dataSetRectangle, "Sorted"));

        return output;
    }
}