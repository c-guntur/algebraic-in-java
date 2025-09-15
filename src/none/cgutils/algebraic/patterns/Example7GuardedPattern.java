package none.cgutils.algebraic.patterns;

public class Example7GuardedPattern {

	public static void main(String[] args) {
		oldGuardedPattern();
		newGuardedPattern();
	}

	public static void oldGuardedPattern() {
		Object o = 10;
		if (!(o instanceof Integer) || (o == null)) {
			System.out.println("Not an integer");
		} else {
			Integer i = (Integer) o;
			if (i > 5) {
				System.out.println("Integer greater than 5: " + i);
			} else {
				System.out.println("Integer: " + i);
			}
		}
	}

	public static void newGuardedPattern() {
		Object o = 10;
		switch (o) {
			case int i when i > 5 -> System.out.println("Integer greater than 5: " + i);
			case int i -> System.out.println("Integer: " + i);
			default -> System.out.println("Not an integer");
		}
	}
}
