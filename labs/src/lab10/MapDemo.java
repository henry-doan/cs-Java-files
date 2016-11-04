package lab10;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("cat");
		list.add("ant");
		list.add("dog");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		TreeMap<String, String> map = new TreeMap<String, String>();
		
		map.put("Doan", "Henry");
		map.put("bedi", "Master");
		map.put("Road", "Rocky");
		
		System.out.println(map.get("Doan"));
		System.out.println(map.get("this"));
		
		for(String s : map.keySet()) {
			System.out.println(s);
		}
		
		LinkedHashMap<String, String> map2 = new LinkedHashMap<String, String>();
		
		
		
	}

}
