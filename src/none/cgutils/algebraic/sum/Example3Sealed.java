package none.cgutils.algebraic.sum;


/*

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
public class Example3Sealed {

    public static void main(String[] args) {
        NoExtensionShape noExtensionShape = new NoExtensionShape();
        System.out.println("\n1. Final NoExtension shape --->\n\t" + noExtensionShape.getDescription());

        Pentagon pentagon = new Pentagon();
        System.out.println("\n2. Open Pentagon extended from AbstractShape  --->\n\t" + pentagon.getDescription());

        CustomShape customShape = new CustomShape();
        System.out.println("\n3. Open CustomShape (extendable) --->\n\t" + customShape.getDescription());

        Hexagon hexagon = new Hexagon();
        System.out.println("\n\t4. Open Hexagon extended from CustomShape --->\n\t\t" + hexagon.getDescription());

        Circle circle = new Circle();
        System.out.println("\n5. Final Circle sealed via Shape --->\n\t" + circle.getDescription());

        Triangle triangle = new Triangle();
        System.out.println("\n6. Sealed Triangle sealed via Shape --->\n\t" + triangle.getDescription());

        Equilateral equilateral = new Equilateral();
        System.out.println("\n\t7. Final Equilateral sealed via Triangle --->\n\t\t" + equilateral.getDescription());

        Isosceles isosceles = new Isosceles();
        System.out.println("\n\t8. Final Isosceles sealed via Triangle --->\n\t\t" + isosceles.getDescription());

        Scalene scalene = new Scalene();
        System.out.println("\n\t9. Final Scalene sealed via Triangle --->\n\t\t" + scalene.getDescription());

        FourSidedShape fourSidedShape = new FourSidedShape();
        System.out.println("\n10. Non-sealed extended from Sealed Shape --->\n\t" + fourSidedShape.getDescription());

        Rectangle rectangle = new Rectangle();
        System.out.println("\n\t11. Open extended from Non-sealed FourSidedShape --->\n\t\t" + rectangle.getDescription());

        Square square = new Square();
        System.out.println("\n\t\t12. Open extended from an Open Rectangle --->\n\t\t\t" + square.getDescription());

    }
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
class Pentagon extends AbstractShape {
    public Pentagon() {
        super("This is a hexagonal shape");
    }

    public Pentagon(String description) {
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
}
// ---------------------------------------------------


