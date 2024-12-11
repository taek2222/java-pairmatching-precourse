package pairmatching.domain;

import java.util.List;
import java.util.Objects;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair that = (Pair) obj;

        return Objects.equals(this.pair, that.pair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pair);
    }
}
