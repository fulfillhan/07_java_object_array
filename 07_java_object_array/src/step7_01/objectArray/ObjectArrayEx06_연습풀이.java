package step7_01.objectArray;

class Member01{
	
	String name;
	int num;
	
}

class MemberManager01{

	Member01[] memberList = new Member01[3];//Member01 클래스의 3개크기 선언

}

public class ObjectArrayEx06_연습풀이 {
	
	public static void main(String[] args) {
		//각 클래스 객체 생성
		Member01 m1 = new Member01();
		MemberManager01 mg = new MemberManager01();
		//배열 클래스에 데이터 넣기
		mg.memberList[0] = m1; //memberList[0]배열에 m1클래스 저장
		m1.name = "김철수";
		m1.num = 1001;
		
		//m1 = new Member01();
		mg.memberList[1] = new Member01();
		m1.name = "이만수";
		m1.num = 1002;
		
		m1 = new Member01();
		mg.memberList[2] = m1;
		m1.name = "박영희";
		m1.num = 1003;
		
		for (int i = 0; i < mg.memberList.length; i++) {//3번 반복
			System.out.println("name : "+mg.memberList[i].name);
			System.out.println("number : "+mg.memberList[i].num);
		}
		
		//memberList 의 첫번째 값 변수에 넣어보기
		Member01 temp = mg.memberList[1]; 
		System.out.println("name : "+ temp.name);
		System.out.println("number : "+ temp.num);
	}

}
