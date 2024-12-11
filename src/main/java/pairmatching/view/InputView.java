package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCurriculum() {
        System.out.print("""
            과정, 레벨, 미션을 선택하세요.
            ex) 백엔드, 레벨1, 자동차경주
            """);

        return Console.readLine();
    }

    public String readSelectFunction() {
        return Console.readLine();
    }
}
