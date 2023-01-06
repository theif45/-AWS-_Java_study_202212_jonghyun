package j07_반복;

import java.util.Scanner;

public class While3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String select = null;
		
		while(true) {
			System.out.print("x입력시 멈춤 : ");
			select = scanner.nextLine();
			
			if (select.equals("x") || select.equals("X")) { // 문자열은 equals를 사용하여 같은지 확인
				System.out.println("프로그램을 멈춥니다.");
				break;
			}
			
			System.out.println("계속 실행!");
		}
		
		System.out.println("프로그램 종료됨.");
	}

}
