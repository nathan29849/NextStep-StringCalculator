package calculator;

public class StringCalculator {

	public int add(String str) {
		String firstSplitStr;
		String finalSplitStr;

		if (str == null || str.isEmpty()) {
			return 0;
		}

		if (str.startsWith("//")) {
			firstSplitStr = getSplit(str, "\n");
			finalSplitStr = getSplit(firstSplitStr.substring(3), firstSplitStr.substring(2, 3));
			return getSum(finalSplitStr);
		}

		firstSplitStr = getSplit(str, ",");
		finalSplitStr = getSplit(firstSplitStr, ";");
		return getSum(finalSplitStr);
	}

	private int getSum(String splitedStr) {
		int sum = 0;
		char[] charArr = splitedStr.toCharArray();
		for (char number : charArr) {
			sum += Integer.parseInt(String.valueOf(number));
		}
		return sum;
	}

	private String getSplit(String str, String criteria) {
		return String.join("", str.split(criteria));
	}
}
