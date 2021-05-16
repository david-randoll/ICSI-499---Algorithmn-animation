package Views.Algorithms.SortingAlgorithms;

import Models.Algorithms.SortingAlgorithms.QuickSortModel;
import Shared.AppFrame;
import Shared.res.Styles;

import java.awt.*;

public class QuickSortView extends BaseSorterView {
    QuickSortModel model;

    public QuickSortView(QuickSortModel model) {
        super(model,1000);
        this.model = model;

        AppFrame.appFrame.add(model.Panels, BorderLayout.CENTER);
        AppFrame.appFrame.getContentPane().setBackground(Styles.APP_BACKGROUNDCOLOR);

        PaintNewPanelOnScreen();
    }
}