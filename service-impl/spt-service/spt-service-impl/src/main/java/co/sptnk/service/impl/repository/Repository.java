package co.sptnk.service.impl.repository;

import java.io.Serializable;

/**
 * Created by evseevvd on 02.11.16.
 *
 */

public interface Repository<E extends Serializable> {

    E create(E entity);

    E update(E entity);

    E read(Serializable id);

    void remove(E entity);

    void flush();

    void clear();

    void refresh(E entity);
}
