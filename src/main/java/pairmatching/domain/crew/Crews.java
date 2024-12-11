package pairmatching.domain.crew;

import java.util.List;
import pairmatching.domain.curriculum.Course;

public class Crews {

    private final List<Crew> crews;

    public Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public List<String> findCrewNamesByCourse(Course course) {
        return crews.stream()
                .filter(crew -> crew.isSameCourse(course))
                .map(Crew::getName)
                .toList();
    }
}
