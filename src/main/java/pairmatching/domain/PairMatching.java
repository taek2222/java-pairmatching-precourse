package pairmatching.domain;

import java.util.List;

public class PairMatching {

    private final Curriculum curriculum;
    private final List<Pair> pairs;

    public PairMatching(Curriculum curriculum, List<Pair> pairs) {
        this.curriculum = curriculum;
        this.pairs = pairs;
    }
}
