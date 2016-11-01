package co.sptnk.service.impl.persistence.meta;

import co.sptnk.service.impl.persistence.model.Book;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by Владимир on 01.11.2016.
 *
 * Мета модель сущности Книга
 */
@StaticMetamodel(Book.class)
public class Book_ {
    public static volatile SingularAttribute<Book, String> NAME;
    public static volatile SingularAttribute<Book, String> ATHOR;
    public static volatile SingularAttribute<Book, Date> DATE;
}
