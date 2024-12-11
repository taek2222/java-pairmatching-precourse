package pairmatching.global.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pairmatching.domain.Curriculum;
import pairmatching.domain.curriculum.Course;
import pairmatching.domain.curriculum.Level;
import pairmatching.domain.curriculum.Mission;

public class CurriculumParser {

    private static final String PATTERN_REGEX = "^([가-힣]*), ([0-9가-힣]*), ([가-힣]*)";
    private static final Pattern PATTERN = Pattern.compile(PATTERN_REGEX);
    private static final int EXPECTED_MATCHER_COUNT = 3;

    public static Curriculum parseCurriculum(String input) {
        Matcher matcher = PATTERN.matcher(input);
        validateMatch(matcher);

        Course course = Course.findCourseByName(matcher.group(1));
        Level level = Level.findLevelByName(matcher.group(2));
        Mission mission = Mission.findMissionByName(matcher.group(3));

        return new Curriculum(course, level, mission);
    }

    private static void validateMatch(Matcher matcher) {
        if (!matcher.find() || matcher.groupCount() != EXPECTED_MATCHER_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
