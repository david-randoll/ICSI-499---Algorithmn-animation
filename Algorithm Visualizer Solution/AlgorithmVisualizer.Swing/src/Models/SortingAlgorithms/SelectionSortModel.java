package Models.SortingAlgorithms;

import Shared.Components.Panel;
import Shared.DataAccess;
import Shared.RectangleElement;
import Shared.res.Styles;

import java.util.ArrayList;

public class SelectionSortModel extends SorterModel implements IGeneratePanel {

    public SelectionSortModel() {
        setTitle("Selection Sort");
        int[] data = DataAccess.GetData();
        ArrayList<Panel> panels = run(data);

        for (int i = 0; i < panels.size(); i++) {
            this.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<Panel> run(int arr[]) {
        RectangleElement[] dataSetRectangle = InitializeRectangleElements(arr);
        ArrayList<Panel> output = new ArrayList<>();

        output.add( new Panel(getTitle(), dataSetRectangle,  ""));

        for (int i = 0; i < arr.length; i++) {

            // Find the minimum element in unsorted array
            int min_idx = i;


            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
                UpdateBorderColorAndAddToOutput(dataSetRectangle, output, new int[]{min_idx, j}, "Current minimum: " + arr[min_idx], Styles.OUTLINE_COLOR);
            }
            UpdateBorderColorAndAddToOutput(dataSetRectangle, output, new int[]{min_idx, i}, "", Styles.OUTLINE_COLOR);

            // Swap the found minimum element with the first element
            swap(dataSetRectangle,arr, min_idx, i);

            UpdateBorderColorAndAddToOutput(dataSetRectangle, output, new int[]{min_idx, i}, "Swap", Styles.SWAP_COLOR);

            //sorted index
            updateBackgroundColor(dataSetRectangle, new int[]{i}, Styles.SORTED_BACKGROUND_COLOR);
            updateForegroundColor(dataSetRectangle, new int[]{i}, Styles.SORTED_DATA_COLOR);
        }

        output.add(new Panel(getTitle(), dataSetRectangle, "Sorted"));

        return output;
    }
}
