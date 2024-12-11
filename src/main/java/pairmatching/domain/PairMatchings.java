package pairmatching.domain;

import static pairmatching.global.constant.ErrorMessage.NOT_MATCHING_PAIR;

import java.util.ArrayList;
import java.util.List;

public class PairMatchings {

    private final List<PairMatching> pairMatchings;

    public PairMatchings() {
        this.pairMatchings = new ArrayList<>();
    }

    public void addPairMatching(PairMatching pairMatching) {
        pairMatchings.add(pairMatching);
    }

    public PairMatching findPairMatchingByCurriculum(Curriculum curriculum) {
        return pairMatchings.stream()
                .filter(pairMatching -> pairMatching.isSameCurriculum(curriculum))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_MATCHING_PAIR.get()));
    }

    public void clean() {
        pairMatchings.clear();
    }
}
