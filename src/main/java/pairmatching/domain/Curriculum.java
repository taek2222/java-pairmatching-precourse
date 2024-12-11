package pairmatching.domain;

import java.util.Objects;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Curriculum that = (Curriculum) obj;
        return Objects.equals(course, that.course) &&
                Objects.equals(level, that.level) &&
                Objects.equals(mission, that.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}
