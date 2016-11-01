package co.sptnk.service.impl.mapper.configure;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;

/**
 * Created by Владимир on 02.11.2016.
 *
 * класс настроек для маппера
 */
public class BeanMappingConfigure extends BeanMappingBuilder {

    private Class from;
    private Class to;

    public BeanMappingConfigure(Class from, Class to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected void configure() {
        mapping(from, to, TypeMappingOptions.oneWay());
    }
}
