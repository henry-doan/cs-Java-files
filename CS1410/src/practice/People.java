package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class People {

	public static void main(String[] args)
	{
		java.util.List<Person> whoAreWeLookingFor = new ArrayList<Person>();
		
		File f = new File ("src/practice/People.txt");
		
		try {
			Scanner in = new Scanner(f);
			
			double total = 0;
	
			for(int i=0;i<2000;i++)
			{
				whoAreWeLookingFor.add(new Person(in.next(),in.nextInt(),in.nextDouble()));
				
			}
			
			Person isOldest = whoAreWeLookingFor.get(0);
			
			
			for(Person b : whoAreWeLookingFor)
			{
				total = total + b.getScore();
			}
			
			double avg = total / 2000;
			System.out.println(avg);
			
			for(Person c : whoAreWeLookingFor)
			{
				if(c.getAge()>isOldest.getAge())
					isOldest = c;
			}
			
			System.out.println(isOldest.getName() + "  " + isOldest.getAge());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
