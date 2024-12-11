package pairmatching.domain.curriculum;

import java.util.Arrays;
import java.util.List;
import pairmatching.domain.dto.curriculum.LevelResponse;
import pairmatching.domain.dto.curriculum.MissionResponse;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public static List<LevelResponse> createResponse() {
        return Arrays.stream(values())
                .map(level -> {
                    MissionResponse response = Mission.createResponse(level);
                    return new LevelResponse(level.name, response);
                })
                .toList();
    }
}