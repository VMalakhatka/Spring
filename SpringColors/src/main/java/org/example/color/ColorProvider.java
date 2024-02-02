package org.example.color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ColorProvider {
    private Map<String,Color> nameToColor;

    @Autowired
    public ColorProvider(Map<String, Color> nameToColor) {
        this.nameToColor = nameToColor;
    }

    public Map<String, Color> getNameToColor() {
        return nameToColor;
    }
    public Color getColor(String name){
        return nameToColor.get(name.toLowerCase());
    }
}
