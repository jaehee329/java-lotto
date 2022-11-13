package lotto;

import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isLengthSix(numbers);
        isNumbersDuplicated(numbers);
        isNumbersInValidRange(numbers);
    }

    private void isLengthSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 6개여야 합니다.");
        }
    }

    private void isNumbersDuplicated(List<Integer> numbers) {
        int distinctNumbers = (int)numbers.stream()
                                        .mapToInt(Integer::intValue)
                                        .distinct()
                                        .count();
        if (numbers.size() != distinctNumbers) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있지 않아야 합니다.");
        }
    }

    private void isNumbersInValidRange(List<Integer> numbers) {
        boolean anyNumUnderOne = numbers.stream().anyMatch(i -> i < 1);
        boolean anyNumOverFortyFive = numbers.stream().anyMatch(i -> i > 45);
        if (anyNumUnderOne || anyNumOverFortyFive) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 1이상 45이하여야 합니다.");
        }
    }
}
