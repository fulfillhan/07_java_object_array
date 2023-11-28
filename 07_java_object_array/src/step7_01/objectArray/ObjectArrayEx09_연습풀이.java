package step7_01.objectArray;

import java.util.Scanner;

class StudentEx01 {
	String id;
	String pw;
	
	//출력 메서드
	void printData() {
		System.out.println("아이디 : "+ id + "비밀번호 : "+ pw);
	}
	
}

class Controller01{
	
	//StudentEx01의 클래스 배열 선언
	StudentEx01[] list = null;
	int studCnt = 0;
	
	//아이디 확인 유효성 확인 기능 메서드
	int checkId(StudentEx01 st) {           //하단에서 입력한 id 값을  비교한다.
		int check = -1;
		for (int i = 0; i <studCnt; i++) {
			if (list[i].id.equals(st.id)) { // 문자열 비교
				check = i;                  // 동일하다면 check = i로 업데이트한다.
				break;                      // 해당문 빠져나오기
			}
		}
		return check;
	}
	
	//가입한 학생 추가하기 메서드
	void addStudentEx01(StudentEx01 st) {
		
		if (studCnt == 0) {
			list = new StudentEx01[1];           // 1의 크기로 초기화
		}
		else if (studCnt > 0) {
			StudentEx01[] temp = list;           //배열의 크기가 달라져서 임시배열 생성
			list = new StudentEx01[studCnt + 1]; //배열의 위치값 +1 로 재생성한 후 list[] 업데이트하여 생성
			for (int i = 0; i <studCnt; i++) {   // 반복문 사용하여 list[i]의 요소 배치하기
				list[i] = temp[i];
			}
			temp = null; 
		}
		list[studCnt] = st;
		studCnt++;
		
	}
	
	//가입한 학생 탈퇴하기 메서드
	StudentEx01 remoneStudentEx (int index) {        // 탈퇴해야 하는 아이디의 위치값을 매개변수로 받는다
       
       StudentEx01 deleteObj = list[index];
       
		if (studCnt == 1) {                          //학생 수가 1명만 있었다면
		StudentEx01[] list = null;
		}
		else if (studCnt > 1) {
			StudentEx01[] temp = list;
			list = new StudentEx01[studCnt - 1];
			for (int i = 0; i < index; i++) {
				list[i] = temp[i];
			for (int j = index; j <studCnt ; j++) {  // 이부분 이해가 안감?
				//list[]
			}
			temp = null;
		}
		//studCnt--;
		//return;
	}
	
	
	void printSudentEx01() {
		for (int i = 0; i < studCnt; i++) {
			list[i].printData();
		}
	}
	
}



public class ObjectArrayEx09_연습풀이 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Controller01 controller = new Controller01();
		
		while (true) {
			
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int sel = scan.nextInt();
			
			//가입하기
			if (sel == 1) {
				
				//studentEx01의 클래스 객체 생성하기-> temp 변수 객체 생성
				StudentEx01 temp = new StudentEx01();
				System.out.println("[가입] id를 입력하세요 >>>");
				temp.id = scan.next();
				// checkId메서드 호출하면서 내가 입력한 아이디 데이터를 매게 변수로 넣어주기(아이디 확인)
				int check = controller.checkId(temp);
				
				if (check == -1) {    //가입이 안된 상태
					System.out.println("[가입] pw 를 입력하세요 >>>");
					temp.pw = scan.next();
					controller.addStudentEx01(temp);
					System.out.println(temp.id + "님 가입을 축하합니다.");
					
				}else {// 가입이 되어 있는 상태
					System.out.println("중복아이디입니다.");
				}
				
				
			}
			//탈퇴하기
			else if (sel == 2) {
				StudentEx01 temp = new StudentEx01();  //구조 선언
				controller.printSudentEx01();
				System.out.println("[탈퇴] id 를 입력하세요 >>> ");
				temp.id = scan.next();
				int check = controller.checkId(temp);
				
				if (check == -1) {
					System.out.println("없는 ID 입니다.");
				}
				else {
					System.out.println("님 탈퇴되었습니다.");
				}
				
				
				
			}else if (sel == 3) {
				
			}else if (sel == 4) {
				
			}else if (sel == 5) {
				
			}else if (sel == 6) {
				
			}else {
				System.out.println("==종료 ==");
				break;
			}
		}
		scan.close();
	}

}
