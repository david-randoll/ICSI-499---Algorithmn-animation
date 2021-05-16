package Models.SearchingAlgorithms;
import Models.SortingAlgorithms.SorterModel;

import java.util.Random;

public class SearchModel extends SorterModel {
    private int SEARCH_VALUE;

    public SearchModel() {
        this.SEARCH_VALUE = new Random().nextInt(100);
    }

    public int getSearchValue() {
        return SEARCH_VALUE;
    }

    public void setSearchValue(int value) {
        this.SEARCH_VALUE = value;
    }
}
