package priorityQueues;

import java.util.PriorityQueue;

public class PriorityQueueUserDefinedObjectExample {

	public static void main(String[] args) {
		PriorityQueue<Employee> employeePriorityQueue = new PriorityQueue<>();
		
		employeePriorityQueue.add(new Employee("Rajeev", 100000.00));
		employeePriorityQueue.add(new Employee("Chris",145000.00));
		employeePriorityQueue.add(new Employee("Andrea",115000.00));
		employeePriorityQueue.add(new Employee("Jack",167000.00));
		
		while(!employeePriorityQueue.isEmpty()) {
			System.out.println(employeePriorityQueue.remove());
		}
	}

}
