package calculator;

public class StringCalculator {

	public int add(String str) {
		String[] splitStr;
		String[] customSplitStr;

		if (isBlank(str)) return 0;

		if (str.startsWith("//")) {
			splitStr = getSplitString(str, "\n");
			String customSeperator = splitStr[0].substring(2, 3);
			customSplitStr = getSplitString(splitStr[1], customSeperator);
			return getSum(toIntArray(customSplitStr));
		}
		splitStr = getSplitString(str, ",|;");
		return getSum(toIntArray(splitStr));
	}

	private boolean isBlank(String str) {
		return str == null || str.isEmpty();
	}

	private int[] toIntArray(String[] strNumbers) {
		int[] numbers = new int[strNumbers.length];
		for (int i = 0; i < strNumbers.length; i++) {
			numbers[i] = Integer.parseInt(strNumbers[i]);
		}
		return numbers;
	}

	private int getSum(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			checkForNegative(number);
			sum += number;
		}
		return sum;
	}

	private String[] getSplitString(String str, String criteria) {
		return str.split(criteria);
	}

	private void checkForNegative(int number) {
		if (number < 0) {
			throw new RuntimeException("음수는 계산할 수 없습니다.");
		}

	}
}
