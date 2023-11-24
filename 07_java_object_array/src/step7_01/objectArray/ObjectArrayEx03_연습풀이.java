package step7_01.objectArray;

class Account01{
	String id;
	int money;
	
}

public class ObjectArrayEx03_연습풀이 {
	
	public static void main(String[] args) {
		
		Account[] accountList = new Account[2];
		
		for (int i = 0; i < accountList.length; i++) {
			accountList[i] = new Account();
		}
		
		accountList[0].id = "fulfill1234";
		accountList[0].money = 1000;
		
		accountList[1].id = "fulfill5678";
		accountList[1].money = 2000;
		
		for (int i = 0; i < accountList.length; i++) {
			System.out.println(accountList[i].id+ " "+ accountList[i].money);
		}
		System.out.println("\n============================\n");
		Account temp = accountList[1];
		temp.id = "tkdgml1234";
		
		for (int i = 0; i < accountList.length; i++) {
			System.out.println(accountList[i].id+ " " + accountList[i].money);
		}
	}

}
