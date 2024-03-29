package none.cgutils.algebraic.patterns;

// Visitor interface
interface EntertainmentVisitorInterface {

    String visit(Book book);
    String visit(Movie movie);
}

// Interface to accept a Visitor for a property
interface EntertainmentItem {

    String accept(EntertainmentVisitorInterface visitor);
}

class Book implements EntertainmentItem {

    private String title;
    private int rating;
    private BookType bookType;

    enum BookType{PAPERBACK, HARDCOVER}

    public Book(String title, int rating, BookType bookType) {

        this.title = title;
        this.rating = rating;
        this.bookType = bookType;
    }

    @Override
    public String toString() {

        return "Book{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", bookType=" + bookType +
                '}';
    }

    @Override
    public String accept(EntertainmentVisitorInterface visitor) {

        return visitor.visit(this);
    }
}

class Movie implements EntertainmentItem {

    private String title;
    private int rating;
    private MovieType movieType;

    enum MovieType{DVD, BLUERAY}

    public Movie(String title, int rating, MovieType movieType) {
        this.title = title;
        this.rating = rating;
        this.movieType = movieType;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", movieType=" + movieType +
                '}';
    }

    @Override
    public String accept(EntertainmentVisitorInterface visitor) {

        return visitor.visit(this);
    }
}

// A visitor implementation
class EntertainmentVisitor implements EntertainmentVisitorInterface {

    @Override
    public String visit(Book book) {

        return book.toString();
    }

    @Override
    public String visit(Movie movie) {

        return movie.toString();
    }
}


public class Example2VisitorPattern {

    public static void main(String[] args) {

        EntertainmentItem[] properties = new EntertainmentItem[] {

                new Book(
                        "The Lord Of The Rings",
                        5,
                        Book.BookType.HARDCOVER),
                new Book(
                        "Far From The Maddening Crowd",
                        3,
                        Book.BookType.PAPERBACK),
                new Movie(
                        "Star Trek - The Voyage Home",
                        5,
                        Movie.MovieType.BLUERAY),
                new Movie(
                        "Star Wars - Original Trilogy",
                        5,
                        Movie.MovieType.DVD)
        };
        EntertainmentVisitor visitor = new EntertainmentVisitor();

        for (EntertainmentItem entertainmentItem : properties) {

            System.out.println(entertainmentItem.accept(visitor));
        }

    }
}