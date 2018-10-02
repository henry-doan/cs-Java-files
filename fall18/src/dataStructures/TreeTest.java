package dataStructures;

import java.security.SecureRandom;

public class TreeTest {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>();
		SecureRandom randomNumber = new SecureRandom();

		System.out.println("Inderting the following Value: ");
		
		for (int i = 1; i <= 10; i++) {
			int value = randomNumber.nextInt(100);
			System.out.printf("%d ", value);
			tree.insertNode(value);
		}
		
		System.out.printf("%n%nPreorder traveral%n");
		tree.preorderTraversal();
		
		System.out.printf("%n%nInorder traveral%n");
		tree.inorderTraversal();
		
		System.out.printf("%n%nPostorder traveral%n");
		tree.postorderTraversal();
	}

}
