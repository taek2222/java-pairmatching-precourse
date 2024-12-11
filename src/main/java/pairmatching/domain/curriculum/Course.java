package pairmatching.domain.curriculum;

import java.util.Arrays;
import java.util.List;
import pairmatching.domain.dto.curriculum.CourseResponse;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course findCourseByName(String name) {
        return Arrays.stream(values())
                .filter(course -> course.name.equals(name))
                .findFirst()
                .orElseThrow();
    }

    public static CourseResponse createResponse() {
        List<String> names = Arrays.stream(values())
                .map(course -> course.name)
                .toList();

        return new CourseResponse(names);
    }
}