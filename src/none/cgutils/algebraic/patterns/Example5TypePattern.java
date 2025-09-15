package none.cgutils.algebraic.patterns;

public class Example5TypePattern {

	public static void main(String[] args) {
		oldTypePattern();
		newTypePattern();
	}

	public static void oldTypePattern() {
		Object obj = "Hello";

		if (obj instanceof String) {
			String s = obj.toString();
			System.out.println("It's a String: " + s.toUpperCase());
		} else if (obj instanceof Integer) {
			Integer i = (Integer) obj;
			System.out.println("It's an Integer: " + i * 2);
		} else if (obj == null) {
			System.out.println("It's null");
		} else {
			System.out.println("Unknown type");
		}
	}

	public static void newTypePattern() {
		Object obj = "Hello";

		switch (obj) {
			case String s -> System.out.println("It's a String: " + s.toUpperCase());
			case Integer i -> System.out.println("It's an Integer: " + i * 2);
			case null -> System.out.println("It's null");
			default -> System.out.println("Unknown type");
		}
	}
}
