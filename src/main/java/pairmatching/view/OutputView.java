package pairmatching.view;

public class OutputView {

    public void printSelectFunction() {
        System.out.println("기능을 선택하세요.");
        System.out.println("""
                1. 페어 매칭
                2. 페어 조회
                3. 페어 초기화
                Q. 종료""");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
