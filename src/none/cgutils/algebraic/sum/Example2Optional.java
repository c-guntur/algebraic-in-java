package none.cgutils.algebraic.sum;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

// Value or Empty
public class Example2Optional {

    public static void main(String[] args) {

        // NOTE: java.util.Optional was introduced in Java 8.

        // NOTE: Optional is a container which may, or may not contain a non-null value.

        // CREATE AN EMPTY OPTIONAL
        Optional<String> optionalEmptyString = Optional.empty();

        // NOTE: Check if the Optional is empty.
        // CHECK IF THE OPTIONAL IS EMPTY
        if (optionalEmptyString.isEmpty()) {
            System.out.println("\n1. Empty optional --->\n\tThis is an empty optional!");
        }

        // NOTE: Create an Optional for a non-null value.
        // CREATE AN OPTIONAL WITH VALUE
        Optional<Integer> integerOptional = Optional.of(7);

        // NOTE: Get the value of the Optional: Use get() with caution!
        // GET THE VALUE
        // Generally a bad idea to use get(), defeats the purpose of the Optional container.
        System.out.println("\n2. Value of optional exists --->\n\tValue: " +
                integerOptional.get());

        // NOTE: Create an Optional for a possible null value.
        // CREATE AN OPTIONAL WITH VALUE BUT NULLABLE
        Integer nullInteger = null;
        Optional<Integer> integerNullableOptional = Optional.ofNullable(nullInteger);
        Integer eleven = 11;
        integerNullableOptional = Optional.ofNullable(eleven);

        // NOTE: Check if the Optional has a non-null value.
        // CHECK IF A VALUE EXISTS
        if (integerNullableOptional.isPresent()) {
            System.out.println("\n3. Value of nullable optional exists --->\n\tValue: " +
                    integerNullableOptional.get());
        }
        // AS A LAMBDA
        integerNullableOptional.ifPresent(integer -> System.out.println(
                "\n3a. Value of nullable optional exists --->\n\tValue: " +
                integer));

        // NOTE: How null values can be handled when extracted from the Optional.
        // HANDLING NULLS
        // ALTERNATE VALUE WHEN VALUE IS EMPTY (NULL) USING A SUPPLIER
        integerNullableOptional = Optional.ofNullable(nullInteger);
        System.out.println(
                "\n4. Alternate value of nullable optional using or() then get() --->\n\tValue: " +
                        integerNullableOptional.or(() -> Optional.of(-1)).get());

        // ALTERNATE VALUE WHEN VALUE IS EMPTY (NULL) USING A SUPPLIER
        System.out.println(
                "\n5. Alternate value of nullable optional using orElseGet() --->\n\tValue: " +
                        integerNullableOptional.orElseGet(() -> -1));

        // ALTERNATE VALUE WHEN VALUE IS EMPTY (NULL) USING AN ALTERNATE VALUE
        System.out.println(
                "\n6. Alternate value of nullable optional using orElse() --->\n\tValue: " +
                        integerNullableOptional.orElse(-1));

        // NOTE: Throwing exceptions if the Optional is empty.
        // THROW EXCEPTION WHEN VALUE IS EMPTY (NULL) USING AN EXCEPTION SUPPLIER
        try {
            Supplier<RuntimeException> exceptionSupplier =
                    () -> new RuntimeException("The value is empty");
            Integer nonNullInteger = integerNullableOptional.orElseThrow(exceptionSupplier);
        } catch (RuntimeException e) {
            System.out.println(
                    "\n7. Exception thrown when using an orElseThrow() on an empty optional --->\n\t" +
                            "This should print!");
        }

        // NOTE: Handling either non-null value or empty in an Optional.
        // PERFORM CONSUMER ACTION BASED ON VALUE BEING NON-NULL OR A RUNNABLE IF NULL
        Consumer<Integer> nonEmptyValueAction =
                x -> System.out.println(
                        "\n8. Consumer action for non-null value optional --->\n\t " +
                                "This is a non-null integer value: " + x);

        Runnable emptyValueRunnable =
                () -> System.out.println(
                        "\n9. Runnable action for null value optional --->\n\t " +
                                "This is a null integer value");

        integerOptional.ifPresentOrElse(nonEmptyValueAction, emptyValueRunnable);

        integerNullableOptional.ifPresentOrElse(nonEmptyValueAction, emptyValueRunnable);

        // NOTE: Pattern matching to determine if the instance is indeed an Optional.
        // INSTANCEOF PATTERN MATCHING
        if (optionalEmptyString instanceof Optional) {
            System.out.println("\n10. Pattern matching instanceof --->\n\tThis is an optional!");
        }
        if(Optional.class.isAssignableFrom(optionalEmptyString.getClass())) {
            System.out.println("\n10a. Pattern matching Class.isAssignableFrom --->\n\tThis is an optional!");
        }

    }
}