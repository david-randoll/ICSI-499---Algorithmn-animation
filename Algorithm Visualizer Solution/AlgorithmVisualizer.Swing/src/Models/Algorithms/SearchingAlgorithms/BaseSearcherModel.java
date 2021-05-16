package Models.Algorithms.SearchingAlgorithms;
import Models.Algorithms.AlgorithmModel;

import java.util.Random;

public class BaseSearcherModel extends AlgorithmModel {
    private int SEARCH_VALUE;

    public BaseSearcherModel() {
        this.SEARCH_VALUE = new Random().nextInt(100);
    }

    public int getSearchValue() {
        return SEARCH_VALUE;
    }

    public void setSearchValue(int value) {
        this.SEARCH_VALUE = value;
    }
}
