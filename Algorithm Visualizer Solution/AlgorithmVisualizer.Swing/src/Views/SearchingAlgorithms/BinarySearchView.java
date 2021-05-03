package Views.SearchingAlgorithms;

import Controllers.HomeController;
import Models.SearchingAlgorithms.BinarySearchModel;
import Shared.AppFrame;
import Shared.Components.Panel;
import Shared.DataAccess;
import Shared.Components.CustomJPanel;
import Shared.Components.toast;
import Shared.res.Styles;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

public class BinarySearchView extends SearchView {
    BinarySearchModel model;

    public BinarySearchView(BinarySearchModel model) {
        super(model,1000);
        this.model = model;

        AppFrame.appFrame.add(model.Panels, BorderLayout.CENTER);
        AppFrame.appFrame.getContentPane().setBackground(Styles.APP_BACKGROUNDCOLOR);

        PaintNewPanelOnScreen();
    }

}