package SharedComponents;

import Views.SortingAlgorithms.BinarySearchView;
import res.Styles;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Panel extends JPanel {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static int MIDPOINT_HORIZONTAL = (screenSize.width / 2);
    static int MIDPOINT_VERTICAL = (screenSize.height / 2);
    int[] USER_INPUT;
    Rectangle[] RECTANGLES;
    Integer[] HIGHLIGHT_INDICES;
    Integer[] ENABLED_INDICES;
    String TITLE;
    String CONDITION;
    public SortingToolBar toolBar;

    @Override
    public void paint(Graphics g) {

        super.paintComponents(g);
        drawTitle(g, TITLE);
        drawElements(g);
        if (HIGHLIGHT_INDICES != null) {
            for (int i = 0; i < HIGHLIGHT_INDICES.length; i++) {
                outlineRectangle(g, RECTANGLES[HIGHLIGHT_INDICES[i]]);
            }
        }
        searchHandling(g);
    }

    public Panel(String title, int[] data, Integer[] highlightIndices, String condition) {
        USER_INPUT = data.clone();
        HIGHLIGHT_INDICES = highlightIndices;
        RECTANGLES = buildRectangles(USER_INPUT);
        TITLE = title;
        CONDITION = condition;
        this.setLayout(null);//using no layout managers
        this.setBackground(Styles.APP_BACKGROUNDCOLOR);
        this.setPreferredSize(new Dimension(screenSize.width, (int) (screenSize.height * 0.85)));
    }

    public Panel(String title, int[] data, Integer[] enabledIndices, Integer[] highlightIndices, String condition) {
        USER_INPUT = data.clone();
        HIGHLIGHT_INDICES = highlightIndices;
        ENABLED_INDICES = enabledIndices;
        RECTANGLES = buildRectangles(USER_INPUT);
        TITLE = title;
        CONDITION = condition;
        this.setLayout(null);//using no layout managers
        this.setBackground(Styles.APP_BACKGROUNDCOLOR);
    }

    public int[] getFrameInput() {
        return USER_INPUT;
    }

    public Rectangle[] getFrameRectangles() {
        return RECTANGLES;
    }

    void drawElements(Graphics g) {
        Font stringFont = new Font("Arial", Font.PLAIN, RECTANGLES[0].height - 10);
        FontMetrics metrics = g.getFontMetrics(stringFont);
        g.setFont(stringFont);

        for (int i = 0; i < RECTANGLES.length; i++) {
            String currentValue = Integer.toString(USER_INPUT[i]);
            Rectangle currentRectangle = RECTANGLES[i];

            if (TITLE.equalsIgnoreCase("Binary Search")) {
                try {
                    if (Arrays.asList(ENABLED_INDICES).contains(i)) {
                        g.setColor(Styles.ELEMENT_COLOR);
                    } else {
                        g.setColor(Styles.APP_BACKGROUNDCOLOR);
                    }
                    drawRectangle(g, currentRectangle);
                    drawElementData(g, currentValue, currentRectangle, metrics, Color.red);

                } catch (NullPointerException e) {
                   if (CONDITION.equalsIgnoreCase("start")) {
                       g.setColor(Styles.ELEMENT_COLOR);
                   } else {
                       g.setColor(Styles.APP_BACKGROUNDCOLOR);
                   }
                   drawRectangle(g, currentRectangle);
                   drawElementData(g, currentValue, currentRectangle, metrics, Color.red);
               }
            } else if (TITLE.equalsIgnoreCase("Bubble Sort")){
                try {
                    if (Arrays.asList(ENABLED_INDICES).contains(i)) {
                        g.setColor(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
                        drawRectangle(g, currentRectangle);
                        drawElementData(g, currentValue, currentRectangle, metrics, Color.black);
                    } else {
                        g.setColor(Styles.ELEMENT_COLOR);
                        drawRectangle(g, currentRectangle);
                        drawElementData(g, currentValue, currentRectangle, metrics, Color.red);
                    }


                } catch (NullPointerException e) {
                    if (CONDITION.equalsIgnoreCase("start")) {
                        g.setColor(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
                        drawRectangle(g, currentRectangle);
                        drawElementData(g, currentValue, currentRectangle, metrics, Color.black);
                    } else {
                        g.setColor(Styles.ELEMENT_COLOR);
                        drawRectangle(g, currentRectangle);
                        drawElementData(g, currentValue, currentRectangle, metrics, Color.red);
                    }
                }

            } else {
                g.setColor(Styles.ELEMENT_COLOR);
                drawRectangle(g, currentRectangle);
                drawElementData(g, currentValue, currentRectangle, metrics, Color.red);
            }
        }
    }

    void drawRectangle(Graphics g, Rectangle rectangle) {
        g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    void drawTitle(Graphics g, String title) {
        Font titleFont = new Font("Arial", Font.PLAIN, Styles.PAGE_TITLE_FONTSIZE);
        FontMetrics metrics = g.getFontMetrics(titleFont);
        g.setFont(titleFont);

        int titleX = MIDPOINT_HORIZONTAL - (metrics.stringWidth(title) / 2);
        int titleY = titleFont.getSize() + metrics.getHeight() + metrics.getAscent();

        g.setColor(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        g.drawString(title, titleX, titleY);
        drawElements(g);
    }

    void drawSearchValue(Graphics g, String title) {
        Font titleFont = new Font("Arial", Font.PLAIN, 30);
        g.setFont(titleFont);

        g.setColor(Color.GREEN);
        g.drawString(title, 15, (int) RECTANGLES[0].getY() - 25);
    }

    void outlineRectangle(Graphics g, Rectangle rectangle) {
        int BORDER_SIZE = 10;
        int rectangleX = rectangle.x - BORDER_SIZE;
        int rectangleY = rectangle.y - BORDER_SIZE;
        int rectangleWidth = rectangle.width + (BORDER_SIZE * 2);
        int rectangleHeight = rectangle.height + (BORDER_SIZE * 2);
        Graphics2D g2 = (Graphics2D) g;

        //Case for when swapping to highlight indices
        if (CONDITION.equals("swap")) {
            g2.setColor(Styles.SWAP_COLOR);
        } else if (CONDITION.equals("found")) {
            g2.setColor(Styles.FOUND_COLOR);
        } else if (CONDITION.equals("not found")) {
            g2.setColor(Styles.APP_BACKGROUNDCOLOR);
        } else {
            g2.setColor(Styles.SEARCHING_COLOR);
        }
        g2.setStroke(new BasicStroke(BORDER_SIZE));
        g2.drawRoundRect(rectangleX, rectangleY, rectangleWidth, rectangleHeight, 5, 5);
    }

    void searchHandling(Graphics g){
        try{
            Integer.valueOf(CONDITION);
            drawSearchValue(g, "Searching for: " + CONDITION);
        }catch(NumberFormatException e){}

        if(CONDITION.contains("not found")){
            drawSearchValue(g, CONDITION);
        }
    }

    Rectangle[] buildRectangles(int[] inputs) {
        int ALGORITHM_ELEMENT_HEIGHT = screenSize.height / (inputs.length * 2);
        int ALGORITHM_ELEMENT_WIDTH = screenSize.width / (inputs.length * 2);
        int TOTAL_GAP_SIZE = (screenSize.width - (ALGORITHM_ELEMENT_WIDTH * inputs.length));
        int GAP_SIZE = TOTAL_GAP_SIZE / (inputs.length + 1); //There will be n + 1 gaps for n elements
        int X_POSITION = GAP_SIZE;

        Rectangle[] output = new Rectangle[inputs.length];

        for (int i = 0; i < inputs.length; i++) {
            Rectangle POSITIONING_RECTANGLE = new Rectangle(X_POSITION, MIDPOINT_VERTICAL, ALGORITHM_ELEMENT_WIDTH, ALGORITHM_ELEMENT_HEIGHT);
            X_POSITION += ALGORITHM_ELEMENT_WIDTH + GAP_SIZE;
            output[i] = POSITIONING_RECTANGLE;
        }
        return output;
    }

    void drawElementData(Graphics g, String currentValue, Rectangle currentRectangle, FontMetrics metrics, Color color) {
        int stringX = currentRectangle.x + ((currentRectangle.width - metrics.stringWidth(currentValue)) / 2);
        int stringY = currentRectangle.y + (currentRectangle.height - metrics.getHeight()) / 2 + metrics.getAscent();
        g.setColor(color);
        g.drawString(currentValue, stringX, stringY);
    }

    public void setTitle(String title) {
        TITLE = title;
    }
}
