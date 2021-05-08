package Controllers.SortingAlgorithms;

import Controllers.AlgorithmController;
import Controllers.IAlgorithmController;
import Models.AlgorithmModel;
import Models.SortingAlgorithms.SorterModel;
import Views.SortingAlgorithms.SorterView;

public class SorterController extends AlgorithmController implements IAlgorithmController {

    private SorterView view;
    private AlgorithmModel model;

    public void InitController(SorterModel model, SorterView view) {
        super.InitController(model,view);
    }
}