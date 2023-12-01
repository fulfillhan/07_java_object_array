package step7_01.objectArray;

import java.util.HashMap;
 
/*
  
  	 # 컬렉션 프레임워크(collection framework) HashMap
  	 
 	- HashMap은 K(Key)에 V(Value)를 할당 방식으로 데이터가 저장하는 데이터 형식이다.
	- HashMap은 순서와 상관없이 key로 데이터를 저장 및 관리한다.
	- HashMap 생성방법
	
		HashMap<키, 값> 변수명 = new HashMap<키, 값>();
		HashMap<키, 값> 변수명 = new HashMap<>();						// new 뒤쪽의 generic은 생략 가능하다.
		
		Ex)
		 HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		 HashMap<String, Integer> hmap = new HashMap<>();				 
		 
		 설명)
		 HashMap<String,Integer> : key의 타입은 String이고 저장될 데이터의 타입은 Integer이다.
		 HashMap<String,String>  : key의 타입은 String이고 저장될 데이터의 타입은 String이다.
		 HashMap<String,Object>  : key의 타입은 String이고 저장될 데이터의 타입은 Object이다.
		 HashMap<String,Product> : key의 타입은 String이고 저장될 데이터의 타입은 Product이다.
		 HashMap<String,Member>  : key의 타입은 String이고 저장될 데이터의 타입은 Member이다.


*/

class TempMember {
	
	String id;
	String passwd;
	String name;
	String email;
	String address;
	
}


public class ObjectArrayEx16 {

	public static void main(String[] args) {
		
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		

		// put(key, value) : HashMap의 key에 value를 할당한다. 
		// put()메서드는 존재하지 않는 key에 넣어주면 데이터가 입력되고 존재하는 key에 넣어주면 수정된다. 
		hMap.put("data1", 1000); // 
		hMap.put("data2", 2000);
		hMap.put("data3", 3000);
		System.out.println(hMap);
		System.out.println("\n================\n");
		
		//데이터 수정 put();
		hMap.put("data1", 10000);
		hMap.put("data2", 20000);
		hMap.put("data3", 30000);
		
		//데이터 주가 put();
		hMap.put("data4", 4000);
		hMap.put("data5", 5000);
		
		System.out.println(hMap);
		System.out.println("\n================\n");
		
		
		// size() : HashMap의 데이터개수를 반환한다.
		
		
		System.out.println("개수 : "+hMap.size());
		System.out.println("\n================\n");
		
		
		// get(key) : HashMap의 key에 할당된 value를 얻어온다.  -> 가장 중요!!
		System.out.println(hMap.get("data1"));
		System.out.println(hMap.get("data2"));
		System.out.println(hMap.get("data3"));
		System.out.println(hMap.get("data4"));
		System.out.println(hMap.get("data5"));
		System.out.println("\n================\n");
		
		
		// keySet() : HashMap의 key만 얻어온다.
		System.out.println(hMap.keySet());
		
		
		for (String key: hMap.keySet()) {
		System.out.println(key + " : " + hMap.get(key));
		}
		System.out.println("\n================\n");
		
		// remove(key) : HashMap의 key에 해당하는 값을 제거한다.
		
		hMap.remove("data1");
		hMap.remove("data2");
		hMap.remove("data3");
		
		System.out.println(hMap);
		System.out.println("\n================\n");
		
		hMap.clear();// 데이터만 삭제
		//hMap.put(key, value)
		hMap = null; // HashMap 자체 삭제
		//hMap = new HashMap<String, Integer>(); // 새로 초기화 해줘야한다.
		//hMap.put(key, value);
		
		// 웹에서 자주 사용하는 예시 1
		
		TempMember temp1 = new TempMember();
		temp1.id = "user01";
		temp1.name = "유저1";
		temp1.passwd = "1";
		temp1.email = "1@gmail.com";
		temp1.address = "서울";
		
		TempMember temp2 = new TempMember();
		temp2.id = "user02";
		temp2.name = "유저2";
		temp2.passwd = "2";
		temp2.email = "2@gmail.com";
		temp2.address = "서울";
		
		HashMap<String,TempMember> mapEx01 = new HashMap<String, TempMember>();
		mapEx01.put(temp1.id, temp1);
		mapEx01.put(temp2.id, temp2);
		
		System.out.println(mapEx01.get(temp1.id));
		System.out.println(mapEx01.get(temp2.id));
		System.out.println();
		
		
		// 웹에서 자주 사용하는 예시 2
		HashMap<String, String> mapEx02 = new HashMap<String, String>();
		
		mapEx02.put("id", "user3");
		mapEx02.put("name", "유저3");
		mapEx02.put("passwd", "3");
		mapEx02.put("email", "3@gmail.com");
		mapEx02.put("address", "서울");
		
		//클래스 외에 추가적으로 데이터 저장이 가능하다. -> 순서가 뒤죽박죽으로 나온다
		mapEx02.put("ispc", "y");
		mapEx02.put("role", "client");
		mapEx02.put("browser", "chrome");
		System.out.println(mapEx02);
		System.out.println();
		
		// 참고) Object 타입을 명시할경우 서로 다른데이터를 저장할 수 있다.
		HashMap<String, Object> testMap = new HashMap<String, Object>(); //-> 모든 데이터를 다 받아줄 수 있다. : 상속을 알아야지...
		testMap.put("키1", "문자열");
		testMap.put("키2", 100);
		testMap.put("키3", 3.14);
		testMap.put("키4", true);
		testMap.put("키5", 'p');
		testMap.put("키6", new TempMember());
		testMap.put("키7" , new Product());
		
		System.out.println(testMap);
		

		
	}

}
