package domain;

import utils.LadderUtils;

import java.util.ArrayList;

import static utils.LineCreator.createLine;

public class Ladder {
    private static final int HEIGHT = 15;
    private ArrayList<Line> ladder = new ArrayList<>();

    public Ladder(int playerNum) {
        int pointNum = LadderUtils.calcPointNumOfLine(playerNum);
        for (int h = 0; h < HEIGHT; h++) {
            Line line = new Line(createLine(pointNum));
            ladder.add(line);
        }
    }

    public boolean isMovablePosition(int heightIdx, int position) {
        if (isMaxHeight(heightIdx)) {
            return false;
        }
        Line selectedLine = ladder.get(heightIdx);
        return selectedLine.isMovablePosition(position);
    }

    public boolean isStudentPosition(int position) {
        Line firstLine = getFirstLine();
        return firstLine.isPlayerPosition(position);
    }

    public boolean isMaxHeight(int heightIdx) {
        return HEIGHT == heightIdx;
    }

    public boolean isLimitPointNum(int pointIdx) {
        Line firstLine = getFirstLine();
        return firstLine.isLimitPointNum(pointIdx);
    }

    private Line getFirstLine() {
        Line firstLine = ladder.get(0);
        return firstLine;
    }

    public boolean canLeftMove(int heightIdx, int position) {
        Line line = ladder.get(heightIdx);
        return line.canLeftMove(position);
    }

    public boolean canRightMove(int heightIdx, int position) {
        Line line = ladder.get(heightIdx);
        return line.canRightMove(position);
    }

    public int moveLeft(int heightIdx, int position) {
        Line line = ladder.get(heightIdx);
        return line.moveLeft(position);
    }

    public int moveDown(int heightIdx) {
        return heightIdx + 1;
    }

    public int moveRight(int heightIdx, int position) {
        Line line = ladder.get(heightIdx);
        return line.moveRight(position);
    }
}
