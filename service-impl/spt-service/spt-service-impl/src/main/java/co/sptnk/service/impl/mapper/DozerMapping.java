package co.sptnk.service.impl.mapper;

/**
 * Created by Владимир on 02.11.2016.
 *
 * мапер
 */
public interface DozerMapping<TO, FROM> {

    TO map(FROM from) throws IllegalAccessException, InstantiationException;

    TO map(FROM from, TO to);
}
