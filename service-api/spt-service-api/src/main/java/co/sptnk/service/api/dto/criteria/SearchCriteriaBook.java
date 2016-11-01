package co.sptnk.service.api.dto.criteria;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Владимир on 01.11.2016.
 *
 * критерий поиска книги
 */
public class SearchCriteriaBook implements Serializable {

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
