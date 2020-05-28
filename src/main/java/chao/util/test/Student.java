package chao.util.test;

/**
 * @author g.c
 * @date 2020年5月27日下午7:39:01
 **/
public class Student implements Comparable<Student>{

	private String name;

	private int age;

	protected Student() {
		super();
	}

	protected Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.age - o.age;
	}

}
