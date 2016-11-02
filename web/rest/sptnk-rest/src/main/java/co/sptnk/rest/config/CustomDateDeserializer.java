package co.sptnk.rest.config;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;

/**
 * Created by Владимир on 03.11.2016.
 */
public class CustomDateDeserializer  extends JsonDeserializer<Date> {

    private static final String DATE_TEMPLATE = "dd.MM.yyyy";

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        try {
            String stringDate = jp.getText();
            if(stringDate != null) {
                return new SimpleDateFormat(DATE_TEMPLATE).parse(stringDate);
            } else {
                return null;
            }
        } catch (ParseException e) {
            throw new JsonMappingException("Unable to parse date");
        }
    }
}