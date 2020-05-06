package chao.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	public static void main(String[] args) {
		String aaa = "##aaa##+##bbb#aaa";
		String bbb = "rmanceManager[#  第1个中括>号  ]>Product[#<2个中括号]><[第3个中括号]>79~";
		String sq = " `name`= and `and`=  or ( `code`= and `age`= ) ";
		sq = sq.replaceAll("\\s+", " ");
		System.out.println(sq);
		String pattern = "#[0-9a-zA-Z_\\.]{1,}#?";
		String pattern2 = "#(.*?)#";
		String pattern3 = "and|or";
		Pattern p = Pattern.compile(pattern3);
		Matcher m = p.matcher(sq);
		while (m.find()) {
			m.group();
			System.out.println(m.group());
		}
	}
}
