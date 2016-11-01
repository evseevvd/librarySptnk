package co.sptnk.service.impl.mapper;

import co.sptnk.service.impl.mapper.configure.BeanMappingConfigure;
import org.dozer.DozerBeanMapper;

/**
 * Created by Владимир on 02.11.2016.
 *
 * Абстрактная имплемнентация маппера
 */
public abstract class AbstractDozerMapper<TO, FROM> implements DozerMapping<TO, FROM> {

    private Class<FROM> fromClass;
    private Class<TO> toClass;

    private DozerBeanMapper beanMapper;

    public AbstractDozerMapper(Class<FROM> fromClass, Class<TO> toClass){
        this.fromClass = fromClass;
        this.toClass = toClass;
        this.beanMapper = getBeanMapper();

    }

    @Override
    public TO map(FROM from) throws IllegalAccessException, InstantiationException {
        TO destinations = toClass.newInstance();
        beanMapper.map(from, destinations);
        return destinations;
    }

    public TO map(FROM from, TO to) {
        beanMapper.map(from, to);
        return to;
    }

    private DozerBeanMapper getBeanMapper() {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.addMapping(new BeanMappingConfigure(fromClass, toClass));
        return dozerBeanMapper;
    }
}
