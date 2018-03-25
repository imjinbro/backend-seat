package domain;

import utils.DirectionType;

public class Direction {
    private boolean isLeft;
    private boolean isDown;
    private boolean isRight;

    private Direction(boolean isLeft, boolean isDown, boolean isRight) {
        this.isLeft = isLeft;
        this.isDown = isDown;
        this.isRight = isRight;
    }

    public static Direction valueOf(DirectionType type) {
        return new Direction(type.isLeft(), type.isDown(), type.isRight());
    }

    public boolean canMoveLeft() {
        return isLeft;
    }

    public boolean canMoveDown() {
        return isDown;
    }

    public boolean canMoveRight() {
        return isRight;
    }
}