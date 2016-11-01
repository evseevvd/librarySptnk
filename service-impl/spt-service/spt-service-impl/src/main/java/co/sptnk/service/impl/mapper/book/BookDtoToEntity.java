package co.sptnk.service.impl.mapper.book;

import co.sptnk.service.api.dto.BookDto;
import co.sptnk.service.impl.mapper.AbstractDozerMapper;
import co.sptnk.service.impl.persistence.model.Book;
import javax.inject.Named;

/**
 * Created by Владимир on 02.11.2016.
 *
 * Маппер из ДТО в сущность Книга
 */
@Named("bookDtoToEntity")
public class BookDtoToEntity extends AbstractDozerMapper<BookDto, Book> {

    public BookDtoToEntity() {
        this(Book.class, BookDto.class);
    }

    public BookDtoToEntity(Class<Book> bookClass, Class<BookDto> bookDtoClass) {
        super(bookClass, bookDtoClass);
    }

    @Override
    public BookDto map(Book book) throws IllegalAccessException, InstantiationException {
        return super.map(book);
    }

    @Override
    public BookDto map(Book book, BookDto bookDto) {
        return super.map(book, bookDto);
    }
}
