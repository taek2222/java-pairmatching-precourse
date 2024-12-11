package pairmatching.domain.dto;

import java.util.List;

public record PairsResponse(
        List<PairResponse> pairResponses
) {
}
