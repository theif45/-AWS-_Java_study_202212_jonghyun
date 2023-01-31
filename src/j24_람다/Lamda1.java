package j24_람다;

public class Lamda1 {

	public static void main(String[] args) {
		
		Instrument instrument = new Instrument() {
			
			@Override
			public String play(String instrument) {
				return instrument + "을(를) 연주합니다.";
			}
		};
		
		Instrument instrument2 = (String itm) -> {
			return itm + "을(를) 연주합니다.";
		};
		
		// 매개변수의 자료형을 생략할 수 있다.
		// 매개변수의 이름을 바꿀 수 있다.
		Instrument instrument3 = (itm) -> {
			return itm + "을(를) 연주합니다.";
		};
		
		// 매개변수가 하나이면 매개변수를 감싸는 괄호를 생략할 수 있다.
		Instrument instrument4 = itm -> {
			return itm + "을(를) 연주합니다.";
		};
		
		// 구현부의 명령이 하나일 때 중괄호를 생략할 수 있다.
		// 이때 리턴자료형이 정해져있으면 리턴값으로 사용이 된다.
		// 중괄호를 생략하면 return을 적을 수 없음
		Instrument instrument5 = itm -> itm + "을(를) 연주합니다.";
		
		// 지역변수를 매개변수에 넣어 사용하지 않아도 바로 사용 가능
		// 지역변수명과 같은 변수명을 매개변수명으로 사용 불가
		int result = 10 + 20;
		
		Instrument instrument6 = itm -> itm + "을(를) 연주합니다." + result;
		
		System.out.println(instrument2.play("기타"));
		System.out.println(instrument.play("트럼펫"));
		System.out.println(instrument6.play("피아노"));
		
	}
}
