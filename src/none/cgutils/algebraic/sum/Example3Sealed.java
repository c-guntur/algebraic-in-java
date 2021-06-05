package none.cgutils.algebraic.sum;


/*

JEPs:
    https://openjdk.java.net/jeps/360 (Java 15)
    https://openjdk.java.net/jeps/397 (Java 16)


🄵 [NoExtensionShape]

🄰 (AbstractShape)
    '-- 🄾 Pentagon

🄾 CustomShape
    '-- 🄾 Hexagon

🅂 {Shape}
    |
    '-- 🄵 [Circle]
    |
    '-- 🅂 {Triangle}
    |    |
    |    '-- 🄵 [Equilateral]
    |    |
    |    '-- 🄵 [Isosceles]
    |    |
    |    '-- 🄵 [Scalene]
    |
    '-- 🅄 }FourSidedShape{
        |
        '-- 🄾 Rectangle
            |
            '-- 🄾 Square

*/

//----------------------------------------------------------------------------------------------
// FINAL CLASS DOES NOT ALLOW ANY EXTENSION
final class NoExtensionShape {

    private String description = "This is a final shape";

    public NoExtensionShape() {
    }

    public String getDescription() {
        return description;
    }
}
//----------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------
// ABSTRACT CLASS HAS TO BE EXTENDED TO BE PUT TO USE
abstract class AbstractShape {

    protected String description;

    public AbstractShape(String description) {
        this.description = description;
    }

    abstract String getDescription();
}

// EXTENDING AN ABSTRACT CLASS
class Pentagon extends AbstractShape {

    public Pentagon() {
        super("This is a pentagon shape");
    }

    public Pentagon(String description) {
        super(description);
    }

    @Override
    String getDescription() {
        return this.description;
    }
}
//----------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------
// AN "OPEN" CLASS CAN BE EXTENDED
class CustomShape {

    protected String description;

    public CustomShape() {
        this("This is a custom shape");
    }

    public CustomShape(String description) {
        this.description = description;
    }

    String getDescription() {
        return description;
    }
}

class Hexagon extends CustomShape {

    public Hexagon() {
        super("This is a six-sided shape");
    }

    public Hexagon(String description) {
        super(description);
    }
}
//----------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------
sealed abstract class Shape permits Circle, Triangle, FourSidedShape {

    protected String description;

    public Shape(String description) {
        this.description = description;
    }

    String getDescription() {
        return description;
    }
}

//class Octagon extends Shape {
//
//    public Octagon(String description) {
//        this.description = description;
//    }
//
//    @Override
//    String getDescription() {
//        return "This is not valid";
//    }
//}

// CLASS NEEDS TO BE FINAL [OR SEALED OR NON-SEALED]
final class Circle extends Shape {

    public Circle() {
        super("This is a circle");
    }
}

// CLASS NEEDS TO BE SEALED [OR FINAL OR NON-SEALED]
sealed class Triangle extends Shape permits Equilateral, Isosceles, Scalene {

    public Triangle() {
        super("This is a triangle");
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

// NON-SEALED IS AN OPEN CLASS
class Rectangle extends FourSidedShape {

    public Rectangle(String description) {
        super(description);
    }

    public Rectangle() {
        super("This is a rectangle");
    }
}

class Square extends Rectangle {

    public Square() {
        super("This is a square");
    }

//    String getDescription() {
//        return "This is a square";
//    }
}
//----------------------------------------------------------------------------------------------

public class Example3Sealed {

    public static void main(String[] args) {

        // NOTE: The sealed type was introduced as a preview in Java 15.
        // NOTE: Non-access modifiers for types:
        //  <none> (open)
        //  final
        //  abstract
        //  sealed
        //  non-sealed

        // NOTE: A normal [final] class.
        NoExtensionShape noExtensionShape = new NoExtensionShape();
        System.out.println("\n1. Final NoExtension shape --->\n\t"
                + noExtensionShape.getDescription());

        // NOTE: A normal [open] class extending from an [abstract] class.
        Pentagon pentagon = new Pentagon();
        System.out.println("\n2. Open Pentagon extended from AbstractShape  --->\n\t"
                + pentagon.getDescription());

        // NOTE: A normal [open] class.
        CustomShape customShape = new CustomShape();
        System.out.println("\n3. Open CustomShape (extendable) --->\n\t"
                + customShape.getDescription());

        // NOTE: A normal [open] class extending from another [open] class.
        Hexagon hexagon = new Hexagon();
        System.out.println("\n\t4. Open Hexagon extended from CustomShape --->\n\t\t"
                + hexagon.getDescription());

        // NOTE: A [final] class permitted by a [sealed] [abstract] class.
        Circle circle = new Circle();
        System.out.println("\n5. Final Circle sealed via Shape --->\n\t"
                + circle.getDescription());

        // NOTE: A [sealed] class [permit]ted by another [sealed] class.
        Triangle triangle = new Triangle();
        System.out.println("\n6. Sealed Triangle sealed via Shape --->\n\t"
                + triangle.getDescription());

        // NOTE: A [final] class [permit]ted by a [sealed] class which itself is [permit]ted
        //  by another [sealed] class.
        Equilateral equilateral = new Equilateral();
        System.out.println("\n\t7. Final Equilateral sealed via Triangle --->\n\t\t"
                + equilateral.getDescription());
        Isosceles isosceles = new Isosceles();
        System.out.println("\n\t8. Final Isosceles sealed via Triangle --->\n\t\t"
                + isosceles.getDescription());
        Scalene scalene = new Scalene();
        System.out.println("\n\t9. Final Scalene sealed via Triangle --->\n\t\t"
                + scalene.getDescription());

        // NOTE: A [non-sealed] class permitted by a [sealed] class.
        FourSidedShape fourSidedShape = new FourSidedShape();
        System.out.println("\n10. Non-sealed extended from Sealed Shape --->\n\t"
                + fourSidedShape.getDescription());

        // NOTE: An [open] class extending from a [non-sealed] class.
        Rectangle rectangle = new Rectangle();
        System.out.println("\n\t11. Open extended from Non-sealed FourSidedShape --->\n\t\t"
                + rectangle.getDescription());

        // NOTE: An [open] class extending from an open class which itself is a [non-sealed] class.
        Square square = new Square();
        System.out.println("\n\t\t12. Open extended from an Open Rectangle --->\n\t\t\t"
                + square.getDescription());


        // NOTE: Pattern matching is similar to any other Java object.
        if (square instanceof Shape) {
            System.out.println("\n\t13. Square is a shape --->\n\t\t\t");
        }

        if (Shape.class.isAssignableFrom(square.getClass())) {
            System.out.println("\n\t13a. Square is a shape --->\n\t\t\t");
        }

        Object mySquare = square;
        // NOTE: Modern shortcut pattern matching
        // Introduced in Java 14 as a preview
        // Second preview in Java 15
        // Intended to the a final feature in Java 16
        if (mySquare instanceof Shape aShape) {
            // can use aShape here
            System.out.println("\n\t14. A square is indeed a Shape --->\n\t\t" +
                    "Pattern matched aShape is of type: " +
                    aShape.getClass().getCanonicalName() + "\n");
        } else {
            // can't use aShape here
            System.out.println("This should not print --->\n\t\t" +
                    "aShape is not resolvable in this block.\n");
        }
    }
}