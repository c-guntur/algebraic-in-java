package none.cgutils.algebraic.product;

import java.util.Objects;

/*
IMPLICITLY FINAL
CANNOT BE ABSTRACT
IMMUTABLE (NO MUTATORS/SETTERS)

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

record Triangle(int side1Length, int side2Length, int side3Length) implements Shape {

    @Override
    public String getDescription() {
        return "This is a triangle record";
    }
}

record Rectangle(int width, int height) implements Shape {

    @Override
    public String getDescription() {
        return "This is a rectangle record";
    }
}
//----------------------------------------------------------------------------------------------


public class Example3Record {

    public static void main(String[] args) {

        SimpleRecord simpleRecord = new SimpleRecord("a string", 7);
        System.out.println("\n1. Simple Record --->\n\t\t" + simpleRecord+"\n");
        // ACCESSORS DO NOT HAVE A get PREFIX
        System.out.println("2. Simple Record StringValue (simpleRecord.stringValue()): --->\n\t\t" +
                simpleRecord.stringValue()+"\n");

        // PATTERN MATCHING
        System.out.println("3. Class.isRecord  --->\n\t\t" +
                "simpleRecord is a Record? " +
                simpleRecord.getClass().isRecord() + "\n");
        System.out.println("4. Use instanceof for records --->\n\t\t" +
                "simpleRecord is a Record? " +
                (simpleRecord instanceof Record) + "\n");
        System.out.println("5. Record.class.isAssignableFrom --->\n\t\t" +
                "simpleRecord is a Record? " +
                (Record.class.isAssignableFrom(simpleRecord.getClass())) + "\n");


        //---------------------------------------------------------------------
        // USING COMPACT CANONICAL CONSTRUCTORS
        RecordWithCompactConstructorValidation validRecord =
                new RecordWithCompactConstructorValidation("s", -3);
        System.out.println("6. Valid record with validation check --->\n\t\t" +
                "validRecord : " + validRecord + "\n");

        try {
            // RECORD NOT CREATED
            RecordWithCompactConstructorValidation invalidRecord =
                    new RecordWithCompactConstructorValidation(null, -3);
        } catch (NullPointerException e) {
            System.out.println("7. Invalid record with validation check --->\n\t\t" +
                    "has a null value for a field that is checked for non-null\n");
        }

        try {
            // RECORD NOT CREATED
            RecordWithCompactConstructorException exceptionCreatingRecord =
                    new RecordWithCompactConstructorException("s", -3);
        } catch (ExampleCustomException e) {
            System.out.println("8. Record creation throws exception with validation check --->\n\t\t" +
                    e.getMessage() +"\n");
        }
        //---------------------------------------------------------------------


        //---------------------------------------------------------------------
        // USING RECORD WITH MULTIPLE CONSTRUCTORS
        RecordWithMultipleConstructors construstor1Record =
                new RecordWithMultipleConstructors("s");
        System.out.println("9. Using a partial constructor --->\n\t\t" +
                construstor1Record+"\n");
        RecordWithMultipleConstructors construstor2Record =
                new RecordWithMultipleConstructors("s", 7);
        System.out.println("10. Using a full constructor --->\n\t\t" +
                construstor2Record+"\n");
        //---------------------------------------------------------------------


        //---------------------------------------------------------------------
        // RECORDS IMPLEMENTING AN INTERFACE
        RecordImplementingAnInterface implementingAnInterface =
                new RecordImplementingAnInterface("s", 7);
        System.out.println("11. Record implementing an interface --->\n\t\t" +
                implementingAnInterface+"\n");
        System.out.println("12. Record interface method getDescription() --->\n\t\t" +
                implementingAnInterface.getDescription()+"\n");
        //---------------------------------------------------------------------


        //---------------------------------------------------------------------
        // RECORDS ALLOW OVERRIDING THE ACCESSORS
        RecordOverridingAccessor overridingAccessor =
                new RecordOverridingAccessor("string", 7);
        System.out.println("13. Record overriding a field accessor, stringValue() --->\n\t\t" +
                overridingAccessor.stringValue()+"\n");
        //---------------------------------------------------------------------


        //---------------------------------------------------------------------
        // RECORDS WORK WELL WITH SEALED TYPES
        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println("14. Using a sealed record --->\n\t\t" +
                triangle+"\n");
        Rectangle rectangle = new Rectangle(4, 9);
        System.out.println("15. Using a sealed record --->\n\t\t" +
                rectangle+"\n");
        //---------------------------------------------------------------------


        //---------------------------------------------------------------------
        // LOCAL RECORDS - INTRODUCED IN JAVA 15
        record ItemCount(String item, int count) { }
        ItemCount apples = new ItemCount("Apples", 6);
        ItemCount bananas = new ItemCount("Bananas", 12);
        System.out.println("16. Using a local record --->\n\t\t" +
                apples+"\n");
        System.out.println("17. Using a local record --->\n\t\t" +
                bananas+"\n");
        //---------------------------------------------------------------------
    }
}