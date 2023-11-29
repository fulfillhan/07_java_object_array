package step7_01.objectArray;

import java.util.ArrayList;
import java.util.Arrays;

class Tv01{
	
	String name;
	String brand;
	int price;
	
	void setData(String name, String brand, int price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
}

public class ObjectArrayEx13_연습분석 {
	
	public static void main(String[] args) {
		
		ArrayList<Tv01> list = new ArrayList<Tv01>();
		
		
		Tv01 temp = new Tv01(); //tv01의 배열의 객체 temp변수 생성하기
		temp.setData("TV", "삼성" , 1000);
		list.add(temp);
		
		temp = new Tv01();
		temp.setData("시그니처 TV", "엘지", 2000);
		list.add(temp);
		
		temp = new Tv01();
        temp.setData("스마트TV","애플", 30000);
        list.add(temp);
        
        list.remove(1);// 인덱스 1의 의 데이터 지우기
        
        //ArrayList 의 배열 나열하기
        for (int i = 0; i < list.size(); i++) {
			System.out.println("name : "+ list.get(i).name);
			System.out.println("brand : "+ list.get(i).brand);
			System.out.println("price : "+ list.get(i).price);
			System.out.println();
		}
        System.out.println("\n");
        
        //foreach 구문 사용
        for (Tv01 tv01 : list) {
			System.out.println("name : "+ tv01.name);
			System.out.println("brand : "+ tv01.brand);
			System.out.println("price : "+ tv01.price);
			System.out.println();
		}
        
        
		
		
	}
	
	

}
