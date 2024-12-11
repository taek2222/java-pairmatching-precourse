package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String YES = "네";
    private static final String NO = "아니오";

    public boolean readRetryMatching() {
        System.out.print("""
                매칭 정보가 있습니다. 다시 매칭하시겠습니까?
                네 | 아니오
                """);
        String input = Console.readLine();
        validateYesOrNo(input);

        return input.equals(YES);
    }

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

    private void validateYesOrNo(String input) {
        if (!input.equals(YES) && !input.equals(NO)) {
            throw new IllegalArgumentException();
        }
    }
}
