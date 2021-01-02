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
        System.out.println("\n1. integerStringPair --->\n\t" + integerStringPair);

        Pair<String, Boolean> stringBooleanPair = new Pair<>("TRUE", Boolean.TRUE);
        System.out.println("\n2. stringBooleanPair --->\n\t" + stringBooleanPair);

        Twin<String> stringTwin = new Twin<>("One", "Uno");
        System.out.println("\n3. stringTwin --->\n\t" + stringTwin);
    }
}