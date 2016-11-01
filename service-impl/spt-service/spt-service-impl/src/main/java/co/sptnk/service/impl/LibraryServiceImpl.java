package co.sptnk.service.impl;

import co.sptnk.service.api.LibraryService;
import co.sptnk.service.api.dto.BookDto;
import co.sptnk.service.api.dto.criteria.SearchCriteriaBook;
import co.sptnk.service.api.dto.response.AddOrUpdateResponse;
import co.sptnk.service.api.dto.response.FindResponse;
import co.sptnk.service.impl.mapper.book.BookMapping;
import co.sptnk.service.impl.persistence.meta.Book_;
import co.sptnk.service.impl.persistence.model.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.NotFoundException;

import static co.sptnk.service.impl.persistence.meta.Book_.ATHOR;
import static co.sptnk.service.impl.persistence.meta.Book_.NAME;

/**
 * Created by Владимир on 01.11.2016.
 *
 * Имплементация сервиса
 */
public class LibraryServiceImpl implements LibraryService {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private BookMapping mapping;

    @Override
    public AddOrUpdateResponse addOrUpdateBook(BookDto bookDto) throws IllegalAccessException, InstantiationException {
        if (bookDto == null) {
            throw new NotFoundException();
        }
        Book book = mapping.entityToDto(bookDto);
        if (bookDto.getId().isEmpty()) {
            em.merge(book);
        } else {
            em.persist(book);
        }

        AddOrUpdateResponse response = new AddOrUpdateResponse();
        return response;
    }

    @Override
    public void deleteBook(BookDto bookDto) throws IllegalAccessException, InstantiationException {
        Book book = mapping.entityToDto(bookDto);
        em.remove(book);
    }

    @Override
    public FindResponse getBook(String id) throws IllegalAccessException, InstantiationException {
        Book book = em.find(Book.class, id);

        if (book == null) {
            throw new NotFoundException("Сущность не найдена");
        }

        BookDto bookDto = mapping.dtoToEntity(book);
        FindResponse response = new FindResponse();
        response.setBooks(Arrays.asList(bookDto));
        return response;
    }

    @Override
    public FindResponse findBooks(SearchCriteriaBook criteria) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
        Root<Book> bookRoot = query.from(Book.class);

        List<Predicate> predicates = new ArrayList<Predicate>();

        if (!criteria.getName().isEmpty()) {
            predicates.add(criteriaBuilder.equal(bookRoot.get(NAME), criteria.getName()));
        }

        if (!criteria.getAthor().isEmpty()) {
            predicates.add(criteriaBuilder.equal(bookRoot.get(ATHOR), criteria.getAthor()));
        }

        if (criteria.getDate() != null) {
            predicates.add(criteriaBuilder.equal(bookRoot.get(Book_.DATE), criteria.getDate()));
        }

        return null;
    }
}
