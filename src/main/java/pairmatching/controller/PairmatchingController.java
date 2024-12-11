package pairmatching.controller;

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


    }

    private void processSelectFunction(String function) {
        if (function.equals("1")) {
            // 페어 매칭
            return;
        }

        if (function.equals("2")) {
            // 페어 조회
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
}
