package SharedComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortingToolBar {
    JButton clickmeButton;
    boolean pause = false;

    public SortingToolBar(JPanel panel) {
        panel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        clickmeButton = new JButton("Click Me");
        buttonPanel.add(clickmeButton);

        panel.add(buttonPanel, BorderLayout.NORTH);

        clickmeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (pause) {
                    pause = false;
                    clickmeButton.setText("play");
                } else {
                    clickmeButton.setText("pause");
                    pause = true;
                }
            }
        });
    }

    public void setButtonText(String text) {
        clickmeButton.setText(text);
    }

    public boolean IsPause() {
        return pause;
    }

}
