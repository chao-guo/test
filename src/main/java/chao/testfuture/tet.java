package chao.testfuture;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSONArray;

public class tet {
	public static void main(String[] args) throws IOException {
		String a = "E://Git//rtdbdrawservice//src//main//config//";
		File file = new File(a + "mmtagconfig.json");
		List<TagInfo> tagInfos = JSONArray.parseArray(FileUtils.readFileToString(file,"UTF-8"), TagInfo.class);
		System.out.println(tagInfos.size());
	}
}
