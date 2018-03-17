package domain;

import java.util.Objects;

public class Student {
    private static final int MIN_NAME_LENGTH = 2;
    private String name;

    public Student(String name) throws IllegalArgumentException {
        if (MIN_NAME_LENGTH > name.length()) {
            throw new IllegalArgumentException(MIN_NAME_LENGTH + "자 이상 설정해주세요");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Student comparisonStudent = (Student) obj;
        return Objects.equals(name, comparisonStudent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
