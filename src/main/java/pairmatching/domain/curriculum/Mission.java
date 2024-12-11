package pairmatching.domain.curriculum;

import static pairmatching.domain.curriculum.Level.LEVEL1;
import static pairmatching.domain.curriculum.Level.LEVEL2;
import static pairmatching.domain.curriculum.Level.LEVEL4;

import java.util.Arrays;
import java.util.List;
import pairmatching.domain.dto.curriculum.MissionResponse;

public enum Mission {
    CAR_RACING(LEVEL1, "자동차경주"),
    LOTTO(LEVEL1, "로또"),
    BASEBALL_GAME(LEVEL1, "숫자야구게임"),

    SHOPPING_CART(LEVEL2, "장바구니"),
    PAYMENT(LEVEL2, "결제"),
    SUBWAY_ROUTE_MAP(LEVEL2, "지하철노선도"),

    PERFORMANCE_IMPROVEMENT(LEVEL4, "성능개선"),
    DISTRIBUTION(LEVEL4, "배포")
    ;

    private final Level level;
    private final String name;

    Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public static Mission findMissionByName(String name) {
        return Arrays.stream(values())
                .filter(mission -> mission.name.equals(name))
                .findFirst()
                .orElseThrow();
    }

    public static MissionResponse createResponse(Level level) {
        List<String> names = Arrays.stream(values())
                .filter(mission -> mission.level == level)
                .map(mission -> mission.name)
                .toList();

        return new MissionResponse(names);
    }
}
