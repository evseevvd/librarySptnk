package co.sptnk.rest.config;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * Created by Владимир on 03.11.2016.
 */
public class CustomDateSerializer extends JsonSerializer<Date> {

    private static final String DATE_FORMAT = "dd.MM.yyyy";

    @Override
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeString(new SimpleDateFormat(DATE_FORMAT).format(value));
    }
}