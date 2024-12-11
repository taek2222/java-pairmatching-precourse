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
        inputView.readSelectFunction();
    }
}
