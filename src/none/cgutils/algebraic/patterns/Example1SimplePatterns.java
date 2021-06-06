package none.cgutils.algebraic.patterns;

public class Example1SimplePatterns {

    public static void main(String[] args) {

        Long aLong = 7L;
        printIfLong(aLong);
    }

    private static void printIfLong(Object object) {

        if(object instanceof Long) {
            Long aLong = (Long) object;
            System.out.println("aLong = [" + aLong +"]");
        }
    }
}