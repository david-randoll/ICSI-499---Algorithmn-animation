/*****************************************************************************************
  Default styling to be used throughout program. Can bee updated using the settings page
 *****************************************************************************************/

public class Styles {
    private String theme;
    private String background;
    private int textSize;
    private String textColor;
    private int opacity;
    

    //Initialize with default color scheme
    Styles(){
        this.theme =;
        this.background = ;
        this.textSize = ;
        this.textColor = ;
        this.opacity = ;
    }

    //Accessors
    public String getTheme(){
        return this.theme;
    }

    public String getBackground(){
        return this.background;
    }

    public int getTextSize(){
        return this.textSize;
    }

    public String getTextColor(){
        return this.textColor;
    }

    public int getOpacity(){
        return this.opacity;
    }

    //Mutators
    public void setTheme(String theme){
        this.theme = theme;
    }

    public void setBackground(String background){
        this.background = background;
    }

    public void setTextSize(String textSize){
        this.textSize = textSize;
    }

    public void setTextColor(String textColor){
        this.textColor = textColor;
    }

    public void setOpacity(String opacity){
        this.opacity = opacity;
    }
}
