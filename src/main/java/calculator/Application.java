package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = sum(input);
        System.out.println("결과 : " + result);
    }

    public static int sum(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력은 필수입니다.");
        }

        String[] numbers = input.split("[,:]");

        int sum = 0;
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}