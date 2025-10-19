package calculator;

import camp.nextstep.edu.missionutils.Console;

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

        String delimiterRegex = "[,:]";
        String numbersInput = input;

        if (numbersInput.startsWith("//")) {
            int index = numbersInput.indexOf('\n');
            if (index == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }

            String customDelimiter = numbersInput.substring(2, index);
            delimiterRegex = "[,:]|" + customDelimiter;
            numbersInput = numbersInput.substring(index + 1);
        }

        String[] numbers = numbersInput.split(delimiterRegex);

        int sum = 0;
        for (String num : numbers) {
            String trimmedNum = num.trim();

            if (trimmedNum.isEmpty()) {
                throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
            }

            int value = Integer.parseInt(trimmedNum);
            if (value < 0) {
                throw new IllegalArgumentException("입력은 양수만 가능합니다.");
            }

            sum += value;
        }

        return sum;
    }
}