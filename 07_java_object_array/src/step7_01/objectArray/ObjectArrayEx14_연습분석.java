package step7_01.objectArray;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;

import javax.lang.model.element.Element;

// MyArrayList01 만들기
class MyArrayList01{
	
	//인스턴스 변수 선언하기
	int[] arr ;
	int elementCnt;
	
	//1.매개변수 1개인 add 메서드 -> 배열의 크기가 달라짐
	void add(int value) {
		
		if (elementCnt == 0) {               //요소갯수가 0 이면
			arr = new int[elementCnt + 1];   // 배열의 크기는 +1
		}
		else if (elementCnt > 0) {           //요소의 갯수가 1개 이상이면
			int[] temp = arr;                // 기존배열을 임시 배열 temp 저장
			arr =  new int [elementCnt + 1]; // 배열의 크기가 +1로 생성된 새로운 배열 arr 저장
			
			for (int i = 0; i < elementCnt; i++) {
				arr[i] = temp[i];            // 기존 배열을 새로운 배열로 업데이트
			}
			temp = null;

		}
		arr[elementCnt] = value;
		elementCnt++;
		
	}
	//2.매개변수 2개인 add 메서드 (중간에 값을 끼어넣기)
	void add(int index, int value) { //추가하려는 인덱스 위치게 값을 추가한다. 배열의 길이가 달라진다.
		
		if (elementCnt == 0) {
			arr = new int[elementCnt + 1];
		}
		else if (elementCnt > 0) {
			int[] temp = arr;
			arr = new int[elementCnt + 1];
			
			
			                                         //특정 인덱스에 값을 넣기 위한 방법
			int j = 0;                               //임시 배열[temp]의 인덱스를 가리키기 위해서 j변수 선언과 초기화
			for (int i = 0; i < elementCnt+1; i++) { //새로운 배열의 인덱스 i~ elementCnt+1(새로운 배열의 요소의 크기)
				if (i != index) {
					arr[i] = temp[j];
					j++;
				}
				
			}
			temp = null; //temp 변수 메모리 초기화
			
		}
		arr[index] = value; // 특정 index에 값을 추가한다
		elementCnt++; // 이후 요소를 증가시킨다.
		
	}
	
	//3.remove 메서드
	void remove(int index) {
		
		if(elementCnt == 1) {
			arr = null;
		}
		else if (elementCnt > 1) {
			int[] temp = arr;
			arr = new int[elementCnt -1];
			
			int j = 0;
		    for (int i = 0; i < elementCnt; i++) {
				if (i != index) {
					arr[j] = temp[i];
					j++;
				}
			}
		    temp=null;
		}
		elementCnt--;
		
		
	}
	//4 크기 메서드
	int size() {
		return elementCnt;
	}
	//5.get 메서드
	int get(int index) {
		return arr[index];
	}
	//6.set 메서드
	void set(int index, int value) {
		arr[index] = value;
	}
	//7.print 메서드
	void print () {
		System.out.println(Arrays.toString(arr));
	}
	//8.clear 메서드
	void clear() {
		arr = null;
		elementCnt = 0;
	}
}


public class ObjectArrayEx14_연습분석 {
	
	public static void main(String[] args) {

		// ArrayList 사용
		ArrayList<Integer> list =  new ArrayList<Integer>();

		// 추가하기
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		System.out.println(list);
		
		//삽입하기
		list.add(0, 9);
		
		//출력하기
		System.out.println(list);
		
		//인덱스로 삭제하기
		list.remove(3);
		System.out.println(list);
		
		//길이 구하기
		int elementCnt =list.size();
		System.out.println("elementCnt = "+ elementCnt);
		
		//인덱스로 값 꺼내오기
		System.out.print("[");
		for (int i = 0; i < elementCnt; i++) {
			System.out.print(list.get(i));
			if (elementCnt - 1 != i) {   // 끝 위치가 아니라면
				System.out.print(" , ");
				
			}
		}
		System.out.println("]");
		
		//특정 위치의 값 수정하기
		list.set(3, 5);
		System.out.println(list);
		
		//모든 데이터 삭제하기
		list.clear();
		System.out.println(list); // "[]" 형태만 있고 데이터 삭제
		System.out.println(list.size()); // 0
		
		
		System.out.println("\n==============================\n");
		
		//직접 구현한 ArrayList
		MyArrayList01 myList = new MyArrayList01();
		
		//추가하기
		myList.add(10);
		myList.add(20);
		myList.add(30);
		myList.add(40);
		myList.add(50);
		myList.print();
		
		//삽입하기
		myList.add(0, 9);
		
		//출력하기
		myList.print();
		
		//인덱스 삭제하기
		myList.remove(3);
		myList.print();
		
		//길이 구하기
		int elementCnt01 = myList.size();
		System.out.println("elementCnt = "+ elementCnt01);
		
		//인덱스 값 꺼내오기
		System.out.print("[");
		for (int i = 0; i < elementCnt01; i++) {
			System.out.print(myList.get(i));
			if (elementCnt01 - 1 != i) {
				System.out.print(" , ");
			}
		}
		System.out.println("]");
		
		//특정 위치의 값 수정하기
		myList.set(3, 5);
		myList.print();
		
		//모든 데이터를 삭제하기
        myList.clear();
        System.out.println(myList.size());

	}

}
