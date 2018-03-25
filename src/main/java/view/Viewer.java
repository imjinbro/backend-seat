package view;

import domain.Ladder;
import domain.Results;
import domain.Students;

public class Viewer {
    public static void viewLadder(Ladder ladder, Students students) {
        String builder = "****************************** " +
                "이번주 내 짝꿍은 누구?" +
                " ******************************\n\n" +
                LadderViewBuilder.build(ladder, students);

        System.out.println(builder);
    }

    public static void viewResult(Results results) {
        String builder = "************************** " +
                "이번주 내 짝꿍" +
                " **************************\n" +
                ResultViewBuilder.build(results) +
                "****************************************************************";

        System.out.println(builder);
    }
}
