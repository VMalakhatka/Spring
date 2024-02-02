package org.example.color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FavoriteColor {
    private Color color;

    @Autowired
    public FavoriteColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
