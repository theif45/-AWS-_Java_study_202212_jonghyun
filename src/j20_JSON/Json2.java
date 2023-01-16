package j20_JSON;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// JSON은 필수적인 데이터 포맷
public class Json2 {

	public static void main(String[] args) {

		Map<String, Object> map = new HashMap();

		map.put("a", "test1");
		map.put("b", 10.5);
		map.put("c", new int[] { 10, 20, 30, 40, 50 });

		System.out.println(map);
		
//		Gson 객체 생성
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String mapJson = gson.toJson(map);
		
		System.out.println(mapJson);
	}
}
 