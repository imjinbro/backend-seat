package domain;

public class LadderMatcher {

    public static Results match(Ladder ladder, Students students) {
        Results results = new Results();
        int pointIdx = 0;
        while (!ladder.isLimitPointNum(pointIdx)) {
            if (ladder.isStudentPosition(pointIdx)) {
                int studentIdx = students.getSelectorStudentIdx(pointIdx);
                int partnerIdx = students.getPartnerStudentIdx(searchPartnerPosition(ladder, pointIdx));
                results.addResult(students.getStudentName(studentIdx), students.getStudentName(partnerIdx));
            }
            pointIdx++;
        }
        return results;
    }

    private static int searchPartnerPosition(Ladder ladder, int startPosition) {
        int startHeightIdx = 0;
        return doSearch(ladder, startHeightIdx, startPosition);
    }

    private static int doSearch(Ladder ladder, int heightIdx, int pointIdx) {
        if (!ladder.isMovablePosition(heightIdx, pointIdx)) {
            return pointIdx;
        }
        pointIdx = movePosition(ladder, heightIdx, pointIdx);
        return doSearch(ladder, ladder.moveDown(heightIdx), pointIdx);
    }

    private static int movePosition(Ladder ladder, int heightIdx, int pointIdx) {
        int currentPointIdx = moveLeftPosition(ladder, heightIdx, pointIdx);
        currentPointIdx = moveRightPosition(ladder, heightIdx, pointIdx, currentPointIdx);
        return currentPointIdx;
    }

    private static int moveLeftPosition(Ladder ladder, int heightIdx, int pointIdx) {
        int currentPointIdx = pointIdx;
        while (ladder.canLeftMove(heightIdx, currentPointIdx)) {
            currentPointIdx = ladder.moveLeft(heightIdx, currentPointIdx);
        }
        return currentPointIdx;
    }

    private static int moveRightPosition(Ladder ladder, int heightIdx, int startPointIdx, int currentPointIdx) {
        if (startPointIdx != currentPointIdx) {
            return currentPointIdx;
        }

        while (ladder.canRightMove(heightIdx, currentPointIdx)) {
            currentPointIdx = ladder.moveRight(heightIdx, currentPointIdx);
        }
        return currentPointIdx;
    }
}