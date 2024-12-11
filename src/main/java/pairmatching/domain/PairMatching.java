package pairmatching.domain;

import java.util.List;
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
}
