package swing.bieudo;

import java.awt.Color;

public class ModelLegends {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ModelLegends(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public ModelLegends() {
    }

    private String name;
    private Color color;
}
