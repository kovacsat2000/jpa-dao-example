package book;

import book.model.Book;
import com.google.inject.*;
import guice.*;

public class Main {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        BookDao bookDao = injector.getInstance(BookDao.class);

        for(int i=0; i<100; i++) {
            Book book = BookGenerator.createBook();
            bookDao.persist(book);
        }

        bookDao.findAll().stream().forEach(System.out::println);

    }

}
