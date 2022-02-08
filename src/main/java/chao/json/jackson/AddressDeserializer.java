package chao.json.jackson;

import chao.json.Address;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * @author chao.guo
 * @Date 2021/3/19 15:26
 */
public class AddressDeserializer extends StdDeserializer<Address> {

    public AddressDeserializer() {
        super(Address.class);
    }

    public AddressDeserializer(Class<Address> t) {
        super(t);
    }

    @Override
    public Address deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        System.out.println(jsonParser);
        return null;
    }

}
