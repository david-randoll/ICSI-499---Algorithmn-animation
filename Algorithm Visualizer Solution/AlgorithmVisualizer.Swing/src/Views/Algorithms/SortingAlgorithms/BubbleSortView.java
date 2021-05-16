package Views.Algorithms.SortingAlgorithms;

import Models.Algorithms.SortingAlgorithms.BubbleSortModel;
import Shared.AppFrame;
import Shared.res.Styles;

import java.awt.*;

public class BubbleSortView extends BaseSorterView {
    BubbleSortModel model;

    public BubbleSortView(BubbleSortModel model) {
        super(model,1000);
        this.model = model;

        AppFrame.appFrame.add(model.Panels, BorderLayout.CENTER);
        AppFrame.appFrame.getContentPane().setBackground(Styles.APP_BACKGROUNDCOLOR);

        PaintNewPanelOnScreen();
    }
}