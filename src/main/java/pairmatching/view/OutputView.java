package pairmatching.view;

import static pairmatching.global.constant.MessageConstant.NEW_LINE;

import java.util.List;
import pairmatching.domain.dto.CurriculumResponse;
import pairmatching.domain.dto.curriculum.CourseResponse;
import pairmatching.domain.dto.curriculum.LevelResponse;
import pairmatching.domain.dto.curriculum.MissionResponse;

public class OutputView {

    public void printCurriculum(CurriculumResponse response) {
        System.out.printf(NEW_LINE.get());
        System.out.println("#############################################");
        printCurriculumCourse(response.courseResponse());
        System.out.println("미션:");

        List<LevelResponse> levelResponses = response.levelResponses();
        levelResponses.forEach(this::printCurriculumLevel);
        System.out.println("#############################################");
    }

    public void printSelectFunction() {
        System.out.println("기능을 선택하세요.");
        System.out.println("""
                1. 페어 매칭
                2. 페어 조회
                3. 페어 초기화
                Q. 종료""");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    private void printCurriculumCourse(CourseResponse response) {
        List<String> names = response.names();
        System.out.printf("과정: %s" + NEW_LINE.get(), String.join(" | ", names));
    }

    private void printCurriculumLevel(LevelResponse response) {
        System.out.printf("    - %s: ", response.name());
        printCurriculumMission(response.missionResponse());
    }

    private void printCurriculumMission(MissionResponse response) {
        List<String> names = response.names();
        System.out.printf("%s" + NEW_LINE.get(), String.join(" | ", names));
    }
}
