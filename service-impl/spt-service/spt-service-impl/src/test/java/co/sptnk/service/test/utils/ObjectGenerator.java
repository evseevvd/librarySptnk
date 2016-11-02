package co.sptnk.service.test.utils;

import co.sptnk.service.api.dto.BookDto;
import co.sptnk.service.impl.persistence.model.Book;

import java.util.Date;

/**
 * Created by evseevvd on 02.11.16.
 *
 * Генератор объектов для тестов
 */
public class ObjectGenerator {

    public static Book generatedBook(){
        Book book = new Book();
        book.setName("Book 1");
        book.setAthor("Athor Book 1");
        book.setDate(new Date());
        return book;
    }

    public static BookDto generatedBookDto(){
        BookDto bookDto = new BookDto();
        bookDto.setName("Book 1");
        bookDto.setAthor("Athor Book 1");
        bookDto.setDate(new Date());
        return bookDto;
    }
}
