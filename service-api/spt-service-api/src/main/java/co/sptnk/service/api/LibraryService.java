package co.sptnk.service.api;

import co.sptnk.service.api.dto.BookDto;
import co.sptnk.service.api.dto.criteria.SearchCriteriaBook;
import co.sptnk.service.api.dto.response.AddOrUpdateResponse;
import co.sptnk.service.api.dto.response.DeleteResponse;
import co.sptnk.service.api.dto.response.FindResponse;

/**
 * Created by Владимир on 01.11.2016.
 *
 * Сервис для работы с каталогом книг
 */
public interface LibraryService {

    AddOrUpdateResponse addOrUpdateBook(BookDto bookDto);

    DeleteResponse deleteBook(BookDto bookDto);

    FindResponse getBook(String id);

    FindResponse findBooks(SearchCriteriaBook criteria);
}
