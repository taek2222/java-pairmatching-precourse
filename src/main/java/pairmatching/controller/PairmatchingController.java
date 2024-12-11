package pairmatching.controller;

import static pairmatching.global.util.CurriculumParser.parseCurriculum;

import pairmatching.domain.Curriculum;
import pairmatching.domain.dto.CurriculumResponse;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairmatchingController {
    private final InputView inputView;
    private final OutputView outputView;

    public PairmatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printSelectFunction();
        String function = inputView.readSelectFunction();
        processSelectFunction(function);

        String input = inputView.readCurriculum();
        Curriculum curriculum = parseCurriculum(input);
    }

    private void processSelectFunction(String function) {
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
