package ru.cft.javaLessons.miner.model.field;

import ru.cft.javaLessons.miner.common.interfaces.game.CellDto;
import ru.cft.javaLessons.miner.common.interfaces.game.GameState;

public class FieldMapper {
    private FieldMapper() {}

    public static CellDto mapCell(Cell cell) {
        return new CellDto(cell.isMine(), cell.isBlocked(), cell.isOpened(), cell.countMineAround());
    }
    public static CellDto[][] mapAllCells(Cell[][] cells) {
        CellDto[][] cellDtos = new CellDto[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cellDtos[i][j] = mapCell(cells[i][j]);
            }
        }
        return cellDtos;
    }

    public static GameState mapField(Field field) {
        return new GameState(
                mapAllCells(field.getCells()),
                field.getCountOfMine() - field.countFlags(),
                field.getResult(),
                field.getType()
        );
    }
}
