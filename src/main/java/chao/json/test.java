package chao.json;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import net.sf.json.JSONArray;

public class test {

	public static void main(String[] args) {
		Address address = new Address();
		address.setName("陕西");
		address.setLocation("中国");
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car("1", "A"));
		cars.add(new Car("2", "B"));
		Person person = new Person();
		person.setName("红");
		person.setCardId(1);
		person.setAddress(address);
		person.setCars(cars);
//		JSONArray fromObject1 = JSONArray.fromObject(person);
//		System.out.println(fromObject1);
//		String a = "[{\"address\":{\"location\":\"中国\",\"name\":\"陕西\"},\"cardId\":1,\"cars\":[{\"brand\":\"A\",\"name\":\"1\"},{\"brand\":\"B\",\"name\":\"2\"}],\"name\":\"红\"}]\r\n" + 
//				"";
		String jsonString = JSON.toJSONString(person);
		System.out.println(jsonString);
		String a = "{\"address\":{\"location\":\"中国\",\"name\":\"陕西\"},\"cardId\":1,\"cars\":[{\"brand\":\"A\",\"name\":\"1\"},{\"brand\":\"B\",\"name\":\"2\"}],\"name\":\"红\"}\r\n" + 
				"";
		Person parseObject = JSON.parseObject(a,Person.class);
		System.out.println(a);
	}
}
