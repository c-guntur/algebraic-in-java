package none.cgutils.algebraic.product;

import java.util.Objects;

/*
JEPs:
    https://openjdk.java.net/jeps/359 (Java 14)
    https://openjdk.java.net/jeps/384 (Java 15)
*/


//----------------------------------------------------------------------------------------------
record SimpleRecord(String stringValue, Integer integerValue) { }
//----------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------
// COMPACT CONSTRUCTOR EXAMPLES
record RecordWithCompactConstructorValidation(String stringValue, Integer integerValue) {

    // NOTE: Notice the no-argument compact constructor.
    public RecordWithCompactConstructorValidation {

        Objects.requireNonNull(stringValue);
        Objects.requireNonNull(integerValue);
    }
}

record RecordWithCompactConstructorException(String stringValue, int integerValue) {

    public RecordWithCompactConstructorException {

        if (integerValue < 0) {
            throw new ExampleCustomException("Integer value must be a positive value");
        }
    }
}
class ExampleCustomException extends RuntimeException{

    public ExampleCustomException(String message) {
        super(message);
    }
}
//----------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------
// AN HAVE MULTIPLE CONSTRUCTORS, BUT NON-FULL CONSTRUCTORS CAN ONLY CALL THE FULL CONSTRUCTOR
record RecordWithMultipleConstructors(String stringValue, Integer integerValue) {

    public RecordWithMultipleConstructors(String stringValue) {
        this(stringValue, 0);
    }

    public RecordWithMultipleConstructors(String stringValue, Integer integerValue) {

        this.stringValue = stringValue;
        this.integerValue = integerValue;
    }
}
//----------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------
//interface extension in records
interface Describable {

    String getDescription();
}

record RecordImplementingAnInterface(String stringValue, Integer integerValue) implements Describable {

    @Override
    public String getDescription() {
        return "this record implements an interface";
    }
}
//----------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------
record RecordOverridingAccessor(String stringValue, Integer integerValue) {

    @Override
    public String stringValue() {
        return "This is a " + stringValue;
    }
}
//----------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------
// RECORDS FROM A SEALED TYPE
sealed interface Shape
        permits Triangle, Rectangle {

    String getDescription();
}

final record Triangle(int side1Length, int side2Length, int side3Length) implements Shape {

    @Override
    public String getDescription() {
        return "This is a triangle record";
    }
}

final record Rectangle(int width, int height) implements Shape {

    @Override
    public String getDescription() {
        return "This is a rectangle record";
    }
}
//----------------------------------------------------------------------------------------------

public class Example3Record {

    public static void main(String[] args) {

        // NOTE: java.lang.Record was introduced in Java 14 as a preview feature.
        //  A second preview was introduced in Java 15, with an addition of local records.
        //  IMPLICITLY FINAL
        //  CANNOT BE ABSTRACT
        //  IMMUTABLE (NO MUTATORS/SETTERS)

        // CREATE A RECORD.
        SimpleRecord simpleRecord = new SimpleRecord("a string", 7);
        System.out.println("\n1. Simple Record --->\n\t\t" + simpleRecord+"\n");

        // NOTE: Record accessors do not have a get prefix.
        // ACCESSORS DO NOT HAVE A get PREFIX
        System.out.println("2. Simple Record StringValue (simpleRecord.stringValue()): --->\n\t\t" +
                simpleRecord.stringValue()+"\n");

        //---------------------------------------------------------------------
        // NOTE: Records have compact canonical constructors.
        // USING COMPACT CANONICAL CONSTRUCTORS
        RecordWithCompactConstructorValidation validRecord =
                new RecordWithCompactConstructorValidation("s", -3);
        System.out.println("3. Valid record with validation check --->\n\t\t" +
                "validRecord : " + validRecord + "\n");

        // NOTE: Compact canonical constructors can be used for validation.
        try {
            // RECORD NOT CREATED
            RecordWithCompactConstructorValidation invalidRecord =
                    new RecordWithCompactConstructorValidation(null, -3);
        } catch (NullPointerException e) {
            System.out.println("4. Invalid record with validation check --->\n\t\t" +
                    "has a null value for a field that is checked for non-null\n");
        }

        // NOTE: Other examples of validation.
        try {
            // RECORD NOT CREATED
            RecordWithCompactConstructorException exceptionCreatingRecord =
                    new RecordWithCompactConstructorException("s", -3);
        } catch (ExampleCustomException e) {
            System.out.println("5. Record creation throws exception with validation check --->\n\t\t" +
                    e.getMessage() +"\n");
        }
        //---------------------------------------------------------------------


        //---------------------------------------------------------------------
        // NOTE: Records can have multiple constructors, but they have to call the full
        //  constructor in turn.
        // USING RECORD WITH MULTIPLE CONSTRUCTORS
        RecordWithMultipleConstructors constructor1Record =
                new RecordWithMultipleConstructors("s");
        System.out.println("6. Using a partial constructor --->\n\t\t" +
                constructor1Record+"\n");
        RecordWithMultipleConstructors constructor2Record =
                new RecordWithMultipleConstructors("s", 7);
        System.out.println("7. Using a full constructor --->\n\t\t" +
                constructor2Record+"\n");
        //---------------------------------------------------------------------


        //---------------------------------------------------------------------
        // NOTE: Records can implement an interface.
        // RECORDS IMPLEMENTING AN INTERFACE
        RecordImplementingAnInterface implementingAnInterface =
                new RecordImplementingAnInterface("s", 7);
        System.out.println("8. Record implementing an interface --->\n\t\t" +
                implementingAnInterface+"\n");
        System.out.println("9. Record interface method getDescription() --->\n\t\t" +
                implementingAnInterface.getDescription()+"\n");
        //---------------------------------------------------------------------


        //---------------------------------------------------------------------
        // NOTE: Record accessors can be overridden.
        // RECORDS ALLOW OVERRIDING THE ACCESSORS
        RecordOverridingAccessor overridingAccessor =
                new RecordOverridingAccessor("string", 7);
        System.out.println("10. Record overriding a field accessor, stringValue() --->\n\t\t" +
                overridingAccessor.stringValue()+"\n");
        //---------------------------------------------------------------------


        //---------------------------------------------------------------------
        // NOTE: Interoperability with sealed types is possible!
        // RECORDS WORK WELL WITH SEALED TYPES
        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println("11. Using a sealed record --->\n\t\t" +
                triangle+"\n");
        Rectangle rectangle = new Rectangle(4, 9);
        System.out.println("12. Using a sealed record --->\n\t\t" +
                rectangle+"\n");
        //---------------------------------------------------------------------


        //---------------------------------------------------------------------
        // NOTE: Local records.
        // LOCAL RECORDS - INTRODUCED IN JAVA 15
        record ItemCount(String item, int count) { }
        ItemCount apples = new ItemCount("Apples", 6);
        ItemCount bananas = new ItemCount("Bananas", 12);
        System.out.println("13. Using a local record --->\n\t\t" +
                apples+"\n");
        System.out.println("14. Using a local record --->\n\t\t" +
                bananas+"\n");

        //---------------------------------------------------------------------
        // NOTE: Pattern matching to determine if the instance is indeed a Record.
        // PATTERN MATCHING
        System.out.println("15. Class.isRecord  --->\n\t\t" +
                "simpleRecord is a Record? " +
                simpleRecord.getClass().isRecord() + "\n");
        System.out.println("16. Use instanceof for records --->\n\t\t" +
                "simpleRecord is a Record? " +
                (simpleRecord instanceof Record) + "\n");
        System.out.println("17. Record.class.isAssignableFrom --->\n\t\t" +
                "simpleRecord is a Record? " +
                (Record.class.isAssignableFrom(simpleRecord.getClass())) + "\n");

        Object mySimpleRecord = simpleRecord;
        // NOTE: Modern shortcut pattern matching
        // Introduced in Java 14 as a preview
        // Second preview in Java 15
        // Intended to the a final feature in Java 16
        if (mySimpleRecord instanceof Record aRecord) {
            // can use aRecord here
            System.out.println("18. simpleRecord is indeed a record --->\n\t\t" +
                    "Pattern matched aRecord is of type: " +
                    aRecord.getClass().getCanonicalName() + "\n");
        } else {
            // can't use aRecord here
            System.out.println("This should not print --->\n\t\t" +
                    "aRecord is not resolvable in this block.\n");
        }

    }
}