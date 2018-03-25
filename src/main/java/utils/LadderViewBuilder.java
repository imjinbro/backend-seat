package utils;

import domain.Ladder;
import domain.Student;
import domain.Students;

public class LadderViewBuilder {

    public static String build(Ladder ladder, Students students) {
        int maxContentLength = students.getMaxNameLength();
        int playerNum = students.getStudentNumber();
        return buildSelectorTab(students, maxContentLength) +
                buildLadder(ladder, LadderUtils.calcPointNumOfLine(playerNum), maxContentLength) +
                buildPartnerTab(students, maxContentLength);
    }

    private static String buildSelectorTab(Students students, int maxContentLength) {
        StringBuilder builder = new StringBuilder();
        for (Student student : students.getSelectorStudents()) {
            builder.append(LadderViewFormat.formatTab(student.getName(), maxContentLength));
        }
        builder.append("\n");
        return builder.toString();
    }

    private static String buildPartnerTab(Students students, int maxContentLength) {
        StringBuilder builder = new StringBuilder();
        for (Student student : students.getPartnerStudents()) {
            builder.append(LadderViewFormat.formatTab(student.getName(), maxContentLength));
        }
        builder.append("\n");
        return builder.toString();
    }

    private static String buildLadder(Ladder ladder, int pointNum, int maxContentLength) {
        StringBuilder builder = new StringBuilder();
        int heightIdx = 0;
        while (!ladder.isMaxHeight(heightIdx)) {
            builder.append(buildLine(ladder, heightIdx, pointNum, maxContentLength));
            builder.append("\n");
            heightIdx = ladder.moveDown(heightIdx);
        }
        return builder.toString();
    }

    private static String buildLine(Ladder ladder, int heightIdx, int pointNum, int maxContentLength) {
        StringBuilder builder = new StringBuilder();
        for (int position = 0; position < pointNum; position++) {
            boolean canDraw = ladder.isMovablePosition(heightIdx, position);
            builder.append(buildLadderLetter(canDraw, position, maxContentLength));
        }
        return LadderViewFormat.formatLine(builder.toString(), maxContentLength);
    }

    static String buildLadderLetter(boolean canDraw, int position, int maxContentLength) {
        if (isEvenNumPosition(position)) {
            return "|";
        }

        if (canDraw) {
            return repeatLadderLetter('-', maxContentLength);
        }
        return repeatLadderLetter(' ', maxContentLength);
    }

    private static boolean isEvenNumPosition(int position) {
        return position % 2 == 0;
    }

    private static String repeatLadderLetter(char ladderLetter, int repeatNumber) {
        char[] result = new char[repeatNumber];
        for (int i = 0; i < result.length; i++) {
            result[i] = ladderLetter;
        }
        return String.valueOf(result);
    }
}
