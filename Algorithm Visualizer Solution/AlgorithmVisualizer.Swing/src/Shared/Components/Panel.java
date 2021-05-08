package Shared.Components;

import Shared.RectangleElement;
import Shared.res.Styles;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static int MIDPOINT_HORIZONTAL = (screenSize.width / 2);
    static int MIDPOINT_VERTICAL = (screenSize.height / 2);

    Rectangle[] RECTANGLES;
    String TITLE;
    String INSTRUCTION;
    RectangleElement[] ELEMENTS;

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        drawTitle(g, TITLE);
        drawElements(g);
        drawInstructionOnScreen(g);
    }

    void drawTitle(Graphics g, String title) {
        Font titleFont = new Font("Arial", Font.PLAIN, Styles.PAGE_TITLE_FONTSIZE);
        FontMetrics metrics = g.getFontMetrics(titleFont);
        g.setFont(titleFont);

        int titleX = MIDPOINT_HORIZONTAL - (metrics.stringWidth(title) / 2);
        int titleY = titleFont.getSize() - metrics.getHeight() + metrics.getAscent();

        g.setColor(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        g.drawString(title, titleX, titleY);
        drawElements(g);
    }

    public Panel(String title, RectangleElement[] elements, String instruction) {
        TITLE = title;
        ELEMENTS = cloneRectangleElement(elements);
        RECTANGLES = buildRectangles();
        INSTRUCTION = instruction;
        this.setLayout(null);//using no layout managers
        this.setBackground(Styles.APP_BACKGROUNDCOLOR);
        this.setPreferredSize(new Dimension(screenSize.width, (int) (screenSize.height * 0.77)));
    }

    private RectangleElement[] cloneRectangleElement(RectangleElement[] elements) {
        RectangleElement[] output = new RectangleElement[elements.length];
        for (int i = 0; i < elements.length; i++) {
            output[i] = new RectangleElement();
            output[i].setDataValue(elements[i].getDataValue());
            output[i].setForegroundColor(elements[i].getForegroundColor());
            output[i].setBackgroundColor(elements[i].getBackgroundColor());
            output[i].setBorderColor(elements[i].getBorderColor());
        }
        return output;
    }

    Rectangle[] buildRectangles() {
        int ALGORITHM_ELEMENT_HEIGHT = screenSize.height / (ELEMENTS.length * 2);
        int ALGORITHM_ELEMENT_WIDTH = screenSize.width / (ELEMENTS.length * 2);
        int TOTAL_GAP_SIZE = (screenSize.width - (ALGORITHM_ELEMENT_WIDTH * ELEMENTS.length));
        int GAP_SIZE = TOTAL_GAP_SIZE / (ELEMENTS.length + 1); //There will be n + 1 gaps for n elements
        int X_POSITION = GAP_SIZE;

        Rectangle[] output = new Rectangle[ELEMENTS.length];

        for (int i = 0; i < ELEMENTS.length; i++) {
            Rectangle POSITIONING_RECTANGLE = new Rectangle(X_POSITION, MIDPOINT_VERTICAL, ALGORITHM_ELEMENT_WIDTH, ALGORITHM_ELEMENT_HEIGHT);
            X_POSITION += ALGORITHM_ELEMENT_WIDTH + GAP_SIZE;
            output[i] = POSITIONING_RECTANGLE;
        }
        return output;
    }

    void drawElements(Graphics g) {
        int fontSize = RECTANGLES[0].height - 10;
        Font stringFont = new Font("Arial", Font.PLAIN, (fontSize < 0) ? 0 : fontSize);
        FontMetrics metrics = g.getFontMetrics(stringFont);
        g.setFont(stringFont);

        for (int i = 0; i < RECTANGLES.length; i++) {
            String currentValue = Integer.toString(ELEMENTS[i].getDataValue());
            Rectangle currentRectangle = RECTANGLES[i];

            g.setColor(ELEMENTS[i].getBackgroundColor());
            drawRectangle(g, currentRectangle);
            drawElementData(g, currentValue, currentRectangle, metrics, ELEMENTS[i].getForegroundColor());

            //if there is a border we need to outline it
            if (ELEMENTS[i].getBorderColor() != null) {
                outlineRectangle(g, RECTANGLES[i], ELEMENTS[i].getBorderColor());
            }
        }
    }

    void drawRectangle(Graphics g, Rectangle rectangle) {
        g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    void drawElementData(Graphics g, String currentValue, Rectangle currentRectangle, FontMetrics metrics, Color color) {
        int stringX = currentRectangle.x + ((currentRectangle.width - metrics.stringWidth(currentValue)) / 2);
        int stringY = currentRectangle.y + (currentRectangle.height - metrics.getHeight()) / 2 + metrics.getAscent();
        g.setColor(color);
        g.drawString(currentValue, stringX, stringY);
    }

    void drawInstructionOnScreen(Graphics g) {
        g.setFont(Styles.INSTRUCTION_FONT);
        g.setColor(Styles.INSTRUCTION_FONT_COLOR);

        FontMetrics metrics = getFontMetrics(Styles.INSTRUCTION_FONT);
        g.drawString(INSTRUCTION, MIDPOINT_HORIZONTAL - (metrics.stringWidth(INSTRUCTION) / 2), (int) (RECTANGLES[0].getY() - RECTANGLES[0].getHeight()));
    }

    void outlineRectangle(Graphics g, Rectangle rectangle, Color borderColor) {
        int BORDER_SIZE = 5;
        int rectangleX = rectangle.x - BORDER_SIZE;
        int rectangleY = rectangle.y - BORDER_SIZE;
        int rectangleWidth = rectangle.width + (BORDER_SIZE * 2);
        int rectangleHeight = rectangle.height + (BORDER_SIZE * 2);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(BORDER_SIZE));
        g2.drawRoundRect(rectangleX, rectangleY, rectangleWidth, rectangleHeight, 5, 5);
    }
}
