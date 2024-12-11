package pairmatching.domain.crew;

import pairmatching.domain.curriculum.Course;

public class Crew {

    private final Course course;
    private final String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public boolean isSameCourse(Course course) {
        return this.course == course;
    }

    public String getName() {
        return name;
    }
}