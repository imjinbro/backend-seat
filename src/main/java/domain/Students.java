package domain;

import java.util.*;

public class Students {
    private static final int MIN_STUDENT_NUM = 2;
    private ArrayList<Student> students = new ArrayList<>();
    private int maxNameLength = -1;

    private Students() throws IllegalArgumentException {
        String[] names = StudentNames.getNames();
        verifyName(names);
        initNames(names);
    }

    public static Students valueOf() {
        return new Students();
    }

    private void verifyName(String[] names) throws IllegalArgumentException {
        if (isInvalidStudentNum(names)) {
            throw new IllegalArgumentException(MIN_STUDENT_NUM + "명 이상이어야 합니다.");
        }

        if (isOddNumStudentNum(names)) {
            throw new IllegalArgumentException("짝수 인원이어야 합니다.");
        }

        if (searchDuplicateName(names)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private void initNames(String[] splitNames) {
        for (String name : splitNames) {
            students.add(new Student(name));
        }
        Collections.shuffle(students);
    }

    static boolean isInvalidStudentNum(String[] names) {
        return MIN_STUDENT_NUM > names.length;
    }

    static boolean searchDuplicateName(String[] names) {
        HashSet<String> nameBox = new HashSet<>(Arrays.asList(names));
        return names.length != nameBox.size();
    }

    static boolean isOddNumStudentNum(String[] names) {
        return names.length % 2 != 0;
    }

    public String getStudentName(int position) {
        Student searchStudent = students.get(position);
        return searchStudent.getName();
    }

    public int getStudentNumber() {
        return students.size();
    }

    public int getMaxNameLength() {
        if (maxNameLength != -1) {
            return maxNameLength;
        }
        maxNameLength = searchMaxNameLength();
        return maxNameLength;
    }

    private int searchMaxNameLength() {
        return Arrays.stream(StudentNames.getNames()).map(String::length).min(Comparator.reverseOrder()).get();
    }

    public ArrayList<Student> getSelectorStudents() {
        int halfNum = students.size() / 2;
        ArrayList<Student> selectorStudents = new ArrayList<>();
        for (int i = 0; i < halfNum; i++) {
            selectorStudents.add(students.get(i));
        }
        return selectorStudents;
    }

    public ArrayList<Student> getPartnerStudents() {
        int halfNum = students.size() / 2;
        ArrayList<Student> partnerStudents = new ArrayList<>();
        for (int i = halfNum; i < students.size(); i++) {
            partnerStudents.add(students.get(i));
        }
        return partnerStudents;
    }

    public int getSelectorStudentIdx(int studentPos) {
        int spaceIdxTerm = 2;
        return studentPos / spaceIdxTerm;
    }

    public int getPartnerStudentIdx(int studentPos) {
        int spaceIdxTerm = 2;
        int halfNum = students.size() / 2;
        return studentPos / spaceIdxTerm + halfNum;
    }
}

class StudentNames {
    private static String[] names = new String[]{"colin", "jepak", "koo", "larry", "learner", "riverway", "chloe", "gram", "saru", "dino", "sangco", "jimmy", "link", "pobi"};

    public static String[] getNames() {
        return names;
    }
}
