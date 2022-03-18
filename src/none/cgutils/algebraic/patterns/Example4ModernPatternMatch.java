package none.cgutils.algebraic.patterns;

public class Example4ModernPatternMatch {

    public static void main(String[] args) {

        Long aLong = 7L;
        printIfLong(aLong);
    }

    private static void printIfLong(Object object) {

        if(object instanceof Long myLong) {
            //                 "object"      is the     "variable"
            // "instanceof Long myLong"      is the     "pattern matching"
            //
            // --------------------------------------------------- Pattern Matching = test + target
            //        "instanceof Long"      is the     "test"   or   "predicate"
            //                 "myLong"      is the     "target" or   "binding variable"

            System.out.println("aLong = [" + myLong +"]");
        }
    }
}