package none.cgutils.algebraic.sum;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

// Value or Empty
public class Example2Optional {

    public static void main(String[] args) {

        // CREATE AN EMPTY OPTIONAL
        Optional<String> optionalEmptyString = Optional.empty();

        // INSTANCEOF PATTERN MATCHING
        if (optionalEmptyString instanceof Optional) {
            System.out.println("\n1. Pattern matching --->\n\tThis is an optional!");
        }

        // CHECK IF THE OPTIONAL IS EMPTY
        if (optionalEmptyString.isEmpty()) {
            System.out.println("\n2. Empty optional --->\n\tThis is an empty optional!");
        }

        // CREATE AN OPTIONAL WITH VALUE
        Optional<Integer> integerOptional = Optional.of(7);

        // GET THE VALUE
        // Generally a bad idea to use get(), defeats the purpose of the Optional container.
        System.out.println("\n3. Value of optional exists --->\n\tValue: " +
                integerOptional.get());


        // CREATE AN OPTIONAL WITH VALUE BUT NULLABLE
        Optional<Integer> integerNullableOptional = Optional.ofNullable(11);

        // CHECK IF A VALUE EXISTS
        if (integerNullableOptional.isPresent()) {
            System.out.println("\n4. Value of nullable optional exists --->\n\tValue: " +
                    integerNullableOptional.get());
        }
        // AS A LAMBDA
        integerNullableOptional.ifPresent(integer -> System.out.println(
                "\n4a. Value of nullable optional exists --->\n\tValue: " +
                integer));


        // HANDLING NULLS
        Integer nullInteger = null;

        // ALTERNATE VALUE WHEN VALUE IS EMPTY (NULL) USING A SUPPLIER
        integerNullableOptional = Optional.ofNullable(nullInteger);
        System.out.println(
                "\n5. Alternate value of nullable optional using or() then get() --->\n\tValue: " +
                        integerNullableOptional.or(() -> Optional.of(-1)).get());

        // ALTERNATE VALUE WHEN VALUE IS EMPTY (NULL) USING A SUPPLIER
        System.out.println(
                "\n6. Alternate value of nullable optional using orElseGet() --->\n\tValue: " +
                        integerNullableOptional.orElseGet(() -> -1));

        // ALTERNATE VALUE WHEN VALUE IS EMPTY (NULL) USING AN ALTERNATE VALUE
        System.out.println(
                "\n7. Alternate value of nullable optional using orElse() --->\n\tValue: " +
                        integerNullableOptional.orElse(-1));


        // THROW EXCEPTION WHEN VALUE IS EMPTY (NULL) USING AN EXCEPTION SUPPLIER
        try {
            Supplier<RuntimeException> exceptionSupplier =
                    () -> new RuntimeException("The value is empty");
            Integer nonNullInteger = integerNullableOptional.orElseThrow(exceptionSupplier);
        } catch (RuntimeException e) {
            System.out.println(
                    "\n8. Exception thrown when using an orElseThrow() on an empty optional --->\n\t" +
                            "This should print!");
        }


        // PERFORM CONSUMER ACTION BASED ON VALUE BEING NON-NULL OR A RUNNABLE IF NULL
        Consumer<Integer> nonEmptyValueAction =
                x -> System.out.println(
                        "\n9. Consumer action for non-null value optional --->\n\t " +
                                "This is a non-null integer value: " + x);

        Runnable emptyValueRunnable =
                () -> System.out.println(
                        "\n10. Runnable action for null value optional --->\n\t " +
                                "This is a null integer value");

        integerOptional.ifPresentOrElse(nonEmptyValueAction, emptyValueRunnable);

        integerNullableOptional.ifPresentOrElse(nonEmptyValueAction, emptyValueRunnable);
    }
}