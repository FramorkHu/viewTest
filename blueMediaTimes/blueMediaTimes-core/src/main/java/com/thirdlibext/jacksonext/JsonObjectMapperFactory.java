package com.thirdlibext.jacksonext;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.deser.CustomDeserializerFactory;
import org.codehaus.jackson.map.deser.StdDeserializerProvider;
import org.codehaus.jackson.map.ext.JodaDeserializers;
import org.joda.time.DateTime;

/**
 * Created by huyan on 15/5/5.
 */
public class JsonObjectMapperFactory {

    private JodaDeserializers.DateTimeDeserializer dateTimeDeserializer;

    public JsonObjectMapperFactory() {
    }

    public void setDateTimeDeserializer(JodaDeserializers.DateTimeDeserializer dateTimeDeserializer) {
        this.dateTimeDeserializer = dateTimeDeserializer;
    }

    public ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, true);
        mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CustomDeserializerFactory sf = new CustomDeserializerFactory();
        mapper.setDeserializerProvider(new StdDeserializerProvider(sf));
        if(this.dateTimeDeserializer == null) {
            this.dateTimeDeserializer = new OffsetHoursDateTimeDeserializer(DateTime.class);
        }

        sf.addSpecificMapping(DateTime.class, this.dateTimeDeserializer);
        return mapper;
    }

}
