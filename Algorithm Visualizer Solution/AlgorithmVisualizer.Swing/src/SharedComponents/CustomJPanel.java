package SharedComponents;

import res.Styles;

import javax.swing.*;

public class CustomJPanel extends JPanel {
    JLabel titleLabel;

    public CustomJPanel(String titleName) {
        titleLabel = new TitleLabel(titleName);
        this.add(this.titleLabel);
        this.setBackground(Styles.APP_BACKGROUNDCOLOR);
    }
<<<<<<< Updated upstream:Algorithm Visualizer Solution/AlgorithmVisualizer.Swing/src/SharedComponents/CustomJPanel.java
=======

    public CustomJPanel() {

    }
>>>>>>> Stashed changes:Algorithm Visualizer Solution/AlgorithmVisualizer.Swing/src/Shared/Components/CustomJPanel.java
}