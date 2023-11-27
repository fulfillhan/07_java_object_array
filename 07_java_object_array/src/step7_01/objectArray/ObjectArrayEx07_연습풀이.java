package step7_01.objectArray;


//2023-11-24 오후학습01
class Subject01{
	
	String name;
	int score;
	
}

class Student01{
	
	Subject01[] subjects;	// Subject 객체를 담을 클래스 배열
	String name;
	
}

public class ObjectArrayEx07_연습풀이 {

	public static void main(String[] args) {
		
		Student01[] studentList = new Student01[3];
		// 크게 보기 -> Student01 클래스의 배열 생성하기
		studentList[0] = new Student01();// 구조 만들기
		studentList[0].name = "학생0";
		
		//studentList[0].subjects = new Subject01[3];// subject 배열의 크기 선언
		// subject 의 배열 코딩하기
		for (int i = 0; i < studentList.length; i++) {
			studentList[0].subjects[i] = new Subject01();
			studentList[0].subjects[i].name = "학생0 과목"+ i;
			studentList[0].subjects[i].score = 100;
		}
		
		studentList[1] =  new Student01();// 구조 재생성
		studentList[1].name = "학생1";
		studentList[1].subjects = new Subject01[2];// 2개의 크기 지정
		studentList[1].subjects[0] = new Subject01();// Subject 구조 생성
		studentList[1].subjects[0].name = "학생1 과목0";
		studentList[1].subjects[0].score = 100;
		
		studentList[1].subjects[1] = new Subject01();
		studentList[1].subjects[1].name = "학생1 과목1";
		studentList[1].subjects[1].score = 100;
		
		studentList[2] = new Student01();
		studentList[2].name = "학생2";
		studentList[2].subjects = new Subject01[1];
		studentList[2].subjects[0] = new Subject01();
		studentList[2].subjects[0].name = "학생2 과목1";
		studentList[2].subjects[0].score = 100;
		
		for (int i = 0; i < studentList.length; i++) {
			System.out.println("--- " + studentList[i].name + " ---");
			for (int j = 0; j < studentList[i].subjects.length; j++) {
				System.out.println(studentList[i].subjects[j].name + " / "+ studentList[i].subjects[j].score);
			}
			System.out.println();
		}
	
		
		

	}

}
