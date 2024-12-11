package pairmatching.controller;

import static pairmatching.domain.curriculum.Course.BACKEND;
import static pairmatching.domain.curriculum.Course.FRONTEND;
import static pairmatching.global.util.CurriculumParser.parseCurriculum;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.PairMatching;
import pairmatching.domain.PairMatchings;
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

        PairMatchings pairMatchings = new PairMatchings();
        while (true) {
            String function = readSelectFunction();

            if (function.equals("Q")) {
                return;
            }

            if (function.equals("3")) {
                pairMatchings.clean();
                continue;
            }

            processSelectFunction(function, crews, pairMatchings);
        }
    }

    private String readSelectFunction() {
        outputView.printSelectFunction();
        return inputView.readSelectFunction();
    }

    private Curriculum readAndParseCurriculum() {
        String input = inputView.readCurriculum();
        return parseCurriculum(input);
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

    private void processSelectFunction(String function, Crews crews, PairMatchings pairMatchings) {
        displayCurriculum();
        if (function.equals("1")) {
            Curriculum curriculum = readAndParseCurriculum();
            if (pairMatchings.isDuplicatePairMatching(curriculum)) {
                if (!inputView.readRetryMatching()) {
                    return;
                }
            }

            PairMatching matching = matchingService.processMatching(crews, curriculum, pairMatchings);
            pairMatchings.addPairMatching(matching);
            displayPairMatchingResult(matching);

            return;
        }

        if (function.equals("2")) {
            Curriculum curriculum = readAndParseCurriculum();

            PairMatching matching = pairMatchings.findPairMatchingByCurriculum(curriculum);
            displayPairMatchingResult(matching);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void displayPairMatchingResult(PairMatching matching) {
        PairsResponse response = matching.createResponse();
        outputView.printPairsMatchingResult(response);
    }

    private void displayCurriculum() {
        CurriculumResponse response = CurriculumResponse.createResponse();
        outputView.printCurriculum(response);
    }
}
