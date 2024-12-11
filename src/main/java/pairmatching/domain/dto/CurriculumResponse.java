package pairmatching.domain.dto;

import java.util.List;
import pairmatching.domain.curriculum.Course;
import pairmatching.domain.curriculum.Level;
import pairmatching.domain.dto.curriculum.CourseResponse;
import pairmatching.domain.dto.curriculum.LevelResponse;

public record CurriculumResponse(
        CourseResponse courseResponse,
        List<LevelResponse> levelResponses
) {
    public static CurriculumResponse createResponse() {
        CourseResponse courseResponse = Course.createResponse();
        List<LevelResponse> responses = Level.createResponse();
        return new CurriculumResponse(courseResponse, responses);
    }
}
