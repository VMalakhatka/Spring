package ru.cft.javaLessons.miner.model.field;

import ru.cft.javaLessons.miner.common.interfaces.game.GameModel;
import ru.cft.javaLessons.miner.common.interfaces.game.GameResult;
import ru.cft.javaLessons.miner.common.interfaces.game.GameState;
import ru.cft.javaLessons.miner.common.interfaces.game.GameType;
import ru.cft.javaLessons.miner.common.exception.GameException;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Field implements GameModel {
    private Cell[][] cells;

    private Set<CellAddress> mineAddresses;

    private GameResult result = GameResult.UNDEFINED;

    private int countOfMine;
    private GameType type;


    public Field(GameType type) {
        this.type = type;
        cells = new Cell[type.getRows()][type.getColumns()];
        fillInCells();
        this.countOfMine = type.getMineCount();
    }

    private void fillWithBomb(int openedRow, int openedColumn) {
        mineAddresses = getRandomAddresses(countOfMine, cells, openedRow, openedColumn);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(isMined(i, j), cells[i][j].isBlocked(), false, countOfMinesAround(i, j));
            }
        }
    }

    private void fillInCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(false, false, false, 0);
            }
        }
    }

    public GameResult getResult() {
        return result;
    }

    public Cell[][] getCells() {
        return cells.clone();
    }

    private void checkCellAddress(int row, int column) {
        if (row >= cells.length || column >= cells[row].length) {
            throw new GameException("Передан неправильный адрес ячейки");
        }
    }

    private void checkWin() {
        int closedCells = 0;
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if (!cell.isOpened()) {
                    closedCells++;
                }
            }
        }
        if (closedCells == mineAddresses.size()) {
            this.result = GameResult.WIN;
        }
    }

    public int countFlags() {
        int countFlags = 0;
        for (Cell[] cell : cells) {
            for (Cell value : cell) {
                if (value.isBlocked()) countFlags++;
            }
        }
        return countFlags;
    }

    @Override
    public GameState setFlag(int row, int column) {
        checkCellAddress(row, column);
        Cell cell = cells[row][column];
        if (cell.isOpened()) return getState();
        Cell newCell = cell;
        if (cell.isBlocked()) {
            newCell = cell.unBlock();
        } else {
            if (countFlags() < mineAddresses.size()) {
                newCell = cell.block();
            }
        }
        cells[row][column] = newCell;
        return getState();
    }

    @Override
    public GameState openCells(int row, int column) {
        checkCellAddress(row, column);
        if (isAllClose()) fillWithBomb(row, column);

        Cell cell = cells[row][column];
        if (cell.isOpened()) return getState();

        Cell newCell = openCellDirectly(cell, row, column);
        if (newCell.isMine()) {
            openMinedCells();
            return getState();
        }

        checkWin();
        if (newCell.countMineAround() > 0) return getState();

        massOpen(new CellAddress(row, column));
        return getState();
    }

    @Override
    public GameState getState() {
        return FieldMapper.mapField(this);
    }

    @Override
    public void startNewGame(GameType gameType) {
        this.type = gameType;
        cells = new Cell[gameType.getRows()][gameType.getColumns()];
        fillInCells();
        countOfMine = gameType.getMineCount();
        result = GameResult.UNDEFINED;
        mineAddresses = new HashSet<>();
    }

    private boolean isAllClose() {
        for (Cell[] row : cells) {
            for (Cell c : row) {
                if (c.isOpened()) return false;
            }
        }
        return true;
    }

    private Cell openCellDirectly(Cell cell, int row, int column) {
        Cell newCell = cell.open();
        cells[row][column] = newCell;
        return newCell;
    }

    private void openMinedCells() {
        result = GameResult.LOSE;
        for (CellAddress address : mineAddresses) {
            Cell cell = cells[address.row][address.colum];
            if (cell.isBlocked() || cell.isOpened()) continue;
            openCellDirectly(cell, address.row, address.colum);
        }
    }

    private void massOpen(CellAddress address) {
        Set<CellAddress> nearest = getAddressesAround(address.row, address.colum);
        Set<CellAddress> rest = new HashSet<>();
        for (CellAddress a : nearest) {
            Cell c = cells[a.row][a.colum];
            if (c.isOpened() || c.isBlocked() || c.isMine()) continue;
            openCellDirectly(c, a.row, a.colum);
            if (c.countMineAround() == 0) rest.add(a);
        }
        for (CellAddress a : rest) {
            massOpen(a);
        }
    }

    private boolean isMined(int row, int column) {
        return mineAddresses.contains(new CellAddress(row, column));
    }

    private Set<CellAddress> getAddressesAround(int row, int column) {
        Set<CellAddress> nearest = new HashSet<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((i == 0 && j == 0) ||
                        (row + i > cells.length - 1 || column + j > cells[row].length - 1) ||
                        (row + i < 0 || column + j < 0)) continue;
                nearest.add(new CellAddress(row + i, column + j));
            }
        }
        return nearest;
    }

    private int countOfMinesAround(int row, int column) {
        Set<CellAddress> nearest = getAddressesAround(row, column);
        nearest.retainAll(mineAddresses);
        return nearest.size();
    }

    public int getCountOfMine() {
        return countOfMine;
    }

    public GameType getType() {
        return type;
    }

    private Set<CellAddress> getRandomAddresses(int countOfMine, Cell[][] cells, int openedRow, int openedColumn) {
        Random random = new Random();
        Set<CellAddress> addresses = new HashSet<>(countOfMine);
        while (addresses.size() < countOfMine) {
            int row = random.nextInt(cells.length);
            int colum = random.nextInt(cells[0].length);
            if (row == openedRow && colum == openedColumn) continue;
            CellAddress cellAddress = new CellAddress(row, colum);
            addresses.add(cellAddress);
        }
        return addresses;
    }

    private record CellAddress(int row, int colum) {
    }
}
