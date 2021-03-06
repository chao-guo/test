package chao.other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class test {

	static Consumer<Object> cout = System.out::println;

	public static void main(String[] args) {
		/*
		 * String aaa = "##aaa##+##bbb#aaa"; String bbb =
		 * "rmanceManager[#  第1个中括>号  ]>Product[#<2个中括号]><[第3个中括号]>79~"; String sq =
		 * " `name`= and `and`=  or ( `code`= and `age`= ) "; sq = sq.replaceAll("\\s+",
		 * " "); System.out.println(sq); String pattern = "#[0-9a-zA-Z_\\.]{1,}#?";
		 * String pattern2 = "#(.*?)#"; String pattern3 = "and|or"; Pattern p =
		 * Pattern.compile(pattern3); Matcher m = p.matcher(sq); while (m.find()) {
		 * m.group(); System.out.println(m.group()); }
		 */
		List<Integer> a = new ArrayList<Integer>();
		markList1(a, 10);
		a.forEach(System.out::println);

		Student student = new Student("gc", 1);
		cout.accept("student:" + student);
		new test().aaa(student, "aaa");
		cout.accept("student:" + student);

		Set<String> s = new TreeSet<>(new test().new CaseInsensitiveCompare());
		s.add("Hello");
		s.add("HeLLo");
		cout.accept(s.size());

		Class<?> superclass = a.getClass().getSuperclass();
		System.out.println(superclass);
	}

	public static <E> void markList1(List<Integer> lst, int n) {
		lst.clear();
		for (int i = 0; i < n; i++) {
			lst.add(i);
		}
	}

	class CaseInsensitiveCompare implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o1.compareToIgnoreCase(o2);
		}
	}

	public void aaa(Student student, String name) {
		updateName(student, name);
	}

	public void updateName(Student student, String name) {
		student.setName(name);
	}
}
