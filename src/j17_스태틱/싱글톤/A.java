package j17_스태틱.싱글톤;

public class A {

	private Student[] students;
	private static A instance = null;

	private A() {
		students = new Student[3];
	}

	public static A getInstance() { // 첫번째 호출 때 자기자신을 생성
		if (instance == null) {
			instance = new A();
		}
		return instance;
	}

	public void addStudent(Student student) {

		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;
				return;
			}
		}

		System.out.println("더 이상 학생을 추가할 수 없습니다.");
		System.out.println();
	}

	public void showStudents() {
		for (Student student : students) {
			System.out.println(student); // Null을 참조할수 없어서 toString을 여기선 사용불가
		}
		System.out.println();
	}
}
