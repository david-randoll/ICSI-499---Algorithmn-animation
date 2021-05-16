package Views.Algorithms.SearchingAlgorithms;

import Models.Algorithms.SearchingAlgorithms.LinearSearchModel;
import Shared.AppFrame;
import Shared.res.Styles;

import java.awt.*;

public class LinearSearchView extends BaseSearcherView {
    LinearSearchModel model;

    public LinearSearchView(LinearSearchModel model) {
        super(model,1000);
        this.model = model;

        AppFrame.appFrame.add(model.Panels, BorderLayout.CENTER);
        AppFrame.appFrame.getContentPane().setBackground(Styles.APP_BACKGROUNDCOLOR);

        PaintNewPanelOnScreen();
    }

}