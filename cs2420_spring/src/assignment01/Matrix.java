package assignment01;

/**
 * Implementation of a 2D Mathematical Matrix
 * 	- includes functionality for multiplying and adding matrices
 * 
 * @author Miriah Meyer & Henry Doan
 * @version January 11, 2018
 */
public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	/**
	 * Constructor with data for new matrix (automatically determines dimensions)
	 * @param data -- a 2D integer array of data used to initialize the new Matrix object
	 */
	public Matrix(int data[][]) {
		numRows = data.length; // d.length is the number of 1D arrays in the 2D array
		if(numRows == 0) {
			numColumns = 0;
		} else {
			numColumns = data[0].length; // d[0] is the first 1D array
		}
		this.data = new int[numRows][numColumns]; // create a new matrix to hold the data
		// copy the data over
		for(int i=0; i < numRows; i++) { 
			for(int j=0; j < numColumns; j++) {
				this.data[i][j] = data[i][j];
			}
		}
	}
	
	/**
	 * Determines whether two objects are equivalent Matrices
	 * 
	 * TODO TEST FAILED: equalsFalseOnSameSizeDifferentData
	 * 
	 * @param other -- an object to compare to
	 * @return -- true if the Matrices are equivalent and false otherwise (or if the second object isn't a Matrix)
	 */
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object other) {
		if(!(other instanceof Matrix)) { // make sure the Object we're comparing to is a Matrix
			return false;
		}
		Matrix matrix = (Matrix)other; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		
		// returns true if the number of columns and rows are equivalent from this matrix and the other matrix.
		if(matrix.numColumns == this.numColumns && matrix.numRows == this.numRows) {
			return true; 
		}
		
		// else return false
		return false; 	
	}
	
	/**
	 * Converts the Matrix object into a string representation of its data
	 * @return -- string representation of the matrix
	 */
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString() {
		
		// total numbers of rows and columns
		int Totalrows = this.numRows; 
		int Totalcols = this.numColumns;
		
		/** 
		 * A String builder to hold the results. Using a string builder is more optimal 
		 * because the other case of using just a string, the program would have to create 
		 * a new string for every item in the matrix, which is more work.
		 */
		StringBuilder MatrixInString = new StringBuilder();
		 
		// loops through all the items in the row
		for (int CurrentRow = 0; CurrentRow < Totalrows; CurrentRow++) {
			
			// loops through all the items in the columns
			for (int Currentcol = 0; Currentcol < Totalcols; Currentcol++) {
				// give space for each item
				if (Currentcol > 0) MatrixInString.append(" ");
				// add the item to the current string builder
				MatrixInString.append(data[CurrentRow][Currentcol]);
		    }
			// new line for the end of each row
			MatrixInString.append("\n");
		}
		
		// convert the string builder to a string
		return MatrixInString.toString();
	}
	
	/**
	 * Multiplies two matrix objects resulting in a new product matrix
	 * @param matrix -- the right hand side matrix to be multiplied
	 * @return -- the resulting matrix of the multiplication
	 */
	public Matrix times(Matrix matrix) {

		// variables for left and right side rows and columns.
		int leftSideRows = this.numRows;
        int leftSideColumns = this.numColumns;
        int rightSideRows = matrix.numRows;
        int rightSideColumns = matrix.numColumns;
        
        // a matrix to hold the products
        Matrix productMatrix = new Matrix(new int[leftSideRows][rightSideColumns]);

        // if the left side columns is not compatible to the right side rows return null
        if (leftSideColumns != rightSideRows) {
			System.out.println("Sorry but your left side columns and the right side rows are not equivalent.");
			return null;
        }
        
        // iterate through left side row
        for (int currentRow = 0; currentRow < leftSideRows; currentRow++) { 
        	// iterate through right side column
            for (int currentRtCol = 0; currentRtCol < rightSideColumns; currentRtCol++) { 
            	// iterate through left side column
                for (int currentLtCol = 0; currentLtCol < leftSideColumns; currentLtCol++) {
                	// Multiply the rows by columns and then add it to the product matrix.
                	productMatrix.data[currentRow][currentRtCol] += this.data[currentRow][currentLtCol] * matrix.data[currentLtCol][currentRtCol];
                }
            }
        }
        
        // return the result
		return productMatrix; 
	}
	
	/**
	 * Adds two matrix objects together
	 * @param matrix -- the right hand side matrix to be added
	 * @return -- the resulting matrix of the addition
	 */
	public Matrix plus(Matrix matrix) {
	
        // check to see if the rows of both left and right side are not equal, return why it failed and return null
		if (!this.equals(matrix)) {
			System.out.println("Sorry but your left side and right side rows and/or columns are not equivalent.");
			return null;
		}
		
		// total numbers of rows and columns
		int Totalrows = this.numRows; 
		int Totalcols = this.numColumns;
        
		// matrix to hold the sum with the intended width
		Matrix sumMatrix = new Matrix(new int[Totalrows][Totalcols]);
		
		// iterate through the rows
		for (int row = 0; row < Totalrows; row++) {  
			// iterate through the columns
			for(int col = 0; col < Totalcols; col++) {
				// sum up the left side and right side items and add it to the sum matrix
				sumMatrix.data[row][col] += this.data[row][col] + matrix.data[row][col];
			}
		}
		
		// return sum matrix
		return sumMatrix; 
	}
}
