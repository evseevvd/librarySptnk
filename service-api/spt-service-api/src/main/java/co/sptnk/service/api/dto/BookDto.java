package co.sptnk.service.api.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Владимир on 01.11.2016.
 *
 * ДТО Книга
 */
public class BookDto implements Serializable {

    /**
     * Код книги
     */
    private String id;

    /**
     * Название книги
     */
    private String name;

    /**
     * Автор книги
     */
    private String athor;

    /**
     * Дата выхода книги
     */
    private Date date;

    /**
     * Каталог (открытый или закрытый)
     */
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

    public Boolean getClose() {
        return isClose;
    }

    public void setClose(Boolean close) {
        isClose = close;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
