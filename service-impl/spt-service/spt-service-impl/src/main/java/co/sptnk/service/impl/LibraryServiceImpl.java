package co.sptnk.service.impl;

import co.sptnk.service.api.LibraryService;
import co.sptnk.service.api.dto.BookDto;
import co.sptnk.service.api.dto.criteria.SearchCriteriaBook;
import co.sptnk.service.api.dto.response.AddOrUpdateResponse;
import co.sptnk.service.api.dto.response.DeleteResponse;
import co.sptnk.service.api.dto.response.FindResponse;
import co.sptnk.service.impl.mapper.book.BookMapping;
import javax.inject.Inject;
import javax.persistence.Id;

/**
 * Created by Владимир on 01.11.2016.
 *
 * Имплементация сервиса
 */
public class LibraryServiceImpl implements LibraryService {

    @Inject
    private BookMapping mapping;

    @Override
    public AddOrUpdateResponse addOrUpdateBook(BookDto bookDto) {
        return null;
    }

    @Override
    public DeleteResponse deleteBook(BookDto bookDto) {
        return null;
    }

    @Override
    public FindResponse getBook(String id) {
        return null;
    }

    @Override
    public FindResponse findBooks(SearchCriteriaBook criteria) {
        return null;
    }
}
