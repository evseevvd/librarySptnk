package co.sptnk.service.impl.repository.book;

import co.sptnk.service.api.dto.criteria.SearchCriteriaBook;
import co.sptnk.service.impl.persistence.model.BaseEntity;
import co.sptnk.service.impl.persistence.model.Book;
import co.sptnk.service.impl.repository.RepositoryImpl;

import java.util.List;

/**
 * Created by evseevvd on 02.11.16.
 */
public class BookRepositoryImpl extends RepositoryImpl<Book> implements BookRepository {

    //Для CDI
    public BookRepositoryImpl() {
        this(Book.class);
    }

    protected BookRepositoryImpl(Class<? extends BaseEntity> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Book> searchByCriteria(SearchCriteriaBook criteria) {
        return null;
    }

    @Override
    public Integer count(SearchCriteriaBook criteria) {
        return null;
    }
}
