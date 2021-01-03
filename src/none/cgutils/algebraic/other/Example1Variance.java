package none.cgutils.algebraic.other;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

abstract class Shape {

    protected String id;

    protected String description;

    public Shape(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
    }

    String getDescription() {
        return description + ", id=" + id;
    }
}

final class Circle extends Shape {

    public Circle() {
        super("This is a circle");
    }
}

class Triangle extends Shape {

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


public class Example1Variance {

    public static void main(String[] args) {

        // Valid
        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle());
        circles.add(new Circle());
        circles.add(new Circle());

        ArrayList<Triangle> triangles = new ArrayList<>();
        triangles.add(new Triangle());
        triangles.add(new Isosceles());
        triangles.add(new Scalene());


        //---------------------------------------------------------------------
        // INVARIANCE - GET SUBCLASS VALUES, CANNOT SET SUBCLASS VALUES

        // NOTICE DIFFERENT SHAPES ADDED AND RETRIEVED
        List<Shape> allShapes = new ArrayList<>();
        //VALID
        allShapes.add(new Circle());
        //VALID
        allShapes.add(new Triangle());
        //VALID
        allShapes.add(new Equilateral());

        // REQUIRES NO CASTING TO GET SHAPE ATTRIBUTES/BEHAVIOUR
        allShapes.forEach(shape ->
                System.out.println("Invariance :: --->\n\tDescription: " +
                        shape.getDescription() +
                        "\n\tClass Simple Name: " +
                        shape.getClass().getSimpleName() + "\n"));
        //---------------------------------------------------------------------
        System.out.println();


        //---------------------------------------------------------------------
        // COVARIANCE - GET SUBCLASS VALUES, CANNOT SET SUBCLASS VALUES

        // INVALID
//        List<Shape> invalidShapes = new ArrayList<Triangle>();

        // VALID
        // NOTICE THE USE OF EXTENDS
        List<? extends Shape> covariantShapes = circles;

        // REQUIRES NO CASTING TO GET SHAPE ATTRIBUTES/BEHAVIOUR
        covariantShapes.forEach(shape ->
                System.out.println("Covariance :: --->\n\tDescription: " +
                        shape.getDescription() +
                        "\n\tClass Simple Name: " +
                        shape.getClass().getSimpleName() + "\n"));

        // INVALID
//        circleShapes.add(new Circle());

        // CASTING REQUIRED
        Circle circle = (Circle) covariantShapes.get(0);
        //---------------------------------------------------------------------
        System.out.println();


        //---------------------------------------------------------------------
        // CONTRAVARIANCE - SET SUBCLASS VALUES, CANNOT GET SUBCLASS VALUES

        // VALID
        // NOTICE THE USE OF SUPER
        List<? super Shape> contravariantShapes = new ArrayList<>();

        contravariantShapes.addAll(triangles);
        contravariantShapes.addAll(circles);

        // INVALID WITHOUT CASTING
//        contravariantShapes.forEach(shape ->
//                System.out.println("Contravariance :: Description() --->\n\t" +
//                      shape.getDescription()));

        // REQUIRES CASTING TO GET SHAPE ATTRIBUTES/BEHAVIOUR
        // SIMPLE NAME OPERATION ON CLASS, NOT ON A SPECIFIC SHAPE, SO NO CASTING REQUIRED
        contravariantShapes.forEach(shape ->
                System.out.println("Contravariance :: --->\n\tDescription: " +
                        ((Shape) shape).getDescription() +
                        "\n\tClass Simple Name: " +
                        shape.getClass().getSimpleName() + "\n"));


        //VALID
        contravariantShapes.add(new Isosceles());

        // CASTING REQUIRED
        Triangle triangle = (Triangle) contravariantShapes.get(0);
    }
}