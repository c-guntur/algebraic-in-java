package none.cgutils.algebraic.sum;

import java.util.EnumMap;
import java.util.EnumSet;

//----------------------------------------------------------------------------------------------
//Adding behavior to an enum
enum YearPartEnum {

    // If the enum contains fields and/or methods,
    // the list of enum constants must be terminated by a semicolon ';'
    Q1("Quarter 1"),
    Q2("Quarter 2"),
    Q3("Quarter 3"),
    Q4("Quarter 4");

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

        // CREATE AN ENUM
        YearPartEnum yearPartEnum = YearPartEnum.Q1;
        System.out.println("1. Printing the toString, prints the name ---> \n\t\t" +
                "yearPartEnum = " + yearPartEnum + "\n");


        // CONDITIONAL CHECK ON ENUM
        if (YearPartEnum.Q1 == yearPartEnum) {
            System.out.println("2. Equating using an '==' operator --->\n\t\t" +
                    "This is the second quarter !!\n");
        }


        // CONDITIONAL SWITCH-CASE ON ENUM
        System.out.print("3. Conditional switch-case uses enum directly ---> \n\t\t");
        switch (yearPartEnum) {
            case Q1 -> System.out.print(yearPartEnum.getDescription() + "= Jan, Feb, Mar");
            case Q2 -> System.out.print(yearPartEnum.getDescription() + "= Apr, May, Jun");
            case Q3 -> System.out.print(yearPartEnum.getDescription() + "= Jul, Aug, Sep");
            case Q4 -> System.out.print(yearPartEnum.getDescription() + "= Oct, Nov, Dec");
        }
        System.out.println("\n");


        // ITERATING OVER ALL ENUM VALUES
        System.out.print("4. Iterating over an enum for all its values ---> \n\t\t");
        for (YearPartEnum yearPartEnum1 : YearPartEnum.values()) {
            System.out.print(yearPartEnum1 + "\t");
        }
        System.out.println("\n");


        // DERIVE ENUMS FROM STRINGS
        yearPartEnum = YearPartEnum.valueOf("Q2");
        System.out.println("5. Enums can be derived from Strings using a valueOf() " +
                "on the actual enum  ---> \n\t\tyearPartEnum = " + yearPartEnum + "\n");

        yearPartEnum = Enum.valueOf(YearPartEnum.class, "Q3");
        System.out.println("6. Enums can be derived from Strings using a valueOf() " +
                "on the Enum.class  ---> \n\t\tyearPartEnum = " + yearPartEnum);


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


        // ENUMSET
        EnumSet<EnumWithInterface> fourAndFive =
                EnumSet.of(EnumWithInterface.FOUR, EnumWithInterface.FIVE);
        System.out.print("\n15. EnumSet values --->\n\t\t[");
        fourAndFive.forEach(obj -> System.out.print("\n\t\t\t" + obj));
        System.out.print("\n\t\t]\n");


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
                (Enum.class.isAssignableFrom(abstractMethods.getClass())));
    }
}