package co.sptnk.service.api.dto.response;

import co.sptnk.service.api.dto.BookDto;
import co.sptnk.service.api.dto.AbstractResponse;
import java.util.List;

/**
 * Created by Владимир on 01.11.2016.
 * Ответ поиска
 */
public class FindResponse extends AbstractResponse {

    /**
     * Список найденных книг
     */
    private List<BookDto> books;

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }
}
