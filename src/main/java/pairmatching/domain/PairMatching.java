package pairmatching.domain;

import java.util.List;
import pairmatching.domain.curriculum.Level;
import pairmatching.domain.dto.PairResponse;
import pairmatching.domain.dto.PairsResponse;

public class PairMatching {

    private final Curriculum curriculum;
    private final List<Pair> pairs;

    public PairMatching(Curriculum curriculum, List<Pair> pairs) {
        this.curriculum = curriculum;
        this.pairs = pairs;
    }

    public PairsResponse createResponse() {
        List<PairResponse> responses = pairs.stream()
                .map(Pair::createResponse)
                .toList();

        return new PairsResponse(responses);
    }

    public boolean isSameCurriculum(Curriculum curriculum) {
        return this.curriculum.equals(curriculum);
    }

    public boolean isSameLevel(Level level) {
        return curriculum.isSameLevel(level);
    }

    public boolean containsPair(List<Pair> otherPairs) {
        for (Pair otherPair : otherPairs) {
            if (pairs.contains(otherPair))
                return true;
        }
        return false;
    }
}
