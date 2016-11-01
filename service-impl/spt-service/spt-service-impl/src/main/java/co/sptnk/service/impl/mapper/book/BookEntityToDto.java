package co.sptnk.service.impl.mapper.book;

import co.sptnk.service.api.dto.BookDto;
import co.sptnk.service.impl.mapper.AbstractDozerMapper;
import co.sptnk.service.impl.persistence.model.Book;
import javax.inject.Named;

/**
 * Created by Владимир on 02.11.2016.
 *
 * Маппер из сущности в ДТО Книга
 */
@Named("bookEntityToDto")
public class BookEntityToDto extends AbstractDozerMapper<Book, BookDto> {

    public BookEntityToDto(){
        this(BookDto.class, Book.class);
    }

    public BookEntityToDto(Class<BookDto> bookDtoClass, Class<Book> bookClass) {
        super(bookDtoClass, bookClass);
    }

    @Override
    public Book map(BookDto bookDto) throws IllegalAccessException, InstantiationException {
        return super.map(bookDto);
    }

    @Override
    public Book map(BookDto bookDto, Book book) {
        return super.map(bookDto, book);
    }
}
