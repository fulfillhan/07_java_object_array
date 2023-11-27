package step7_01.objectArray;

import java.util.Scanner;

class Subject08{
	
	String name;
	int score;

}


class Student08{
	
	Subject08[] subjects;
	String name;

}


public class ObjectArrayEx08_연습풀이 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Student08[] studentList = new Student08[3];// student008의 클래스의 3개 크기의 배열 선언
		int studentCnt = 0;
		
		while (true) {
			
			// 1. 학생추가시 학생의 수 출력 (반복)
			for (int i = 0; i < studentList.length; i++) {
				System.out.println("["+(i+1)+"]"+ studentList[i].name+ ">>>" );
				if (studentList[i].subjects != null) {
					for (int j = 0; j < studentList[i].subjects.length; j++) {
						System.out.println("["+ (j+1)+ "]"+ studentList[i].subjects[j].name+"과목  = "+studentList[i].subjects[j].score + "점" );
					}
				}
			}
			
			System.out.println("[1]학생 추가하기");
			System.out.println("[2]과목 추가하기");
			System.out.println("[3]성적 추가하기");
			System.out.println("[4]종료하기 \n");
			System.out.println("번호 입력 : ");
			int myNum = scan.nextInt();
			
			//학생 추가과정
			if (myNum == 1) {
				System.out.print("이름 입력 : ");
				String myName = scan.next();
				
				// studentList[] 의 학생 이름 데이터 넣기
				studentList[studentCnt] = new Student08();// studentList 클래스 배열의 구조 선언
				studentList[studentCnt].name = myName;
				studentCnt++;
				
			}
			//각 학생의 과목 추가하기
			else if (myNum == 2) {
				//입력한 학생 배열 출력
				for (int i = 0; i < studentCnt; i++) {
					System.out.println("["+ (i+1) +"]"+ studentList[i].name);
				}
					System.out.print("학생 번호 선택 : ");
					int select = scan.nextInt();
					select--;
					
					System.out.print("과목 입력 : ");
					String subjectName = scan.next();
					
					if (studentList[select].subjects == null) {//기본값일때
						
						studentList[select].subjects = new Subject08[1];//-> 크기 1로 정하는 이유? = null값이어서 크기 1나를 먼저 만든다..
						studentList[select].subjects[0] = new Subject08();
						studentList[select].subjects[0].name = subjectName;
						
					}
					// -> 해당 부분 오래거림 이유 : subjectList의 subect08 의 배열 객체화 하는 과정이 어려움
					else {// studentList[select].subjects  null 이 아닐때
						int size = studentList[select].subjects.length;// subect[] 의 배열의 길이 선언
						
						Subject08[] temp = new Subject08[size + 1];// 배열의 크기가 달라져서 temp배열 생성.
						
						for (int i = 0; i < size; i++) {
						 studentList[select].subjects[i] = temp[i];
						}
						temp = null;
						
					studentList[select].subjects[size] = new Subject08();
					studentList[select].subjects[size].name = subjectName;
						
					}
			
			}
			//성적추가하기
			else if (myNum == 3) {
				
				for (int i = 0; i < studentCnt; i++) {
					System.out.println("["+ (i+1)+ "]"+ studentList[i].name);
				}
				System.out.print("학생 번호 선택 : ");
				int select = scan.nextInt();
				select--;// 코딩중에 자꾸 select를 마이너스-1 해야하는걸 누락함.
				//학생의 과목수 배열로 출력하기
				//조건먼저 정하기
				if (studentList[select].subjects != null) {
					for (int i = 0; i < studentList[select].subjects.length; i++) {
						System.out.println("["+(i+1)+"]"+ studentList[select].subjects[i].name);
					}
				}
				System.out.print("과목 번호 선택 : ");
				int selectSubect = scan.nextInt();
				selectSubect--;
				
				System.out.print("성적 입력 : ");
				int myScore =scan.nextInt();
				
				studentList[select].subjects[selectSubect].score = myScore;
							}
			//종료하기
			else if (myNum == 4) {
				System.out.println("== 시스템 종료 ==");
				break;
			}
		
		}
		
		scan.close();
	}

}
