package j12_배열;

// 저장소 //Entity + 비즈니스 로직
public class J12_UserRepository {
	private J12_User[] userTable;

	public J12_UserRepository(J12_User[] userTable) {
		this.userTable = userTable;
	}

	// 외부로 가져가기 위해 getter 작성
	public J12_User[] getUserTable() {
		return userTable;
	}

	public void saveUser(J12_User user) {
		extendArrayOne();
		userTable[userTable.length - 1] = user;
	}

	private void extendArray(int length) {
		J12_User[] newArray = new J12_User[userTable.length + length];
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
	}

	private void extendArrayOne() {
		J12_User[] newArray = new J12_User[userTable.length + 1];
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
	}

	private void transferDataToNewArray(J12_User[] oldArray, J12_User[] newArray) {
		for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}

}
