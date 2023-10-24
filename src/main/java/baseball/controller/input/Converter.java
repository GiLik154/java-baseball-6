package baseball.controller.input;

import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {
    private Converter() {
    }

    private static class ConverterHelper {
        private static final Converter INSTANCE = new Converter();
    }

    public static Converter getInstance() {
        return ConverterHelper.INSTANCE;
    }

    public Balls convert(String userInput) {
        String[] splitNumbers = userInput.split("");

        List<Ball> ballList = convertToBallList(splitNumbers);
        return new Balls(ballList);
    }

    private List<Ball> convertToBallList(String[] splitNumbers) {
        List<Ball> ballList = new ArrayList<>();

        Arrays.stream(splitNumbers)
                .map(this::parseToBall)
                .forEach(ballList::add);

        return ballList;
    }

    private Ball parseToBall(String numberString) {
        try {
            int number = Integer.parseInt(numberString);
            return new Ball(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
}