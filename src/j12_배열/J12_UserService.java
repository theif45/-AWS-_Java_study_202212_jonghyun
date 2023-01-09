package j12_배열;

import java.lang.module.FindException;
import java.util.Scanner;

// 비즈니스 로직 //기능을 가지고 있는 클래스
public class J12_UserService {

	private Scanner scanner;
	private J12_UserRepository userRepository;

//	결합도가 낮은 코드
//	public J12_UserService(Scanner scanner) {
//		this.scanner = scanner;// 변수에서 바로 선언하게되게 하면 컴파일 시 자동으로 생성되게 때문(사용하지 않았을 경우 메모리 소모)
//	}

	// 결합도가 높은 코드
	public J12_UserService(J12_UserRepository userRepository) {
		scanner = new Scanner(System.in); // 생성되었을 때 선언
		this.userRepository = userRepository;
	}

	public void run() {
		boolean loopFlag = true;
		char select = '\0';

		while (loopFlag) {
			showMainMenu();
			select = inputSelect("메인 ");
			loopFlag = mainMenu(select);
		}

	}

	public void stop() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println("프로그램 종료중...(" + (i + 1) + "/10)");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
	}

	private char inputSelect(String menuName) {
		System.out.print(menuName + "메뉴 선택 : ");
		char select = scanner.next().charAt(0);
		scanner.nextLine(); // 버퍼 비워줌
		return select;
	}

	private void showMainMenu() {
		System.out.println("========<< 메인메뉴 >>========");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 등록");
		System.out.println("3. 사용자 이름으로 회원 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("==============================");
		System.out.println("q. 프로그램 종료");
		System.out.println();
	}

	private void showUsers() {
		J12_User[] users = userRepository.getUserTable();

		System.out.println("========<< 회원 전체 조회 >>========");

		for (J12_User user : users) {
			System.out.println(user.toString());
		}

		System.out.println("====================================");
	}

	private void registerUser() {
		J12_User user = new J12_User();

		System.out.println("========<< 회원 등록 >>========");
		System.out.print("사용자이름 : ");
		user.setUsername(scanner.nextLine());

		System.out.print("비밀번호 : ");
		user.setPassword(scanner.nextLine());

		System.out.print("성명 : ");
		user.setName(scanner.nextLine());

		System.out.print("이메일 : ");
		user.setEmail(scanner.nextLine());

		userRepository.saveUser(user);
	}

	private void showUser() {
		J12_User user = null;

		System.out.println("========<< 회원 조회 >>========");
		user = verifyUsername();

		if (user == null) {
			System.out.println("존재하지 않는 사용자이름입니다.");
			return;
		}

		System.out.println(user.toString());
		System.out.println("===============================");
	}

	private void updateUser() {
		J12_User user = verifyUsername();
		if (user == null) {
			System.out.println("존재하지 않는 사용자이름입니다.");
			return;
		}

		boolean loopFlag = true;
		char select = '\0';

		while (loopFlag) {
			showUpdateMenu(user);
			select = inputSelect("수정");
			loopFlag = updateMenu(user, select);
		}
	}

	private void showUpdateMenu(J12_User user) {
		System.out.println("========<< 수정 메뉴 >>========");
		System.out.println("사용자 이름 : " + user.getUsername());
		System.out.println("===============================");
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 이름 변경");
		System.out.println("3. 이메일 변경");
		System.out.println("===============================");
		System.out.println("b. 뒤로가기");
		System.out.println();
	}

	private void updatePassword(J12_User user) {
		String oldPassword = null;
		String newPassword = null;
		String confirmPassword = null;

		System.out.println("========<< 비밀번호 변경 >>========");

		System.out.print("기존 비밀번호 입력 : ");
		oldPassword = scanner.nextLine();

		if (!comparePassword(user.getPassword(), oldPassword)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}

		System.out.println("새로운 비밀번호 입력 : ");
		newPassword = scanner.nextLine();
		System.out.println("새로운 비밀번호 확인 : ");
		confirmPassword = scanner.nextLine();

		if (!comparePassword(newPassword, confirmPassword)) {
			System.out.println("새로운 비밀번호가 서로 일치하지 않습니다.");
			return;
		}

		user.setPassword(newPassword);
		System.out.println("비밀번호 변경 완료.");
	}

	private boolean comparePassword(String prePassword, String nextPassword) {
		return prePassword.equals(nextPassword);
	}

	private boolean mainMenu(char select) {
		boolean flag = true;

		if (isExit(select)) {
			flag = false;

		} else {
			if (select == '1') {
				showUsers();
			} else if (select == '2') {
				registerUser();
			} else if (select == '3') {
				showUser();
			} else if (select == '4') {
				updateUser();
			} else {
				System.out.println(getSelectedErrorMessage());
			}

			System.out.println();
		}
		return flag;
	}

	private boolean updateMenu(J12_User user, char select) {
		boolean flag = true;

		if (isBack(select)) {
			flag = false;

		} else {
			if (select == '1') {
				updatePassword(user);
			} else if (select == '2') {
				
			} else if (select == '3') {
				
			} else {
				System.out.println(getSelectedErrorMessage());
			}
		}
		System.out.println();

		return flag;
	}

	// 리팩토링 기법
	private boolean isExit(char select) {
		return select == 'q' || select == 'Q';
	}

	private boolean isBack(char select) {
		return select == 'b' || select == 'B';
	}

	// 후에 잘못된 부분 수정을 위해 return함
	private String getSelectedErrorMessage() {
		return "###<< 잘못된 입력입니다. 다시 입력하세요. >>###";
	}

	private J12_User verifyUsername() {
		String username = null;
		System.out.print("사용자이름 : ");
		username = scanner.nextLine();
		return userRepository.findUserByUsername(username);
	}

}
