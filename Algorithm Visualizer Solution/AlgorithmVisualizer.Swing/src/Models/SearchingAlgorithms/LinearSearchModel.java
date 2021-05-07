package Models.SearchingAlgorithms;

import Models.Model;
import Shared.Components.PanelClone;
import Shared.DataAccess;
import Shared.RectangleElement;
import Shared.res.Styles;

import java.util.ArrayList;

public class LinearSearchModel extends SearchModel implements Model {

    public LinearSearchModel() {
        setTitle("Linear Search");
        int[] data = DataAccess.GetSortedData();
        int searchValue = 46;
        ArrayList<PanelClone> panels = run(data, searchValue);

        for (int i = 0; i < panels.size(); i++) {
            this.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<PanelClone> run(int arr[], int x) {

        ArrayList<PanelClone> output = new ArrayList<>();
        RectangleElement[] dataSetRectangle = InitializeRectangleElements(arr);

        output.add( new PanelClone(getTitle(), dataSetRectangle,  ""));

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
                output.add( new PanelClone(getTitle(), dataSetRectangle,  String.format("%d was found!", x)));
                return output;
            }
        }
        // if we reach here, then element was not present
        output.add( new PanelClone(getTitle(), dataSetRectangle,  String.format("%d not found.", x)));
        return output;
    }
}
