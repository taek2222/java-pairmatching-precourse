package pairmatching.domain;

import java.util.List;

public class Crews {

    private final List<Crew> frontend;
    private final List<Crew> backend;

    public Crews(List<Crew> frontend, List<Crew> backend) {
        this.frontend = frontend;
        this.backend = backend;
    }
}
