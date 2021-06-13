package none.cgutils.algebraic.patterns;

public class Example4ModernPatternMatch {

    public static void main(String[] args) {

        Long aLong = 7L;
        printIfLong(aLong);
    }

    private static void printIfLong(Object object) {

        if(object instanceof Long myLong) {
            //                 "object"  is the "variable"
            // "instanceof Long myLong"  is the "pattern matching"
            // --------------------------------------------------- Pattern Matching = test + target
            //        "instanceof Long"      is the "test"
            //                 "myLong"      is the "target"

            System.out.println("aLong = [" + myLong +"]");
        }
    }

}
