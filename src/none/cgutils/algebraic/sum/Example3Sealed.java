package none.cgutils.algebraic.sum;

public class Example3Sealed {


}

// ---------------------------------------------------
// FINAL CLASS DOES NOT ALLOW ANY EXTENSION
final class NoExtensionShape {
    private String description = "This is a final shape";

    public NoExtensionShape() {
    }

    public String getDescription() {
        return description;
    }
}
// ---------------------------------------------------



// ---------------------------------------------------
// ABSTRACT CLASS HAS TO BE EXTENDED TO BE PUT TO USE
abstract class AbstractShape {

    protected String description;

    public AbstractShape(String description) {
        this.description = description;
    }

    abstract String getDescription();
}
// EXTENDING AN ABSTRACT CLASS
class Hexagonal extends AbstractShape {
    public Hexagonal() {
        super("This is a hexagonal shape");
    }

    public Hexagonal(String description) {
        super(description);
    }

    @Override
    String getDescription() {
        return this.description;
    }
}
// ---------------------------------------------------



// ---------------------------------------------------
// AN "OPEN" CLASS CAN BE EXTENDED
class CustomShape {

    protected String description;

    public CustomShape(String description) {
        this.description = description;
    }

    String getDescription() {
        return "This is a custom shape";
    }
}
class Hexakaidecagon extends CustomShape {

    public Hexakaidecagon() {
        super("This is a sixteen-sided shape");
    }

    public Hexakaidecagon(String description) {
        super(description);
    }
}
// ---------------------------------------------------



// ---------------------------------------------------
sealed abstract class Shape permits Circle, Triangle, FourSidedShape {

    protected String description;

    public Shape(String description) {
        this.description = description;
    }

    String getDescription() {
        return "This is an abstract sealed shape";
    }
}

// CLASS NEEDS TO BE FINAL [OR SEALED OR NON-SEALED]
final class Circle extends Shape {
    public Circle() {
        super("This is a circle");
    }
}

// CLASS NEEDS TO BE SEALED [OR FINAL OR NON-SEALED]
sealed class Triangle extends Shape permits Equilateral, Isosceles, Scalene {
    public Triangle() {
        super("This is a circle");
    }

    public Triangle(String description) {
        super(description);
    }
}
final class Equilateral extends Triangle {
    public Equilateral() {
        super("Three sides of this triangle have same size");
    }
}
final class Isosceles extends Triangle {
    public Isosceles() {
        super("Two sides of this triangle have same size");
    }
}
final class Scalene extends Triangle {
    public Scalene() {
        super("No sides of this triangle have same size");
    }
}

// CLASS NEEDS TO BE NON-SEALED [OR FINAL OR SEALED]
non-sealed class FourSidedShape extends Shape {
    public FourSidedShape(String description) {
        super(description);
    }

    public FourSidedShape() {
        super("This is a four sided shape");
    }
}
// NON-SEALED IS N OPEN CLASS
class Rectangle extends FourSidedShape {
    public Rectangle() {
        super("This is a rectangle");
    }
}
class Square extends FourSidedShape {
    public Square() {
        super("This is a square");
    }
}
// ---------------------------------------------------


