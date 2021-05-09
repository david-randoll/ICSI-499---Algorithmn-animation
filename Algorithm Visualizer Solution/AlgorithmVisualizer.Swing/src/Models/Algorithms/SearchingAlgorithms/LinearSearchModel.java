package Models.Algorithms.SearchingAlgorithms;

import Shared.Components.Panel;
import Shared.DataAccess;
import Shared.RectangleElement;
import Shared.res.Styles;

import java.util.ArrayList;

public class LinearSearchModel extends BaseSearcherModel implements ISearcherModel {

    public LinearSearchModel() {
        setTitle("Linear Search");
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

        for(int i = 0; i < arr.length; i++){

            UpdateBorderColorAndAddToOutput(dataSetRectangle,output,new int[]{i},"Searching for: " + x, Styles.OUTLINE_COLOR);
            updateBackgroundColor(dataSetRectangle, new int[]{i}, Styles.DISABLED_ELEMENT_COLOR);

            if (arr[i] == x) {
                //items after the search value to be disabled
                for(int j = i; j < arr.length; j++) {
                    updateBackgroundColor(dataSetRectangle, new int[]{j}, Styles.DISABLED_ELEMENT_COLOR);
                }
                updateBackgroundColor(dataSetRectangle, new int[]{i}, Styles.SORTED_BACKGROUND_COLOR);
                updateForegroundColor(dataSetRectangle, new int[]{i}, Styles.SORTED_DATA_COLOR);
                output.add( new Panel(getTitle(), dataSetRectangle,  String.format("%d was found!", x)));
                return output;
            }
        }
        // if we reach here, then element was not present
        output.add( new Panel(getTitle(), dataSetRectangle,  String.format("%d not found.", x)));
        return output;
    }
}
