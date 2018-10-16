/******************************************************************************
 *  Name: Henry Doan     
 *  NetID:    
 *  Precept:  
 *
 *  Partner Name: Tatiana Nicoara  
 *  Partner NetID:      
 *  Partner Precept:    
 *
 *  Hours to complete assignment (optional):8
 *
 ******************************************************************************/

Programming Assignment 3: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
It splits the array in two and checks both sides for the prefix and continue recursively
to split through the arrays and checks both side and then return the first instance of
finding the prefix.

/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: NlogN
	sorting the array and copying items to the array

allMatches(): logN + NlogN
	two binary searches
	and sorts the array and copies the items
	
numberOfMatches(): logN
	two binary searches




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
Couldn't get the project to work with the provided cities and wikitionary text files
but did get it to work with test cases.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
worked with Tatiana Nicoara and used the web and stack overflow to save the problem.

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
Couldn't get the project to work with the provided cities and wikitionary text files
but did get it to work with test cases.

/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/
We both worked on the code and figuring out the algorithm to this project.






/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/

  