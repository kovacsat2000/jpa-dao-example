package book;

import book.model.Book;
import jpa.*;
import javax.persistence.*;
import javax.transaction.*;
import java.util.*;

public class BookDao extends GenericJpaDao <Book> {

    @Transactional
    public Optional <Book> findByIsbn13 (String isbn13) {
        try {
            return Optional.of(entityManager.createQuery("SELECT x from Book x WHERE x.isbn13 =: isbn13", Book.class)
                    .setParameter("isbn13", isbn13)
                    .getSingleResult());

        }catch (NoResultException e) {
            return Optional.empty();
        }
    }

}
