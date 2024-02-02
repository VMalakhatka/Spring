package ru.cft.javaLessons.miner.common.interfaces.game;

public enum GameType {
    //    NOVICE(4, 1, 1), //FIXME раскомментируй, а следующую закомментируй, чтобы проще было проверять рекорды. Перед сдачей удали
    NOVICE(9, 9, 10),
    MEDIUM(16, 16, 40),
    EXPERT(30, 16, 99);

    public static final GameType DEFAULT = NOVICE;

    private final int rows;
    private final int columns;

    private final int mineCount;

    GameType(int rows, int columns, int mineCount) {
        this.rows = rows;
        this.columns = columns;
        this.mineCount = mineCount;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getMineCount() {
        return mineCount;
    }
}
