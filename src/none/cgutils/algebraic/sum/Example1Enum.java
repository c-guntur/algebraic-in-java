package none.cgutils.algebraic.sum;

import java.util.EnumMap;
import java.util.EnumSet;

public class Example1Enum {
    public static void main(String[] args) {

        // CREATE AN ENUM
        YearPartEnum yearPartEnum = YearPartEnum.Q1;
        System.out.println("1. Printing the toString, prints the name ---> \n\tyearPartEnum = " + yearPartEnum + "\n");

        // CONDITIONAL CHECK ON ENUM
        if (YearPartEnum.Q1 == yearPartEnum) {
            System.out.println("2. Equating using an '==' operator --->\n\t This is the second quarter !!\n");
        }

        // CONDITIONAL SWITCH-CASE ON ENUM
        System.out.print("3. Conditional switch-case uses enum directly ---> \n\t");
        switch (yearPartEnum) {
            case Q1 -> System.out.print(yearPartEnum.getDescription() + "= Jan, Feb, Mar");
            case Q2 -> System.out.print(yearPartEnum.getDescription() + "= Apr, May, Jun");
            case Q3 -> System.out.print(yearPartEnum.getDescription() + "= Jul, Aug, Sep");
            case Q4 -> System.out.print(yearPartEnum.getDescription() + "= Oct, Nov, Dec");
        }
        System.out.println("\n");

        // ITERATING OVER ALL ENUM VALUES
        System.out.print("4. Iterating over an enum for all its values ---> \n\t");
        for (YearPartEnum yearPartEnum1 : YearPartEnum.values()) {
            System.out.print(yearPartEnum1 + "\t");
        }
        System.out.println("\n");

        // DERIVE ENUMS FROM STRINGS
        System.out.print("5. Enums can be derived from Strings using a valueOf() on the actual enum  ---> \n\t");
        yearPartEnum = YearPartEnum.valueOf("Q2");
        System.out.println("yearPartEnum = " + yearPartEnum + "\n");
        System.out.print("6. Enums can be derived from Strings using a valueOf() on the Enum.class  ---> \n\t");
        yearPartEnum = Enum.valueOf(YearPartEnum.class, "Q3");
        System.out.println("yearPartEnum = " + yearPartEnum + "\n");

        // ABSTRACT METHODS IN ENUMS
        UsingAbstractMethods abstractMethods = UsingAbstractMethods.THREE;
        System.out.println("\n7. abstractMethods enum value  ---> \n\t" + abstractMethods);
        System.out.println("\n8. Call the abstract method  ---> \n\tThis is the " + abstractMethods.descriptiveText() + " value.");
        System.out.println("\n9. Get the name of the enum  ---> \n\tThe name value of this enum is: " + abstractMethods.name());
        System.out.println("\n10. Get the ordinal value  ---> \n\tThe ordinal value of this enum is: " + abstractMethods.ordinal());

        // INTERFACE IMPLEMENTATION IN ENUMS
        // (Extension of class or interface is not allowed).
        EnumWithInterface enumWithInterface = EnumWithInterface.SIX;
        System.out.println("\n\n11. enumWithInterface enum value  ---> \n\t" + enumWithInterface);
        System.out.println("\n12. Call the interface method  ---> \n\tThis is the " + enumWithInterface.getDescription() + " value.");
        System.out.println("\n13. Get the name of the enum  ---> \n\tThe name value of this enum is: " + enumWithInterface.name());
        System.out.println("\n14. Get the ordinal value  ---> \n\tThe ordinal value of this enum is: " + enumWithInterface.ordinal());

        // ENUMSET
        EnumSet<EnumWithInterface> fourAndFive = EnumSet.of(EnumWithInterface.FOUR, EnumWithInterface.FIVE);

        // ENUMMAP
        EnumMap<UsingAbstractMethods, String> enumMap = new EnumMap<>(UsingAbstractMethods.class);
        enumMap.put(UsingAbstractMethods.ONE, "I");
        enumMap.put(UsingAbstractMethods.TWO, "II");
        enumMap.put(UsingAbstractMethods.THREE, "III");

    }
}

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