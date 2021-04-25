package Views.SortingAlgorithms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Models.SortingAlgorithms.BinarySearchModel;
import Models.SortingAlgorithms.BubbleSortModel;
import Shared.AppFrame;
import SharedComponents.CustomJPanel;
import SharedComponents.Panel;
import SharedComponents.SortingToolBar;
import SharedComponents.TitleLablel;

public class BubbleSortView extends CustomJPanel {
    int currentIndex = 0;
    boolean IsPause = false;
    JButton clickmeButton;

    public BubbleSortView() {
        super("Bubble Sort");
    }
    public void animatePanels(BubbleSortModel model) {
        initToolBar(model);

        AppFrame.appFrame.add(model.Panels);
        CardLayout cardLayout = (CardLayout) model.Panels.getLayout();
        while (currentIndex < model.Panels.getComponentCount()){
            cardLayout.show(model.Panels, Integer.toString(currentIndex));

            AppFrame.appFrame.repaint();
            if(IsPause){
                break;
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            currentIndex++;
        }
    }
    private void initToolBar(BubbleSortModel model){
        for (int i = currentIndex; i < model.Panels.getComponentCount(); i++) {
            Panel panel = (Panel) model.Panels.getComponent(i);
            panel.setLayout(new BorderLayout());

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

            clickmeButton = new JButton("Play");
            buttonPanel.add(clickmeButton);

            panel.add(buttonPanel,BorderLayout.NORTH);

            clickmeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    if(IsPause){
                        IsPause = false;
                        clickmeButton.setText("Play");
                    }else{
                        clickmeButton.setText("Pause");
                        IsPause = true;
                    }
                }
            });
        }
    }
}