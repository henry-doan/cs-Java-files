package assignment05;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.soap.Node;

/**
 * This class implements 
 *
 * @author  Henry Doan 
 * @version October 30, 2017
 */

public class TagTree {
	static Node root;
	static int height;
	ArrayList Children;
	
	public static class Node{
		Node left, right;
		String data;
		
		public Node(String s ) {
			data = s;
		}
	}
	
	public TagTree (Scanner file){
		try{
			File f = new File("insert file here");
			Scanner in = new Scanner(f);
			while(in.hasNext()){
				String s = in.next();
				s.toLowerCase();
			}
		} catch(IOException e) {
			System.out.println("Could not read file.");
		}
	}
	
	public void insert(String s) {
		if(root == null) {
			root = new Node(s);
		} else {
			insert(s, root);
		}
	}
	
	public static void insert(String s, Node n){
		if(n.data.equals(s)){
			return;
		}
		if(s.compareTo(n.data) < 0) {
			if(n.left == null){
				n.left = new Node(s);
			} else {
				insert(s, n.left);
			}
		} else {
			if(n.right == null){
				n.right = new Node(s);
			} else {
				insert(s, n.right);
			}
		}
	}
	
	public static void printTree(Node n, int level) {
		if( root != null){
			printTree(root.left, level+1);
			System.out.print(" " + root.data);
			printTree(root.right, level+1);
		}
	}
	
	public static int getHeight(Node root) {
		if (root == null) {
	        return -1;
	    }

	    int leftHeight = getHeight(root.left);
	    int rightHeight = getHeight(root.right);

	    if (leftHeight > rightHeight) {
	        return leftHeight + 1;
	    } else {
	        return rightHeight + 1;
	    }	
	}
	
	public static int getMaxDegree(Node n) {
		if (root == null) {
			return 0;
		} else {
			int ltDegree = getMaxDegree(root.left);
		    int rtDegree = getMaxDegree(root.right);
		    if (ltDegree > rtDegree) {
		    	return(ltDegree + 1);
		    } else {
		    	return(rtDegree + 1);
		    }
		}
	}
	
	public static boolean isTwoTree(){
		 if ( root == null ) {
	       return true;
		 } else {
			 if ( root.left == null || root.right == null ) {
				 return root.left == null && root.right == null;
	         } else {
	        	 return false;
	         }
	     }  
	}
	
	public static boolean isFullBinaryTree() {
		 if (root != null) {
			 if(root.right == null && root.left == null) {
				 return true;
		     } else {
		    	 return false;
		     }
		 }
		 return false;
	}
	
	public static int findDepth(String s){
		if (root.data.equals(s)) {
			return - 1;
		} 
		
		Node current = root;
		while(current != null){
			if(current.data == s){
				return + 1;
			} else if(current.data.equals(s)){
				current = current.left;
				return + 1;
			} else{
				current = current.right;
				return + 1;
			}
		}
		return + 1;

	}
	
	public static void traverse (Node root){
	    if (root.left != null){
	        traverse (root.left);
	    }
	    if (root.right != null){
	        traverse (root.right);
	    }
	}
	
	private static void outputPrefix(Node n, int level) {
		if(n.left != null){
			printTree(n.left, level + 1);
			for(int i = 0; i < level; i++){
				System.out.println(" ");
				System.out.print(n.data);
			}
		} else {
			if(n.right != null){
				printTree(n.right, level + 1);
				for(int i = 0; i < level; i++){
					System.out.println(" ");
					System.out.print(n.data);
				}
			}
		}
	}
}
