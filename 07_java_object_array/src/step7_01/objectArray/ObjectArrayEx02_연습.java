package step7_01.objectArray;

class Card {
	
	int num;
	String shape;
	
}

public class ObjectArrayEx02_연습 {

	public static void main(String[] args) {
		
		 Card[] cardList = new Card[10];//크기 선언
		 
		 // for문 활용
		 for (int i = 0; i < 10;  i++) {
			 cardList[i] = new Card();//자료 구조선언
			 cardList[i].num = (i + 1);
			 cardList[i].shape = "클로버";
		 }

		 for (int i = 0; i < cardList.length; i++) {
			System.out.println("num : " + cardList[i].num);
			System.out.println("shape : " + cardList[i].shape);
			System.out.println();
		}
		 
	}

}
