package SharedComponents;

import res.Styles;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static int MIDPOINT_HORIZONTAL = (screenSize.width / 2);
    static int MIDPOINT_VERTICAL = (screenSize.height / 2);
    int[] USER_INPUT;
    Rectangle[] RECTANGLES;
    Integer HIGHLIGHT_INDEX;
    String TITLE;

    @Override
    public void paint(Graphics g){

        super.paintComponents(g);


        drawTitle(g, TITLE);
        drawElements(g);
        if(HIGHLIGHT_INDEX != null) {
            outlineRectangle(g, RECTANGLES[HIGHLIGHT_INDEX]);
        }
    }

    public Panel(String title, int[] data, Integer highlightIndex) {
        USER_INPUT = data;
        HIGHLIGHT_INDEX = highlightIndex;
        RECTANGLES = buildRectangles(USER_INPUT);
        TITLE = title;

        this.setLayout(null);//using no layout managers
        this.setBackground(Styles.APP_BACKGROUNDCOLOR);
    }

    public int[] getFrameInput(){
        return USER_INPUT;
    }
    public Rectangle[] getFrameRectangles(){
        return RECTANGLES;
    }

    void drawElements(Graphics g){
        Font stringFont = new Font("Arial",Font.PLAIN, RECTANGLES[0].height - 10);
        FontMetrics metrics = g.getFontMetrics(stringFont);
        g.setFont(stringFont);

        for(int i = 0; i < RECTANGLES.length; i++){
            String currentValue = Integer.toString(USER_INPUT[i]);
            Rectangle currentRectangle = RECTANGLES[i];

            drawRectangle(g,currentRectangle);

            int stringX = currentRectangle.x + ((currentRectangle.width - metrics.stringWidth(currentValue)) / 2);
            int stringY = currentRectangle.y + (currentRectangle.height - metrics.getHeight()) / 2 + metrics.getAscent();

            g.setColor(Color.RED);
            g.drawString(currentValue, stringX, stringY);
        }
    }

    void drawRectangle(Graphics g, Rectangle rectangle){
        g.setColor(Color.white);
        g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    void drawTitle(Graphics g, String title){
        Font titleFont = new Font("Arial",Font.PLAIN, Styles.PAGE_TITLE_FONTSIZE);
        FontMetrics metrics = g.getFontMetrics(titleFont);
        g.setFont(titleFont);

        int titleX = MIDPOINT_HORIZONTAL - (metrics.stringWidth(title) / 2);
        int titleY = titleFont.getSize() + metrics.getHeight() + metrics.getAscent();

        g.setColor(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        g.drawString(title, titleX, titleY);
        drawElements(g);
    }

    void outlineRectangle(Graphics g, Rectangle rectangle){
        int BORDER_SIZE = 10;
        int rectangleX = rectangle.x - BORDER_SIZE;
        int rectangleY = rectangle.y - BORDER_SIZE;
        int rectangleWidth = rectangle.width + (BORDER_SIZE*2);
        int rectangleHeight = rectangle.height + (BORDER_SIZE*2);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.GREEN);
        g2.setStroke(new BasicStroke(BORDER_SIZE));
        g2.drawRect(rectangleX, rectangleY , rectangleWidth, rectangleHeight);
    }

    Rectangle[] buildRectangles(int[] inputs){
        int ALGORITHM_ELEMENT_HEIGHT = screenSize.height / (inputs.length*2);
        int ALGORITHM_ELEMENT_WIDTH = screenSize.width / (inputs.length*2);
        int TOTAL_GAP_SIZE = (screenSize.width - (ALGORITHM_ELEMENT_WIDTH * inputs.length));
        int GAP_SIZE = TOTAL_GAP_SIZE / (inputs.length + 1); //There will be n + 1 gaps for n elements
        int X_POSITION = GAP_SIZE;

        Rectangle[] output = new Rectangle[inputs.length];

        for(int i = 0; i < inputs.length; i++){
            Rectangle POSITIONING_RECTANGLE  = new Rectangle(X_POSITION , MIDPOINT_VERTICAL, ALGORITHM_ELEMENT_WIDTH, ALGORITHM_ELEMENT_HEIGHT);
            X_POSITION += ALGORITHM_ELEMENT_WIDTH + GAP_SIZE;
            output[i] = POSITIONING_RECTANGLE;
        }
        return output;
    }



}
