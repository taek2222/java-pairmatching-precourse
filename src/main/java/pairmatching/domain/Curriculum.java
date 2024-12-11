package pairmatching.domain;

import pairmatching.domain.curriculum.Course;
import pairmatching.domain.curriculum.Level;
import pairmatching.domain.curriculum.Mission;

public class Curriculum {

    private final Course course;
    private final Level level;
    private final Mission mission;

    public Curriculum(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public boolean isFrontendCourse() {
        return this.course == Course.FRONTEND;
    }

    public Course getCourse() {
        return course;
    }
}
