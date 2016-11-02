package co.sptnk.service.impl;

import co.sptnk.service.api.LibraryService;
import co.sptnk.service.api.dto.BookDto;
import co.sptnk.service.api.dto.criteria.SearchCriteriaBook;
import co.sptnk.service.api.dto.response.AddOrUpdateResponse;
import co.sptnk.service.api.dto.response.FindResponse;
import co.sptnk.service.impl.mapper.book.BookMapping;
import co.sptnk.service.impl.persistence.model.Book;
import co.sptnk.service.impl.repository.book.BookRepository;
import org.apache.commons.collections.CollectionUtils;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Владимир on 01.11.2016.
 *
 * Имплементация сервиса
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class LibraryServiceImpl implements LibraryService {

    @Inject
    private BookRepository repository;

    @Inject
    private BookMapping mapping;

    @Override
    public AddOrUpdateResponse addOrUpdateBook(BookDto bookDto) throws IllegalAccessException, InstantiationException {
        if (bookDto == null) {
            throw new NotFoundException();
        }
        Book book = mapping.entityToDto(bookDto);
        if (book.getId().isEmpty()) {
            repository.create(book);
        } else {
            repository.update(book);
        }
        return new AddOrUpdateResponse();
    }

    @Override
    public void deleteBook(BookDto bookDto) throws IllegalAccessException, InstantiationException {
        Book book = mapping.entityToDto(bookDto);
        repository.remove(book);
    }

    @Override
    public FindResponse getBook(String id) throws IllegalAccessException, InstantiationException {
        Book book = repository.read(id);
        FindResponse response = new FindResponse();
        response.setBooks(Arrays.asList(mapping.dtoToEntity(book)));
        return response;
    }

    @Override
    public FindResponse findBooks(SearchCriteriaBook criteria) throws IllegalAccessException, InstantiationException {
        FindResponse response = new FindResponse();

        List<Book> books = repository.searchByCriteria(criteria);

        if(!CollectionUtils.isEmpty(books)) {
            List<BookDto> bookDtos = new ArrayList<>();

            for (Book book : books) {
                bookDtos.add(mapping.dtoToEntity(book));
            }

            response.setBooks(bookDtos);
        }
        return response;
    }
}
