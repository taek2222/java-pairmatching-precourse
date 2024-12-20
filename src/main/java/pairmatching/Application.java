package pairmatching;

import pairmatching.controller.PairmatchingController;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        PairmatchingController pairmatchingController = new PairmatchingController(
                new InputView(),
                new OutputView(),
                new MatchingService()
        );

        pairmatchingController.run();
    }
}
