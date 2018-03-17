import domain.Ladder;
import domain.LadderMatcher;
import domain.Results;
import domain.Students;
import view.Viewer;

public class Main {

    public static void main(String[] args) {
        Main.start();
    }

    public static void start() {
        Students students = Students.valueOf();
        Ladder ladder = new Ladder(students.getStudentNumber());
        Viewer.viewLadder(ladder, students);

        Results allResult = LadderMatcher.match(ladder, students);
        Viewer.viewResult(allResult);
    }
}
