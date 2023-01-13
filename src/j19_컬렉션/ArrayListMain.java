package j19_컬렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListMain {
	
	/**
	 * 
	 * CRUD
	 * 
	 * C reate
	 * R ead
	 * U pdate
	 * D elete
	 * 
	 */
	public static void main(String[] args) {
		
//		항상 업캐스팅하여 사용함
		List<String> strList = new ArrayList<>();
		
//		*값 추가
		strList.add("java");
		strList.add("python");
		System.out.println(strList);
		
//		값 원하는 위치에 추가
		strList.add(1, "android");
		System.out.println(strList);
		
//		*해당 인덱스의 값을 추출
		System.out.println(strList.get(0));
		String lang = strList.get(1);
		System.out.println(lang);
		
//		리스트에 해당 값이 있는지 확인(T, F)
		System.out.println(strList.contains("c++"));
		System.out.println(strList.contains(lang));
		
//		값 수정
		strList.set(2, "javascript");
		System.out.println(strList);
		
//		*값 삭제
		strList.remove("android");
		System.out.println(strList);
		strList.remove(1);
		System.out.println(strList);
		
//		*리스트의 크기 확인
		System.out.println(strList.size());
		
//		리스트가 비었는지 확인
		System.out.println(strList.isEmpty());
		
//		리스트 초기화
		strList.clear();
		System.out.println(strList.isEmpty());
		
		/*
		 * *배열을 리스트로 변환
		 * Arrays.asList(배열);
		 */
		String[] langs = {"java", "c++", "python", "javascript"};
		List<String> tempList = Arrays.asList(langs);
		strList.addAll(tempList);
		strList.addAll(2, tempList);
		System.out.println(strList);
		
//		*해당 값의 위치(index) 왼쪽부터 찾기
		int findIndexLeft = strList.indexOf("python");
		System.out.println(findIndexLeft);
		
//		*해당 값의 위치(index) 오른쪽부터 찾기
		int findIndexRight = strList.lastIndexOf("java");
		System.out.println(findIndexRight);
		
//		========================================================
		
		strList.set(1, "java");
		System.out.println(strList);
		strList.subList(strList.indexOf("java") + 1, strList.size()).indexOf("java");
		
		
//		========================================================
//		fromIndex부터 toIndex전까지 리스트를 추출
		List<String> subList = strList.subList(1, 4);
		System.out.println(subList);
		System.out.println();
		
//		================반복================
//		일반 반복문
		for (int i = 0; i < strList.size(); i++) {
			System.out.println("[" + i + "] : " + strList.get(i));
		}
		System.out.println();
		
//		forEach
		for (String str : strList) {
			System.out.println("[값]" + str);
		}
		
//		람다식 forEach
		strList.forEach(str -> System.out.println("[값2] : " + str));
		System.out.println();
		
//		반복자
		Iterator<String> iterator = strList.iterator();
//		iterator의 다음 값이 있는지 확인하는 것이 hasNext
//		한 번 실행하여 값을 다 꺼내면 안에 데이터가 없으므로 일회용으로 사용
		while(iterator.hasNext()) {
//			iterator의 다음 값을 꺼내 반환하는 것이 next
			String lang2 = iterator.next();
			System.out.println("[값3] : " + lang2);
		}
		
//		다시 사용하기 위해서는 다시 대입하여 사용
		iterator = strList.iterator();
		while(iterator.hasNext()) {
			String lang2 = iterator.next();
			System.out.println("[값3] : " + lang2);
		}
	}
}
