package pairmatching.domain;

import static pairmatching.global.constant.ErrorMessage.NOT_MATCHING_PAIR;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.curriculum.Level;

public class PairMatchings {

    private final List<PairMatching> pairMatchings;

    public PairMatchings() {
        this.pairMatchings = new ArrayList<>();
    }

    public void addPairMatching(PairMatching pairMatching) {
        pairMatchings.add(pairMatching);
    }

    public boolean isDuplicatePairMatching(Curriculum curriculum) {
        int count = (int) pairMatchings.stream()
                .filter(pairMatching -> pairMatching.isSameCurriculum(curriculum))
                .count();
        return count != 0;
    }

    public PairMatching findPairMatchingByCurriculum(Curriculum curriculum) {
        return pairMatchings.stream()
                .filter(pairMatching -> pairMatching.isSameCurriculum(curriculum))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_MATCHING_PAIR.get()));
    }

    public boolean isDuplicatePairsIfLevel(List<Pair> pairs, Level level) {
        int count = (int) pairMatchings.stream()
                .filter(pairMatching -> pairMatching.isSameLevel(level))
                .filter(pairMatching -> pairMatching.containsPair(pairs))
                .count();
        return count != 0;
    }

    public void clean() {
        pairMatchings.clear();
    }
}
