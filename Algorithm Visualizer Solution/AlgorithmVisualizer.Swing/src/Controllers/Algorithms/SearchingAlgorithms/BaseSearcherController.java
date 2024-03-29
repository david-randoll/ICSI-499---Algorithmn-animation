package Controllers.Algorithms.SearchingAlgorithms;

import Controllers.Algorithms.AlgorithmController;
import Models.Algorithms.SearchingAlgorithms.ISearcherModel;
import Models.Algorithms.SearchingAlgorithms.BaseSearcherModel;
import Shared.AppFrame;
import Shared.Components.Panel;
import Shared.Components.toast;
import Shared.DataAccess;
import Views.Algorithms.SearchingAlgorithms.BaseSearcherView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BaseSearcherController extends AlgorithmController {

    private BaseSearcherView view;
    private BaseSearcherModel model;

    public void InitController(BaseSearcherModel model, BaseSearcherView view){
        this.model = model;
        this.view = view;
        InitView();
        super.InitController(model,view);
    }

    private void InitView(){
        view.addSearchButtonListener(newSearchValueListener());

        //remove the event listener and add new listener
        view.getChangeDataSetButton().removeActionListener(super.updateDataSetActionListener());
        view.addDataSetButtonListener(updateDataSetActionListener());
    }

    private ActionListener newSearchValueListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.getTimer().Stop();
                int newSearchValue = Integer.parseInt(view.getSearchTextBox().getText());
                model.Panels.removeAll();
                ArrayList<Panel> panels = ((ISearcherModel)model).run(DataAccess.GetSortedData(), newSearchValue);
                model.setSearchValue(newSearchValue);

                for (int i = 0; i < panels.size(); i++) {
                    model.Panels.add(panels.get(i), Integer.toString(i));
                }//Add all cards to the card panel so we can transition panels easily

                model.setCurrentIndex(0);
                view.UpdatePlayPauseButtonText("\u23F5");//play
                AppFrame.appFrame.revalidate();
                AppFrame.appFrame.repaint();
            }
        };
    }

    protected ActionListener updateDataSetActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.getTimer().Stop();

                if (DataAccess.SetData(view.getDataSetTextBox().getText()) == false) {
                    toast t = new toast("Not valid input! Only comma separated numbers are valid", (int) (AppFrame.getScreenWidth() * 0.5), (int) (AppFrame.getScreenHeight() * 0.8));
                    t.showtoast();
                }
                model.Panels.removeAll();
                ArrayList<Panel> panels = ((ISearcherModel)model).run(DataAccess.GetSortedData(), model.getSearchValue());

                for (int i = 0; i < panels.size(); i++) {
                    model.Panels.add(panels.get(i), Integer.toString(i));
                }//Add all cards to the card panel so we can transition panels easily

                model.setCurrentIndex(0);

                view.UpdatePlayPauseButtonText("\u23F5");
                AppFrame.appFrame.revalidate();
                AppFrame.appFrame.repaint();
            }
        };
    }
}
