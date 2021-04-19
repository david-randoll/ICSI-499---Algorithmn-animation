package Models;

public class SettingsModel {
    private String color = "";
    private String fontColor = "";
    private int fontSize;

    public void setColor(String color){
        this.color = color;
    }

    public void setFontColor(String color){
        this.fontColor = color;
    }

    public void setFontSize(int size){
        this.fontSize = size;
    }

    public String getColor(){
        return this.color;
    }

    public String getFontColor(){
        return this.fontColor;
    }

    public int getFontSize(){
        return this.fontSize;
    }
}
