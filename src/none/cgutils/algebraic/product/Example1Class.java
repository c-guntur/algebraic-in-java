package none.cgutils.algebraic.product;

//----------------------------------------------------------------------------------------------
// A PLAIN OLD JAVA OBJECT
class Pojo {

    private String string;

    private Integer integer;

    private Boolean flag;

    public Pojo(String string, Integer integer, Boolean flag) {
        this.string = string;
        this.integer = integer;
        this.flag = flag;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "string='" + string + '\'' +
                ", integer=" + integer +
                ", flag=" + flag +
                '}';
    }
}
//----------------------------------------------------------------------------------------------

public class Example1Class {

    public static void main(String[] args) {

        // NOTE: Creating an instance of a POJO (Plain Old Java Object).

        Pojo pojo = new Pojo("Hello World", 1, Boolean.TRUE);
        System.out.println("\n1. Pojo --->\n\t\t" +
                pojo);

        // NOTE: Pattern matching to check if the instance is of a certain type
        // PATTERN MATCHING
        System.out.println("\n2. pojo is type of Pojo using instanceof --->\n\t\t" +
                (pojo instanceof Pojo));

        System.out.println("\n3. pojo is type of Pojo using isInstance()) --->\n\t\t" +
                Pojo.class.isInstance(pojo));

        System.out.println("\n4. pojo is type of Pojo using isAssignableFrom() --->\n\t\t" +
                (pojo.getClass().isAssignableFrom(Pojo.class)));

        System.out.println("\n5. pojo is type of Pojo using getName() --->\n\t\t" +
                "none.cgutils.algebraic.product.Pojo".equals(pojo.getClass().getName()));

        System.out.println("\n6. pojo is type of Pojo using getCanonicalName() --->\n\t\t" +
                "none.cgutils.algebraic.product.Pojo".equals(pojo.getClass().getCanonicalName()));

        System.out.println("\n7. pojo is type of Pojo using getSimpleName() --->\n\t\t" +
                "Pojo".equals(pojo.getClass().getSimpleName()));

    }
}