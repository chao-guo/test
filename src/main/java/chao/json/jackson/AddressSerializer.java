package chao.json.jackson;

import chao.json.Address;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * @author chao.guo
 * @Date 2021/3/18 16:01
 */
public class AddressSerializer extends StdSerializer<Address> {

    public AddressSerializer() {
        super(Address.class);
    }

    public AddressSerializer(Class<Address> t) {
        super(t);
    }

    @Override
    public void serialize(Address address, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", "[" + address.getName() + "]");
        jsonGenerator.writeStringField("location", address.getName() + ":" + address.getLocation());
        jsonGenerator.writeEndObject();
    }
}
