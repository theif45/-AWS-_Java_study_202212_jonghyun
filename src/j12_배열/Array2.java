package j12_배열;

public class Array2 {

	public static void printNames(String[] names) {
		for (int i = 0; i < names.length; i++) {
			System.out.println("이름[" + (i + 1) + "] : " + names[i]);
		}

		System.out.println();
	}

	public static void main(String[] args) {
//		들어갈 값이 정해지지 않았을 때, 들어갈 공간이 확실할 경우
		String[] names = new String[3];

		names[0] = "김상현";
		names[1] = "임나영";
		names[2] = "김종환";

		String[] names2 = new String[] { "이상현", "손지호", "이강용" };

		String[] names3 = { "김두영", "강대협", "이현수", "김재영" };

		printNames(names);
		printNames(new String[] { "이상현", "손지호", "이강용" });
		printNames(names3);
	}

}