package co.sptnk.service.api;

import co.sptnk.service.api.dto.BookDto;
import co.sptnk.service.api.dto.criteria.SearchCriteriaBook;
import co.sptnk.service.api.dto.response.AddOrUpdateResponse;
import co.sptnk.service.api.dto.response.FindResponse;

/**
 * Created by Владимир on 01.11.2016.
 *
 * Сервис для работы с каталогом книг
 */
public interface LibraryService {

    AddOrUpdateResponse addOrUpdateBook(BookDto bookDto) throws IllegalAccessException, InstantiationException;

    void deleteBook(BookDto bookDto) throws IllegalAccessException, InstantiationException;

    FindResponse getBook(String id) throws IllegalAccessException, InstantiationException;

    FindResponse findBooks(SearchCriteriaBook criteria) throws IllegalAccessException, InstantiationException;
}
