package ru.cft.javaLessons.miner.view;

import javax.swing.*;

public enum GameImage {
    EMPTY("empty.png"),
    NUM_1("1.png"),
    NUM_2("2.png"),
    NUM_3("3.png"),
    NUM_4("4.png"),
    NUM_5("5.png"),
    NUM_6("6.png"),
    NUM_7("7.png"),
    NUM_8("8.png"),
    CLOSED("cell.png"),
    MARKED("flag.png"),
    BOMB("mine.png"),
    TIMER("timer.png"),
    BOMB_ICON("mineImage.png"),
    ;

    private final String fileName;
    private ImageIcon imageIcon;

    GameImage(String fileName) {
        this.fileName = fileName;
    }

    public synchronized ImageIcon getImageIcon() {
        if (imageIcon == null) {
            imageIcon = new ImageIcon(ClassLoader.getSystemResource(fileName));
        }

        return imageIcon;
    }

    public static GameImage getByNumber(int mineCount) {
        if (mineCount > 0 && mineCount <= 8) {
            for (GameImage image : GameImage.values()) {
                if (image.ordinal() == mineCount) {
                    return image;
                }
            }
        }
        return EMPTY;
    }
}
