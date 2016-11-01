package co.sptnk.service.impl.mapper.book;

import co.sptnk.service.api.dto.BookDto;
import co.sptnk.service.impl.persistence.model.Book;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Владимир on 02.11.2016.
 */
public class BookMappingImpl implements BookMapping {

    @Inject
    @Named("bookDtoToEntity")
    private BookDtoToEntity bookDtoToEntity;

    @Inject
    @Named("bookEntityToDto")
    private BookEntityToDto bookEntityToDto;

    @Override
    public Book entityToDto(BookDto dto) throws InstantiationException, IllegalAccessException {
        return bookEntityToDto.map(dto);
    }

    @Override
    public BookDto dtoToEntity(Book entity) throws InstantiationException, IllegalAccessException {
        return bookDtoToEntity.map(entity);
    }

}
