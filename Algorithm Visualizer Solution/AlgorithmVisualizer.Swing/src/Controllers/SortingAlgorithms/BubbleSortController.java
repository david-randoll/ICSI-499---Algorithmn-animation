package Controllers.SortingAlgorithms;

import Controllers.Controller;
import Models.SortingAlgorithms.BubbleSortModel;
import Views.SortingAlgorithms.BubbleSortView;

import javax.swing.*;

public class BubbleSortController implements Controller {

    private BubbleSortView view = new BubbleSortView();
    private BubbleSortModel model;

    public void InitView() {
        Runnable runnable = new Runnable() {
            public void run() {
                view.animateBubbleSort(model);
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    public void InitController() {
<<<<<<< Updated upstream
        model = new BubbleSortModel();
        InitView();
=======
        super.InitController(model, view);
>>>>>>> Stashed changes
    }
}