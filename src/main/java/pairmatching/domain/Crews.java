package pairmatching.domain;

import java.util.List;
import pairmatching.domain.curriculum.Course;

public class Crews {

    private final List<Crew> frontend;
    private final List<Crew> backend;

    public Crews(List<Crew> frontend, List<Crew> backend) {
        this.frontend = frontend;
        this.backend = backend;
    }

    public List<String> findCrewNamesByCourse(Course course) {
        return backend.stream()
                .filter(crew -> crew.isSameCourse(course))
                .map(Crew::getName)
                .toList();
    }
}
