package SharedComponents;

import res.Styles;

import javax.swing.*;
import java.awt.*;

public class TitleLabel extends JLabel {
    public TitleLabel(String title) {
        this.setText(title);
        this.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        this.setFont(new Font(this.getFont().getFamily(), Font.BOLD, Styles.PAGE_TITLE_FONTSIZE));
        this.setBorder(BorderFactory.createEmptyBorder(75, 0, 0, 0));
    }
}