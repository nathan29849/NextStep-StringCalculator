package string_calculator;

public class StringCalculator {

	public int add(String str) {
		String splitedStr;

		if (str.startsWith("//")) {
			String splitedStrByCustom = getSplit(str, "\n");
			splitedStr = getSplit(splitedStrByCustom.substring(3), splitedStrByCustom.substring(2, 3));
		} else {
			String splitedStrByComma = getSplit(str, ",");
			splitedStr = getSplit(splitedStrByComma, ";");
		}

		char[] charArr = splitedStr.toCharArray();
		int sum = 0;
		for (char number : charArr) {
			sum += Integer.parseInt(String.valueOf(number));
		}
		return sum;
	}

	private String getSplit(String str, String criteria) {
		return String.join("", str.split(criteria));
	}
}
