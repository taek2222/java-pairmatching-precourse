package pairmatching.domain;

import java.util.List;
import pairmatching.domain.dto.PairResponse;

public class Pair {

    private final List<String> pair;

    public Pair(List<String> pair) {
        this.pair = pair;
    }

    public PairResponse createResponse() {
        return new PairResponse(
                pair
        );
    }
}
