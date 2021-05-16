package Controllers.Algorithms.SortingAlgorithms;

import Controllers.Algorithms.AlgorithmController;
import Controllers.Algorithms.IAlgorithmController;
import Models.Algorithms.AlgorithmModel;
import Models.Algorithms.SortingAlgorithms.BaseSorterModel;
import Views.Algorithms.SortingAlgorithms.BaseSorterView;

public class BaseSorterController extends AlgorithmController implements IAlgorithmController {

    private BaseSorterView view;
    private AlgorithmModel model;

    public void InitController(BaseSorterModel model, BaseSorterView view) {
        super.InitController(model,view);
    }
}