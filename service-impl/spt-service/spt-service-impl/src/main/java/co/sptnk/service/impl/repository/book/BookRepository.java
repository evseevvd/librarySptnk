package co.sptnk.service.impl.repository.book;

import co.sptnk.service.api.dto.criteria.SearchCriteriaBook;
import co.sptnk.service.impl.persistence.model.Book;
import co.sptnk.service.impl.repository.Repository;

import java.util.List;

/**
 * Created by evseevvd on 02.11.16.
 *
 * Repository for Book entity
 */
public interface BookRepository extends Repository<Book> {

    List<Book> searchByCriteria(SearchCriteriaBook criteria);

    Integer count(SearchCriteriaBook criteria);
}
