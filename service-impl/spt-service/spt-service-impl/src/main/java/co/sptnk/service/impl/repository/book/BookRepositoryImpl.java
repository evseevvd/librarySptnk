package co.sptnk.service.impl.repository.book;

import co.sptnk.service.api.dto.criteria.SearchCriteriaBook;
import co.sptnk.service.impl.persistence.model.BaseEntity;
import co.sptnk.service.impl.persistence.model.Book;
import co.sptnk.service.impl.repository.RepositoryImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
        Root<Book> bookRoot = query.from(Book.class);

        List<Predicate> predicates = new ArrayList<Predicate>();

        if (criteria.getName() != null) {
            predicates.add(criteriaBuilder.equal(bookRoot.get("name"), criteria.getName()));
        }

        if (criteria.getAthor() != null) {
            predicates.add(criteriaBuilder.equal(bookRoot.get("athor"), criteria.getAthor()));
        }

        if (criteria.getDate() != null) {
            predicates.add(criteriaBuilder.equal(bookRoot.get("date"), criteria.getDate()));
        }

        CriteriaQuery<Book> bookCriteriaQuery = query.where(predicates.toArray(new Predicate[predicates.size()]));

        List<Book> resultList = entityManager.createQuery(bookCriteriaQuery).getResultList();

        return resultList;
    }

    @Override
    public Integer count(SearchCriteriaBook criteria) {
        return null;
    }
}
