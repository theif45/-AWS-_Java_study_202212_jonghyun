package j17_스태틱;

public class StudentMain {

	public static void main(String[] args) {

		Student[] students = new Student[5];
		Teacher[] teachers = new Teacher[5];

		students[0] = new Student("이현수");
		students[1] = new Student("김재영");
		students[2] = new Student("이상현");
		students[3] = new Student("박성진");
		students[4] = new Student("윤선영");

		teachers[0] = new Teacher("김준일1");
		teachers[1] = new Teacher("김준일2");
		teachers[2] = new Teacher("김준일3");
		teachers[3] = new Teacher("김준일4");
		teachers[4] = new Teacher("김준일5");

		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
			System.out.println(teachers[i]);
			System.out.println();
		}

//		하나의 배열을 출력시 foreach가 사용하기 좋음
		int j = 0;
		for (Student student : students) {
			System.out.println(student);
			System.out.println(teachers[j]);
			System.out.println();
			j++;

		}

		System.out.println(Student.getAutoIncrement());
	}
}
