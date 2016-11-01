package co.sptnk.service.impl.persistence.listener;

import co.sptnk.service.impl.persistence.model.Book;
import java.util.UUID;
import javax.persistence.PrePersist;

/**
 * Created by Владимир on 01.11.2016.
 *
 *
 */
public class PrePersistBook {

    @PrePersist
    public void generatedId(Book book) {
        if (book.getId().isEmpty()) {
            book.setId(UUID.randomUUID().toString());
        }
    }
}
