package Models.SearchingAlgorithms;

import Models.Model;
import Shared.Components.Panel;
import Shared.DataAccess;
import Shared.RectangleElement;
import Shared.res.Styles;

import java.util.ArrayList;

public class BinarySearchModel extends SearchModel implements Model {

    public BinarySearchModel() {
        setTitle("Binary Search");
        int[] data = DataAccess.GetSortedData();
        int searchValue = getSearchValue();
        ArrayList<Panel> panels = run(data, searchValue);

        for (int i = 0; i < panels.size(); i++) {
            this.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<Panel> run(int arr[], int x) {

        ArrayList<Panel> output = new ArrayList<>();
        RectangleElement[] dataSetRectangle = InitializeRectangleElements(arr);

        output.add( new Panel(getTitle(), dataSetRectangle,  ""));

        int left = 0, right = arr.length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            // Check if x is present at mid
            if (arr[middle] == x) {
                for(int i = 0; i < arr.length; i++){
                    updateBackgroundColor(dataSetRectangle, new int[]{i}, Styles.DISABLED_ELEMENT_COLOR);
                }
                updateBackgroundColor(dataSetRectangle, new int[]{middle}, Styles.SORTED_BACKGROUND_COLOR);
                updateForegroundColor(dataSetRectangle, new int[]{middle}, Styles.SORTED_DATA_COLOR);
                output.add( new Panel(getTitle(), dataSetRectangle,  String.format("%d was found!", x)));
                return output;
            }

            // If x greater, ignore left half
            if (arr[middle] < x) {
                for (int i = left; i < middle; i++) {
                    updateBackgroundColor(dataSetRectangle, new int[]{i}, Styles.DISABLED_ELEMENT_COLOR);
                }
                left = middle + 1;
            }
            // If x is smaller, ignore right half
            else {
                for (int i = middle + 1; i < right + 1; i++) {
                    updateBackgroundColor(dataSetRectangle, new int[]{i}, Styles.DISABLED_ELEMENT_COLOR);
                }

                right = middle - 1;
            }
            UpdateBorderColorAndAddToOutput(dataSetRectangle,output,new int[]{middle},"Searching for: " + x, Styles.OUTLINE_COLOR);
            updateBackgroundColor(dataSetRectangle, new int[]{middle}, Styles.DISABLED_ELEMENT_COLOR);
        }
        // if we reach here, then element was not present
        output.add( new Panel(getTitle(), dataSetRectangle,  String.format("%d not found.", x)));
        return output;
    }
}
