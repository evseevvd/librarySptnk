package co.sptnk.service.impl.persistence.model;

import co.sptnk.service.impl.listener.PrePersistBook;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Владимир on 01.11.2016.
 *
 * Сущность книга
 */

@Entity
@Table(name = "BOOKS", schema = "LIBSM")
@EntityListeners({PrePersistBook.class})
public class Book {

    /**
     * Код книги
     */
    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    /**
     * Название книги
     */
    @Column(name = "NAME", nullable = false, length = 200)
    private String name;

    /**
     * Автор книги
     */
    @Column(name = "ATHOR", nullable = false, length = 64)
    private String athor;

    /**
     * Дата выхода книги
     */
    @Column(name = "DATE_BOOK", nullable = false)
    private Date date;

    /**
     * Каталог (открытый или закрытый)
     */
    @Column(name = "CLOSE")
    private Boolean isClose;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAthor() {
        return athor;
    }

    public void setAthor(String athor) {
        this.athor = athor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getClose() {
        return isClose;
    }

    public void setClose(Boolean close) {
        isClose = close;
    }
}
