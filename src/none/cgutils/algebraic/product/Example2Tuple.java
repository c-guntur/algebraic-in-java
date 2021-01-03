package none.cgutils.algebraic.product;

//----------------------------------------------------------------------------------------------
// A PAIR IS A TWO-TUPLE OF TWO TYPES
// Generics helped quite a bit
class Pair<T, U> {

    T first;
    U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first.toString() +
                ", second=" + second.toString() +
                '}';
    }
}
//----------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------
// A TWIN IS A TWO-TUPLE OF SINGLE TYPE
// Generics helped quite a bit
class Twin<T> {

    T first;
    T second;

    public Twin(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Twin{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
//----------------------------------------------------------------------------------------------

public class Example2Tuple {

    public static void main(String[] args) {

        Pair<Integer, String> integerStringPair = new Pair<>(1, "One");
        System.out.println("\n1. integerStringPair --->\n\t\t" +
                integerStringPair);

        System.out.println("\n2. integerStringPair.getFirst() --->\n\t\t" +
                integerStringPair.getFirst());

        System.out.println("\n3. integerStringPair.getSecond() --->\n\t\t" +
                integerStringPair.getSecond());


        Pair<String, Boolean> stringBooleanPair = new Pair<>("aString", Boolean.TRUE);
        System.out.println("\n4. stringBooleanPair --->\n\t\t" +
                stringBooleanPair);

        System.out.println("\n5. stringBooleanPair.getFirst() --->\n\t\t" +
                stringBooleanPair.getFirst());

        System.out.println("\n6. stringBooleanPair.getSecond() --->\n\t\t" +
                stringBooleanPair.getSecond());


        Twin<String> stringTwin = new Twin<>("One", "Uno");
        System.out.println("\n7. stringTwin --->\n\t\t" +
                stringTwin);

        System.out.println("\n8. stringTwin.getFirst() --->\n\t\t" +
                stringTwin.getFirst());

        System.out.println("\n9. stringTwin.getSecond() --->\n\t\t" +
                stringTwin.getSecond());
    }
}