package hashtable;

import java.util.Hashtable;

public class hashtable {

	public static void main(String[] args) {
		 Hashtable<Integer,Integer> hashTable= new Hashtable<Integer,Integer>();

		 int num = 674939;
		 int mathNum = num  / 1000;
		 int count = 0;
		 for (int i = 0; i < mathNum; i++) {
			 count++;
			 hashTable.put(mathNum, i);
			 System.out.println(count);
			 System.out.println(hashTable);
		 }
		 System.out.println(count);
		 System.out.println(hashTable);

	}
	
	

}
