package chao.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pcitc.imp.common.ettool.baseresrep.BaseResRep;

import java.io.Serializable;

public class Address extends BaseResRep implements Serializable {

    private String name;

    private String location;

    public Address() {
    }

    public Address(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
