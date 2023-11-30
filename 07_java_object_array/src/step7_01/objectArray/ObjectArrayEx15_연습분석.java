package step7_01.objectArray;

import java.util.ArrayList;
import java.util.Scanner;
class StudentDTO01{
	
	//선언만 해놓기
	String id;
	String pw;
}

class StudentController01{
	
	//ArrayList 사용하여 StudentDTO 객체 배열화 하기
	ArrayList<StudentDTO01> studentList = new ArrayList<StudentDTO01>();
	
	
	//아이디 유효성 체크
	int checkId(StudentDTO01 st) {
		int check = -1;
		for (int i = 0; i <studentList.size(); i++) {
			if (studentList.get(i).id.equals(st.id)) {
				check = i;
				break;
			}
		}
		return check;
	}
	//학생 추가하기(데이터 저장하기)
	void addStudent(StudentDTO01 studentDTO) {
		studentList.add(studentDTO);
	}
	
	//탈퇴하기
	
	
}

public class ObjectArrayEx15_연습분석 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		StudentController01 controller = new StudentController01();  // StudentController01 객체 생성
		
	  while (true) {
		
		  System.out.print("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료 >>>");
		  int sel = scan.nextInt();
		  
		  //가입하기
		  if (sel == 1) {
			  StudentDTO01 temp = new StudentDTO01();  // StudentDTO클래스 객체 생성
			  System.out.print("[가입] id 를 입력하세요 >>>");
			  temp.id = scan.next();
			  int check = controller.checkId(temp);
			  
			  if (check == -1) {
				System.out.print("[가입] pw 를 입력하세요 >>>");
				temp.pw = scan.next();
				controller.addStudent(temp);          // 학생 추가된 메서드 수행 add(데이터)
				System.out.println(temp.id + "님 가입을 축하합니다.");
			}else{
				System.out.println("종복 아이디 입니다.");
			}
			  
			
		}else if (sel == 2) {
			
		}else if (sel ==3) {
			
		}else if (sel == 4) {
			
		}else if (sel == 5) {
			
		}else if (sel == 6) {
			
		}else if (sel == 7) {
			
		}
	}
		
	}

}
