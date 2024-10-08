package step7_01.objectArray;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.crypto.Data;

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
       
       StudentEx01 deleteobj = list[index];          // 삭제될 객체를 저장
       
		if (studCnt == 1) {                          // list의 하나의 요소만 있을경우 -> null로 설정
		StudentEx01[] list = null;
		}
		else if (studCnt > 1) {                      //리스트에 두개 이상의 요소가 있을경우
			StudentEx01[] temp = list;               // 현재 리스트를 저장할 임시 배열 생성
			list = new StudentEx01[studCnt - 1];     // 하나의 요소가 없는 새로운 배열 생성
			
			// 질문 -> 왜 인덱스 기준으로  이전과 이후의 요소를 새 리스트에 복사하는가?
			// 삭제하려는 요소를 제외하고 새 배열에 복사하기 위해서
			for (int i = 0; i < index; i++) {       
				list[i] = temp[i];
			}
			for (int i= index; i <studCnt -1 ; i++) {  //studCnt -1인 이유는 ? 삭제 요소제외 새로운 배열의 크기가 기존의 배열보다 하나작다.
				list[i] = temp[i+1];                   // temp[i+1]이유는 ? 삭제한 요소의 이후의 요소를 재배열 시키기 위해서
				}
			
			temp = null;
		}
		studCnt--;
		
		return deleteobj;                            // 삭제된 객체 돌려주기
	}
	
	//선택적 정열 메서드
	void sortData() {
	
		// 정열할때 id 문자열 비교하여 순서 정열하기 
		//-> 외부 루프가 한바퀴 돌때마다 가장 작은 숫자를 가진 id 배열이 맨 앞으로 이동하게 되어, 최종적으로 id의 오름차순으로 정열이 이루어진 배열
		for (int i = 0; i < studCnt; i++) {                 //i 루프 -> 배열의 각 요소를 선택
			for (int j = i; j < studCnt; j++) {             // 선택된 요소와 이후의 모든 요소를 비교
				if (list[i].id.compareTo(list[j].id) > 0) { //id 문자열 비교하여 더 빠른 순으로 list[i] 가 list[j]보다 큰 경우
					StudentEx01 temp = list[i];
					list[i] = list[j];                      // 교환 -> 순서번호가 더 작은 list[j]에서 현재 list[i]로 재배치
					list[j] = temp;
					
				}
			}
		}
	}
		
	// 저장된 학생 객체 List 출력하기 메서드
	void printSudentEx01() {
		for (int i = 0; i < studCnt; i++) {
			list[i].printData();
		}
	}
	
	// StudentEx의 객체 배열인 list의 데이터를 문자열로 반환하기
	String outData01() {
		
		String data = "";                    //메서드가 반환활 문자열 초기화
		//학생수 체크
		if (studCnt == 0) {                  // 학생수 데이터가 없다면 빈 문자열로 반환
			return data;
		}
		data = data + studCnt + "\n"; 
		
		for (int i = 0; i < studCnt; i++) {  //StudentEx01의list 배열 각 요소의 id와 pw를 가져와 문자열로 합친다.
			  data += list[i].id;
			  data += ",";
			  data += list[i].pw;
			  if (studCnt -1 != i) {         // studCnt -1  가 마지막요소가 아니라면
				  data += "\n";              // 줄바꿈을 추가한다.( 마지막 요소이면 줄바꿈이 되지 않음)
			}
		}
		return data;
		
	}
	void loadStudentEx(StudentEx01[] temp, int count) {
		this.list = temp;
		this.studCnt = count;
	}
	
}



public class ObjectArrayEx09_연습풀이 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Controller01 controller = new Controller01();
		
		String fileName = "student_db.01";
		
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
				controller.printSudentEx01()
				
				;
				System.out.println("[탈퇴] id 를 입력하세요 >>> ");
				temp.id = scan.next();
				int check = controller.checkId(temp);
				
				if (check == -1) {
					System.out.println("없는 ID 입니다.");
				}
				else {
					StudentEx01 del_st = controller.remoneStudentEx(check);
					System.out.println(temp.id+ "님 탈퇴되었습니다.");
				}
			
			}
			//정렬하기
			else if (sel == 3) {
				controller.sortData();
				controller.printSudentEx01();
				
			}
			//출력하기
			else if (sel == 4) {
				
				controller.printSudentEx01();
				
			}
			//저장하기
			else if (sel == 5) {
				if (controller.studCnt == 0) {
					continue;
				}
				FileWriter fw = null;                    // 파일 쓰기 위한 FileWriter 선언
				
				try {
					fw = new FileWriter(fileName);       //FileWriter 객체 초기화
				String data = controller.outData01();    // 메서드 호출하여 데이터 가져오기
				if (!data.equals("")) {                  // 가져온 data에서 ""비어있지 않다면(조건)
					fw.write(data);                      //파일에 데이터를 쓴다
					System.out.println(data);            // 해당 데이터를 출력한다
				}
				} catch (Exception e) {                // 예외 발생하면 예외 정보를 출력
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				finally {
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		
			// txt읽어내고 출력하기  ** 이게 어려움**
			else if (sel == 6) {
		
				FileReader fr = null;
				BufferedReader br = null;
				
				
					try {
						 // 파일을 다루기 위한 File 객체 생성
						File file = new File(fileName);   
						
						// 파일이 존재하는지 확인
					     if (file.exists()) {  
					    	 
						 fr = new FileReader(file);   //FileReader 사용하여 파일 읽어내기
						 br = new BufferedReader(fr); // BufferdReader 사용하여 효율적으로 파일 읽어낼수있다.
						  
						String line = br.readLine(); // 한 줄의 내용을 읽어와서
						int count =Integer.parseInt(line);// int로 전환하여 count 변수에 저장
						StudentEx01[] temp = new StudentEx01[count]; // 읽어드린 학생 정보를 저장할 객체 배열 생성(크기는 count)
						
						//count 만큼 반복하면서 학생 수를 배열에 저장한다.
						for (int i = 0; i < count; i++) {
							temp[i]= new StudentEx01();
							line = br.readLine();
							// 쉼표로 구분된 값을 분할하여 저장
							String[] value = line.split(",");
							temp[i].id = value[0];
							temp[i].pw = value[1];
						
						}
						// controller 의 loadStudent 메서드 호출하여 학생 정보 출력
						controller.loadStudentEx(temp, count); 
						 
						}
					     controller.printSudentEx01();
					}
					catch (Exception e) {
						e.printStackTrace();
					}  finally {
						try {
							// buggeredReader 닫기
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							//FileReader 닫기
							fr.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				
			}else if(sel== 7 ){
				System.out.println("==종료 ==");
				break;
			}
		}
		scan.close();
	}

}
