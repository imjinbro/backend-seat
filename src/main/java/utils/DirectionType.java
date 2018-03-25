package utils;

public enum DirectionType {
    NOTMOVE(false, false, false),
    LEFT(true, false, false),
    RIGHT(false, false, true),
    DOWN(false, true, false),
    BOTHSIDES(true, false, true);

    private boolean isLeft;
    private boolean isDown;
    private boolean isRight;

    DirectionType(boolean isLeft, boolean isDown, boolean isRight) {
        this.isLeft = isLeft;
        this.isDown = isDown;
        this.isRight = isRight;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public boolean isDown() {
        return isDown;
    }

    public boolean isRight() {
        return isRight;
    }

}
