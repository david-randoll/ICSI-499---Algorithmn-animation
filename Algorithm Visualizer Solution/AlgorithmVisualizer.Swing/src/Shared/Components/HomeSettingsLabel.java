package Shared.Components;

import res.Styles;

import javax.swing.*;
import java.awt.*;

public class HomeSettingsLabel extends JLabel {
    public HomeSettingsLabel(String title) {
        this.setText(title);
        this.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        this.setFont(new Font(this.getFont().getFamily(), Font.BOLD, Styles.PAGE_TITLE_FONTSIZE));
        this.setBorder(BorderFactory.createEmptyBorder(75, 0, 0, 0));
    }
}
