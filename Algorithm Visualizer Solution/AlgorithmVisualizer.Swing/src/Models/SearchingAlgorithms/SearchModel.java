package Models.SearchingAlgorithms;
import Models.AlgorithmModel;
import Models.SortingAlgorithms.SorterModel;

import java.util.Random;

public class SearchModel extends AlgorithmModel {
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
