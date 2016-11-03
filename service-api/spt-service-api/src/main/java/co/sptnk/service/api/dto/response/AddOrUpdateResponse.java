package co.sptnk.service.api.dto.response;

import co.sptnk.service.api.dto.AbstractResponse;
import co.sptnk.service.api.dto.BookDto;

/**
 * Created by Владимир on 01.11.2016.
 */
public class AddOrUpdateResponse extends AbstractResponse {

    private BookDto book;

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
        this.book = book;
    }
}
