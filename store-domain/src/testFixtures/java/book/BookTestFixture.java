package book;

import com.company.store.domain.book.Book;

import java.util.List;

public class BookTestFixture {

    public static Book getBook() {
        return new Book(
                "bookName",
                "minyul"
        );
    }

    public static List<Book> getBookList() {
        return List.of(
                new Book(
                        "bookName1",
                        "minyul"
                ),
                new Book(
                        "bookName2",
                        "minyul"
                )
        );
    }

}
