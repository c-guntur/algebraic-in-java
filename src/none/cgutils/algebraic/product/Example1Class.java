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
        Pojo pojo = new Pojo("Hello World", 1, Boolean.TRUE);
        System.out.println("\n1. Pojo --->\n\t" + pojo);

        // Pattern matching
        System.out.println("\n2. pojo is type of Pojo using instanceof --->\n\t" +
                (pojo instanceof Pojo));
        System.out.println("\n3. pojo is type of Pojo using isInstance()) --->\n\t" +
                Pojo.class.isInstance(pojo));
        System.out.println("\n4. pojo is type of Pojo using isAssignableFrom() --->\n\t" +
                (pojo.getClass().isAssignableFrom(Pojo.class)));
        System.out.println("\n5. pojo is type of Pojo using getName() --->\n\t" +
                "none.cgutils.algebraic.product.Pojo".equals(pojo.getClass().getName()));
        System.out.println("\n6. pojo is type of Pojo using getCanonicalName() --->\n\t" +
                "none.cgutils.algebraic.product.Pojo".equals(pojo.getClass().getCanonicalName()));
        System.out.println("\n7. pojo is type of Pojo using getSimpleName() --->\n\t" +
                "Pojo".equals(pojo.getClass().getSimpleName()));

    }
}