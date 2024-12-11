package pairmatching.controller;

import static pairmatching.domain.curriculum.Course.BACKEND;
import static pairmatching.domain.curriculum.Course.FRONTEND;
import static pairmatching.global.util.CurriculumParser.parseCurriculum;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.PairMatching;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.Crews;
import pairmatching.domain.Curriculum;
import pairmatching.domain.curriculum.Course;
import pairmatching.domain.dto.CurriculumResponse;
import pairmatching.domain.dto.PairsResponse;
import pairmatching.global.util.FileUtil;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairmatchingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MatchingService matchingService;

    public PairmatchingController(InputView inputView, OutputView outputView, MatchingService matchingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.matchingService = matchingService;
    }

    public void run() {
        Crews crews = initializeCrews();

        processSelectFunction();

        String input = inputView.readCurriculum();

        Curriculum curriculum = parseCurriculum(input);
        PairMatching matching = matchingService.processMatching(crews, curriculum);

        PairsResponse response = matching.createResponse();
        outputView.printPairsMatchingResult(response);
    }

    private Crews initializeCrews() {
        List<Crew> mergeCrews = new ArrayList<>();

        mergeCrews.addAll(initializeCrew("frontend-crew.md", FRONTEND));
        mergeCrews.addAll(initializeCrew("backend-crew.md", BACKEND));

        return new Crews(mergeCrews);
    }

    private List<Crew> initializeCrew(String fileName, Course course) {
        List<String> names = FileUtil.readFile(fileName);
        return names.stream()
                .map(name -> new Crew(course, name))
                .toList();
    }

    private void processSelectFunction() {
        outputView.printSelectFunction();
        String function = inputView.readSelectFunction();

        if (function.equals("1")) {
            displayCurriculum();
            return;
        }

        if (function.equals("2")) {
            displayCurriculum();
            return;
        }

        if (function.equals("3")) {
            // 페어 초기화
            return;
        }

        if (function.equals("Q")) {
            // 종료
            return;
        }

        throw new IllegalArgumentException();
    }

    private void displayCurriculum() {
        CurriculumResponse response = CurriculumResponse.createResponse();
        outputView.printCurriculum(response);
    }
}
