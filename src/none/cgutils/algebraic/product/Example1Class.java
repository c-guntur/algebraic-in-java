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
    }
}