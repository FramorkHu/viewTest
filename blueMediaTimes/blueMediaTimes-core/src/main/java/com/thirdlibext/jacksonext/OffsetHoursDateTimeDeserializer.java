package com.thirdlibext.jacksonext;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.ext.JodaDeserializers;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.IOException;

/**
 * Created by huyan on 15/5/5.
 */
public class OffsetHoursDateTimeDeserializer  extends JodaDeserializers.DateTimeDeserializer {

    private Integer offsetHours;

    public OffsetHoursDateTimeDeserializer(Class cls) {
        super(cls);
    }

    public Integer getOffsetHours() {
        return this.offsetHours;
    }

    public void setOffsetHours(Integer offsetHours) {
        this.offsetHours = offsetHours;
    }

    public DateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonToken t = jp.getCurrentToken();
        DateTimeZone zone = DateTimeZone.getDefault();
        if(this.offsetHours != null) {
            zone = DateTimeZone.forOffsetHours(this.offsetHours.intValue());
        }

        if(t == JsonToken.VALUE_NUMBER_INT) {
            return new DateTime(jp.getLongValue(), zone);
        } else if(t == JsonToken.VALUE_STRING) {
            return new DateTime(jp.getText().trim(), zone);
        } else {
            throw ctxt.mappingException(this.getValueClass());
        }
    }

}
