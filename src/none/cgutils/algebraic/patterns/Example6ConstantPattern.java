package none.cgutils.algebraic.patterns;

public class Example6ConstantPattern {

	public static void main(String[] args) {
		oldConstantPattern();
		newConstantPattern();
	}

	public static void oldConstantPattern() {
		int day = 3;
		String dayName = "Other day";

		switch (day) {
			case 1:
				dayName = "Monday";
				break;
			case 2:
				dayName = "Tuesday";
				break;
			case 3:
				dayName = "Wednesday";
				break;
			default:
				dayName = "Other Day";
		}
		;
		System.out.println(dayName);

	}

	public static void newConstantPattern() {
		int day = 3;
		String dayName = switch (day) {
			case 1 -> "Monday";
			case 2 -> "Tuesday";
			case 3 -> "Wednesday";
			default -> "Other Day";
		};
		System.out.println(dayName);
	}
}
