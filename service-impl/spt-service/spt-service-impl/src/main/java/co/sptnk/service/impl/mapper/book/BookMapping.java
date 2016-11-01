package co.sptnk.service.impl.mapper.book;

import co.sptnk.service.api.dto.BookDto;
import co.sptnk.service.impl.persistence.model.Book;

/**
 * Created by Владимир on 02.11.2016.
 */
public interface BookMapping {

    Book entityToDto(BookDto dto) throws InstantiationException, IllegalAccessException;

    BookDto dtoToEntity(Book entity) throws InstantiationException, IllegalAccessException;
}
