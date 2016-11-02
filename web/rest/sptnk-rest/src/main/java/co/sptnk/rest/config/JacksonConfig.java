package co.sptnk.rest.config;

import java.util.Calendar;
import java.util.Date;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.module.SimpleModule;

/**
 * Created by Владимир on 03.11.2016.
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonConfig implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper;

    public JacksonConfig() {
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.enable(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING);
        objectMapper.enable(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING);

        SimpleModule simpleModule = new SimpleModule("DateDeserializationModule", new Version(1,0,0,null));
        simpleModule.addDeserializer(Date.class, new CustomDateDeserializer());
        simpleModule.addSerializer(Date.class, new CustomDateSerializer());
        objectMapper.registerModule(simpleModule);
    }


    @Override
    public ObjectMapper getContext(Class type) {
        return objectMapper;
    }
}
