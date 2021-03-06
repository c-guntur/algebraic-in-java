package none.cgutils.algebraic.sum;

import java.util.EnumMap;
import java.util.EnumSet;

//----------------------------------------------------------------------------------------------
//Adding behavior to an enum
enum YearPartEnum {

    // If the enum contains fields and/or methods,
    // the list of enum constants must be terminated by a semicolon ';'
    Q1("Quarter 1"), // This is a value, with name = Q1 and ordinal = 0
    Q2("Quarter 2"), // This is a value, with name = Q2 and ordinal = 1
    Q3("Quarter 3"), // This is a value, with name = Q3 and ordinal = 2
    Q4("Quarter 4"); // This is a value, with name = Q4 and ordinal = 3

    // If the enum contains fields and/or methods,
    // these need to be defined AFTER the list of enum constants
    private final String description;

    YearPartEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
//----------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------
// Abstract methods in enum
enum UsingAbstractMethods {

    // If the enum contains fields and/or methods,
    // the list of enum constants must be terminated by a semicolon ';'
    ONE {
        @Override
        String descriptiveText() {
            return "first";
        }
    },
    TWO {
        @Override
        String descriptiveText() {
            return "second";
        }
    },
    THREE {
        @Override
        String descriptiveText() {
            return "third";
        }
    };

    // If the enum contains fields and/or methods,
    // these need to be defined AFTER the list of enum constants
    abstract String descriptiveText();
}
//----------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------
//interface extension in enum
interface Describable {

    String getDescription();
}

enum EnumWithInterface implements Describable {

    FOUR {
        @Override
        public String getDescription() {
            return "fourth";
        }
    },
    FIVE {
        @Override
        public String getDescription() {
            return "fifth";
        }
    },
    SIX {
        @Override
        public String getDescription() {
            return "sixth";
        }
    }
}
//----------------------------------------------------------------------------------------------

public class Example1Enum {

    public static void main(String[] args) {

        // NOTE: java.lang.Enum was introduced in Java 5.

        // NOTE: Enums are a collection of final Singleton instances with an ordinal associated with
        //  each value.
        // CREATE AN ENUM
        YearPartEnum yearPartEnum = YearPartEnum.Q1;
        System.out.println("1. Printing the toString, prints the name ---> \n\t\t" +
                "yearPartEnum = " + yearPartEnum + "\n");


        // NOTE: Enums can be compared with == operator, in fact Enum class equals() just does that.
        // CONDITIONAL CHECK ON ENUM
        if (YearPartEnum.Q1 == yearPartEnum) {
            System.out.println("2. Equating using an '==' operator --->\n\t\t" +
                    "This is the first quarter !!\n");
        }


        // NOTE: Here is a switch-case example for an enum.
        // CONDITIONAL SWITCH-CASE ON ENUM
        System.out.print("3. Conditional switch-case uses enum directly ---> \n\t\t");
        switch (yearPartEnum) {
            case Q1 -> System.out.print(yearPartEnum.getDescription() + "= Jan, Feb, Mar");
            case Q2 -> System.out.print(yearPartEnum.getDescription() + "= Apr, May, Jun");
            case Q3 -> System.out.print(yearPartEnum.getDescription() + "= Jul, Aug, Sep");
            case Q4 -> System.out.print(yearPartEnum.getDescription() + "= Oct, Nov, Dec");
        }
        System.out.println("\n");


        // NOTE: One can iterate over enum values using the values() method.
        //  This method is added by the compiler.
        // ITERATING OVER ALL ENUM VALUES
        System.out.print("4. Iterating over an enum for all its values ---> \n\t\t");
        for (YearPartEnum yearPartEnum1 : YearPartEnum.values()) {
            System.out.print(yearPartEnum1 + "\t");
        }
        System.out.println("\n");


        // NOTE: Enums can be set using string equivalents via the valueOf() method.
        //  Two formats are possible.
        // DERIVE ENUMS FROM STRINGS
        yearPartEnum = YearPartEnum.valueOf("Q2");
        System.out.println("5. Enums can be derived from Strings using a valueOf() " +
                "on the actual enum  ---> \n\t\tyearPartEnum = " + yearPartEnum + "\n");

        yearPartEnum = Enum.valueOf(YearPartEnum.class, "Q3");
        System.out.println("6. Enums can be derived from Strings using a valueOf() " +
                "on the Enum.class  ---> \n\t\tyearPartEnum = " + yearPartEnum);

        // NOTE: Enums can define abstract methods that are implemented in each enum instance.
        // ABSTRACT METHODS IN ENUMS
        UsingAbstractMethods abstractMethods = UsingAbstractMethods.THREE;
        System.out.println("\n7. abstractMethods enum value  ---> \n\t\t" +
                abstractMethods);
        System.out.println("\n8. Call the abstract method  ---> \n\t\t" +
                "This is the " + abstractMethods.descriptiveText() + " value.");
        System.out.println("\n9. Get the name of the enum  ---> \n\t\t" +
                "The name value of this enum is: " + abstractMethods.name());
        System.out.println("\n10. Get the ordinal value  ---> \n\t\t" +
                "The ordinal value of this enum is: " + abstractMethods.ordinal());

        // NOTE: Enums can also implement interfaces as seen here.
        // INTERFACE IMPLEMENTATION IN ENUMS
        // (Extension of class or interface is not allowed).
        EnumWithInterface enumWithInterface = EnumWithInterface.SIX;
        System.out.println("\n11. enumWithInterface enum value  ---> \n\t\t" +
                enumWithInterface);
        System.out.println("\n12. Call the interface method  ---> \n\t\t" +
                "This is the " + enumWithInterface.getDescription() + " value.");
        System.out.println("\n13. Get the name of the enum  ---> \n\t\t" +
                "The name value of this enum is: " + enumWithInterface.name());
        System.out.println("\n14. Get the ordinal value  ---> \n\t\t" +
                "The ordinal value of this enum is: " + enumWithInterface.ordinal());

        // NOTE: Enums can be subset into an EnumSet.
        // ENUMSET
        EnumSet<EnumWithInterface> fourAndFive =
                EnumSet.of(EnumWithInterface.FOUR, EnumWithInterface.FIVE);
        System.out.print("\n15. EnumSet values --->\n\t\t[");
        fourAndFive.forEach(obj -> System.out.print("\n\t\t\t" + obj));
        System.out.print("\n\t\t]\n");

        // NOTE: Enums can be mapped into EnumMaps as well.
        // ENUMMAP
        EnumMap<UsingAbstractMethods, String> romanNumeralMap =
                new EnumMap<>(UsingAbstractMethods.class);
        romanNumeralMap.put(UsingAbstractMethods.ONE, "I");
        romanNumeralMap.put(UsingAbstractMethods.TWO, "II");
        romanNumeralMap.put(UsingAbstractMethods.THREE, "III");
        System.out.print("\n16. EnumMap values --->\n\t\t[");
        romanNumeralMap.forEach((key, value) ->
                System.out.print("\n\t\t\t" + key + ": " + value));
        System.out.println("\n\t\t]\n");

        // NOTE: Finally, pattern matching on enums can take a few forms, with one gotcha!
        // PATTERN MATCHING
        // The Class.isEnum() does not work if enums have a body !!!
        // Ue instanceof or Class.isAssignableFrom()
        // CHECK IF THE VARIABLE IS AN ENUM
        System.out.println("18. Class.isEnum() is good for vanilla enums --->\n\t\t" +
                "yearPartEnum is an enum? " +
                yearPartEnum.getClass().isEnum() + "\n");
        System.out.println("19. Class.isEnum() fails for enums with body --->\n\t\t" +
                "abstractMethods is an enum? " +
                abstractMethods.getClass().isEnum() + "\n");
        System.out.println("20. Use instanceof for enums with body --->\n\t\t" +
                "abstractMethods is an enum? " +
                (abstractMethods instanceof Enum) + "\n");
        System.out.println("21. Enum.class.isAssignableFrom is another way to test --->\n\t\t" +
                "abstractMethods is an enum? " +
                (Enum.class.isAssignableFrom(abstractMethods.getClass())) + "\n");

        Comparable myYearPartEnum = yearPartEnum;
        // NOTE: Modern shortcut pattern matching
        // Introduced in Java 14 as a preview
        // Second preview in Java 15
        // Intended to the a final feature in Java 16
        if (myYearPartEnum instanceof Enum anEnum) {
            // can use anEnum here
            System.out.println("22. yearPartEnum is indeed an enum --->\n\t\t" +
                    "Pattern matched anEnum is of type: " +
                    anEnum.getClass().getCanonicalName() + "\n");
        } else {
            // can't use anEnum here
            System.out.println("This should not print --->\n\t\t" +
                    "anEnum is not resolvable in this block.\n");
        }
    }
}