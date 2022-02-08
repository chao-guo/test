package chao.json.jackson;

import chao.json.Address;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author chao.guo
 * @Date 2021/3/19 15:17
 */
public class AddressModule extends SimpleModule {
    public AddressModule() {
        this.addSerializer(new AddressSerializer(Address.class));
    }
}
