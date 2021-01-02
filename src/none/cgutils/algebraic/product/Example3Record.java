package none.cgutils.algebraic.product;

import java.util.Objects;

/*
JEPs:
    https://openjdk.java.net/jeps/359 (Java 14)
    https://openjdk.java.net/jeps/384 (Java 15)
*/

// IMPLICITLY FINAL
// CANNOT BE ABSTRACT

//----------------------------------------------------------------------------------------------
record SimpleRecord(String stringValue, Integer integerValue) { }
//----------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------
record CustomRecord(String stringValue, Integer integerValue) {
    public CustomRecord {
        Objects.requireNonNull(stringValue);
        Objects.requireNonNull(integerValue);
    }
}
//----------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------
record CustomRecord2(String stringValue, Integer integerValue) {
    public CustomRecord2(String stringValue, Integer integerValue) {
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

record CustomRecord3(String stringValue, Integer integerValue) implements Describable {
    @Override
    public String getDescription() {
        return null;
    }
}
//----------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------
record CustomRecord4(String stringValue, Integer integerValue) {
    @Override
    public String stringValue() {
        return "This is a " + stringValue;
    }
}
//----------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------
// COMPACT CONSTRUCTOR
record CustomRecord5(String stringValue, int integerValue) {
    public CustomRecord5 {
        if (integerValue < 0) {
            throw new IllegalArgumentException("Integer value must be a postive value");
        }
    }
}
//----------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------
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

    // TODO: create a local record

    // TODO: The direct superclass of a record type R is java.lang.Record.
}


