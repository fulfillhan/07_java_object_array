package step7_01.objectArray;

class Card01 {
	
	int num;
	String shape;
}

public class ObjectArrayEx02_연습풀이 {

	public static void main(String[] args) {
		
		Card01[] cardList = new Card01[10];
		
		for (int i = 0; i < 10; i++) {
			cardList[i] = new Card01();
			cardList[i].num = (i + 1);
			cardList[i].shape = "클로버";
		}
		for (int i = 0; i < cardList.length; i++) {
			System.out.println("num : "+ cardList[i].num);
			System.out.println("shape : "+ cardList[i].shape);
			System.out.println();
		}
		
	}

}
