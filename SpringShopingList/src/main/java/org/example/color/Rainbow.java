package org.example.color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Rainbow {
    private List<Color> colors;

    @Autowired
    public Rainbow(List<Color> colors) {
        this.colors = colors;
    }

    public List<Color> getColors() {
        return colors;
    }
}
