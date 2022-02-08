package chao.json.jackson;

import chao.json.Address;
import chao.json.Car;
import chao.json.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import pcitc.imp.common.ettool.utils.RestfulTool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chao.guo
 * @Date 2021/3/18 14:32
 */
public class Test {

    public static void main(String[] args) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Address address = new Address("gc", "sx");
            String s1 = "";
            List<Car> carList = new ArrayList<>();
            carList.add(new Car("a", "BMW"));
            carList.add(new Car("b", "HW"));
            carList.add(new Car("c", "LK"));

            Person person = new Person();
            person.setName("gc");
            person.setAddress(address);
            person.setCardId(1);
            person.setCars(carList);
//            String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
//            System.out.println(s);
//            Person person1 = objectMapper.readValue(s, Person.class);
//            System.out.println(person1);

//            s1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
//            System.out.println(s1);
//            objectMapper.registerModule(new AddressModule());
//            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            SimpleModule mod = new SimpleModule("Address Module");
            mod.addSerializer(new AddressSerializer(Address.class));
            objectMapper.registerModule(mod);
            s1 = objectMapper.writeValueAsString(address);
            System.out.println(s1);

            List<Address> addresses = new ArrayList<>();
            addresses.add(address);
            String buildCollection = RestfulTool.buildCollection(addresses, "/address", Address.class);
            System.out.println(buildCollection);
            List<Person> personList = new ArrayList<>();
            personList.add(person);
            buildCollection = RestfulTool.buildCollection(personList, "/address", Person.class);
            System.out.println(buildCollection);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
