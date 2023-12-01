package step7_01.objectArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.event.ListDataEvent;
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
	
	//학생 삭제하기
	StudentDTO01 removeStudent01(int i) {            //int check 에서 check는 내가 선택한 i번째 위치랑 같음
		 StudentDTO01 deleteObj= studentList.get(i); // arrayList에서 가져온 i 번째 데이터(삭제할 데이터)를 deleteObj 대입한다.
		 studentList.remove(i);                      // remove(인덱스) : 해당 위치의 값이 바로 삭제하면서 리스트의 크기를 줄인다.
		return deleteObj;                            // 삭제하려 했던 데이터 반환
		
	}
	
	void sortData() {
		
		int size = studentList.size();          // 배열의 크기 선언및 초기화
		
		for (int i = 0; i < size -1; i++) {    // 현재 element 나열
			for (int j = i+1; j < size; j++) { //비교할 element 나열-> i 이후의 값들을 비교한다.
				if (studentList.get(i).id.compareTo(studentList.get(j).id )> 0) {
					String tempId = studentList.get(i).id;
					studentList.get(i).id = studentList.get(j).id;	
					studentList.get(j).id = tempId;
				}
			}
		}
     }
	void printStudent() {
		for (StudentDTO01 studentDTO01 : studentList) {
			System.out.println("id : "+studentDTO01.id+ " / "+ "pw : "+ studentDTO01.pw);
		}
	}
	int getsize() {
		return studentList.size();
	}
	String outData() {
		String data = "";
		int size = getsize(); //메서드 호출하여 크기를 얻기..?
		if (size == 0) { 
			return data;
		}
		
		data += size+ "\n";
		for (int i = 0; i <size; i++) {
			data += studentList.get(i).id + ",";
			data += studentList.get(i).pw;
			if (size-1 != i) {
				System.out.println("\n");
			}
		}
		return data;
	}
	
}
	
	


public class ObjectArrayEx15_연습분석 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		StudentController01 controller = new StudentController01();  // StudentController01 객체 생성
		String fileName = "student_arraylist_db01.txt";              //fileName 선언
		
		
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
			
		}
		  //탈퇴하기
		  else if (sel == 2) {
			  StudentDTO01 temp = new StudentDTO01(); 
			  
			  System.out.print("[탈퇴] id 를 입력하세요 >>> ");
			  temp.id = scan.next();
			  int check = controller.checkId(temp);
			  
			  if (check == -1) {  // 가입이 안되어있는 경우
				System.out.println("없는 ID 입니다. ID를 확인해 주세요");
			}else {
				String deleteId =	controller.removeStudent01(check).id;
				System.out.println(deleteId+ "님 탈퇴가 완료되었습니다.");
			}
			  
			
		} 
		  // 정열하기
		  else if (sel ==3) {
			  controller.sortData();      //정열하고
			  controller.printStudent();  //출력하기
			
		}//출력하기
		  else if (sel == 4) { 
			  
			  controller.printStudent();
			
		}//저장하기
		  else if (sel == 5) {
			  if (controller.getsize() == 0)  break;  // getszie() 크기값 반환되는 베서드 호출
			  FileWriter fW = null;
			 try {
				 fW = new FileWriter(fileName);
				 String data = controller.outData();
				 if (!data.equals("")) {
					 fW.write(data);
					System.out.println(data);
				}
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
			 finally {
				try {fW.close();} catch (IOException e) {e.printStackTrace();}
			}
			
		  }//로드하기
		  else if (sel == 6) {
			
			  FileReader fr = null;
			  BufferedReader br = null;
			  
			  try {
					  
				  File file = new File(fileName);
				  
					  if (file.exists()) {
						  
					fr = new FileReader(fileName);
					}
			  }
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  br = new BufferedReader(fr);
				  
				  
		}
		  else if (sel == 7) {
			System.out.println("==프로그램 종료==");
			break;
		}
	}
		
	}

}
