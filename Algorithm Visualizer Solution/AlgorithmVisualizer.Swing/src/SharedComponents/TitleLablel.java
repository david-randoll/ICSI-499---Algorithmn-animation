package SharedComponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class TitleLablel extends JLabel {
    public TitleLablel(String title) {
        this.setText(title);
        this.setForeground(new Color(0x5D8EFF));
        this.setFont(new Font(this.getFont().getFamily(),Font.BOLD,60));
        this.setBorder(BorderFactory.createEmptyBorder(75, 0, 0, 0));
    }
}