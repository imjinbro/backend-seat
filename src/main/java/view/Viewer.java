package view;

import domain.Ladder;
import domain.Results;
import domain.Students;

import java.util.Calendar;

public class Viewer {
    public static void viewLadder(Ladder ladder, Students students) {
        StringBuilder builder = new StringBuilder();
        builder.append("**************** ");
        builder.append(getTodayMessage());
        builder.append(", 오늘 내 짝꿍은 누구?");
        builder.append(" ****************\n\n");
        builder.append(LadderViewBuilder.build(ladder, students));

        System.out.println(builder.toString());
    }

    public static void viewResult(Results results) {
        StringBuilder builder = new StringBuilder();
        builder.append("************************** ");
        builder.append("오늘의 짝꿍");
        builder.append(" **************************\n");
        builder.append(ResultViewBuilder.build(results));
        builder.append("****************************************************************");

        System.out.println(builder.toString());
    }

    private static String getTodayMessage() {
        StringBuilder builder = new StringBuilder();

        Calendar calendar = Calendar.getInstance();
        builder.append(calendar.get(Calendar.MONTH) + 1).append("월 ");
        builder.append(calendar.get(Calendar.DATE)).append("일 ");
        builder.append(convertDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK))).append("요일");

        return builder.toString();
    }

    private static String convertDayOfWeek(int dayOfWeek) {
        int dayOfWeekIdx = dayOfWeek - 1;
        String[] date = {"일", "월", "화", "수", "목", "금", "토"};
        return date[dayOfWeekIdx];
    }
}
