package step7_01.objectArray;

// MyArrayList01 만들기
class MyArrayList01{
	
	//인스턴스 변수 선언하기
	int[] arr ;
	int elementCnt;
	
	//1.매개변수 1개인 add 메서드 -> 배열의 크기가 달라짐
	void add(int value) {
		
		if (elementCnt == 0) {//요소갯수가 0 이면
			arr = new int[elementCnt + 1];// 배열의 크기는 +1
		}
		else if (elementCnt > 0) {//요소의 갯수가 1개 이상이면
			int[] temp = arr;// 기존배열을 임시 배열 temp 저장
			arr =  new int [elementCnt + 1]; // 배열의 크기가 +1로 생성된 새로운 배열 arr 저장
			
			for (int i = 0; i < elementCnt; i++) {
				arr[i] = temp[i]; // 기존 배열을 새로운 배열로 업데이트
			}
			temp = null;

		}
		arr[elementCnt] = value;
		elementCnt++;
		
	}
	//2.매개변수 2개인 add 메서드
	
	
	//3.remove 메서드
	//4 크기 메서드
	//5.get 메서드
	//6.set 메서드
	//7.print 메서드
	//8.clear 메서드
}


public class ObjectArrayEx14_연습분석 {
	
	public static void main(String[] args) {
		
	}

}
