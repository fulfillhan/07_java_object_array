package step7_01.objectArray;

import java.util.Scanner;

class User01{
	
	String id;
	int money;
}

public class ObjectArrayEx04_연습풀이 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		User01[] userList = new User01[100];// 100개라는 클래스의 크기 지정..
		
		for (int i = 0; i < userList.length; i++) {
			userList[i] = new User01();
		}
		User temp = new User();
		
		while (true) {
			
			System.out.println("1.회원가입");
			System.out.println("2.탈퇴");
			System.out.println("3.출력");
			System.out.println("4.종료");
			System.out.print("번호를 선택하세요 : ");
			int sel = scan.nextInt();
			
		
			if (sel == 1) {
				
			}
			else if (sel == 2) {
				
			}
			else if (sel == 3) {
				
			}
			else if (sel == 4) {
				System.out.println("==종료===");
				scan.close();
				break;
			}
		}
		

	}

}
