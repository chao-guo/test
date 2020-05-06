package chao.design_pattern.factorymethod;

/**
 * @author g.c
 * @date 2020年5月4日下午2:00:03
 **/
public class AbstractFactoryTest {
	public static void main(String[] args) {
        Product a;
        AbstractFactory af;
		af = (AbstractFactory) ReadXML1.getObject();
        a=af.newProduct();
        a.show();
	}
}

//抽象产品
interface Product {
	public void show();
}

//具体产品1
class ConcreteProduct1 implements Product {
	@Override
	public void show() {
		System.out.println("产品1展示");
	}
}

//具体产品1
class ConcreteProduct2 implements Product {
	@Override
	public void show() {
		System.out.println("产品2展示");
	}
}

//抽象工厂
interface AbstractFactory {
	public Product newProduct();
}

//具体工厂1
class ConcreteFactory1 implements AbstractFactory {
	@Override
	public Product newProduct() {
		System.out.println("具体工厂1生成-->具体产品1...");
		return new ConcreteProduct1();
	}
}

//具体工厂2
class ConcreteFactory2 implements AbstractFactory {
	public Product newProduct() {
		System.out.println("具体工厂2生成-->具体产品2...");
		return new ConcreteProduct2();
	}
}