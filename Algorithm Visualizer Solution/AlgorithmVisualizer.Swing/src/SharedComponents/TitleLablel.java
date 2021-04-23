package SharedComponents;

import res.Styles;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class TitleLablel extends JLabel {
    public TitleLablel(String title) {
        this.setText(title);
        this.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        this.setFont(new Font(this.getFont().getFamily(),Font.BOLD,Styles.PAGE_TITLE_FONTSIZE));
        this.setBorder(BorderFactory.createEmptyBorder(75, 0, 0, 0));
    }
}