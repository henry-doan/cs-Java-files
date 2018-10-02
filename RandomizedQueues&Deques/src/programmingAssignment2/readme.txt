/******************************************************************************
 *  Name:	Henry Doan
 *  NetID:   
 *  Precept: 
 *
 *  Partner Name:	Sara Alaskarova  
 *  Partner NetID:    
 *  Partner Precept:  
 *
 *  Hours to complete assignment (optional): 
 *
 ******************************************************************************/

Programming Assignment 2: Deques and Randomized Queues


/******************************************************************************
 *  Explain briefly how you implemented the randomized queue and deque.
 *  Which data structure did you choose (array, linked list, etc.)
 *  and why?
 *****************************************************************************/
	For the Deque we have used linked list because we can treat each item as a node 
	and have methods to manipulate the nodes. For Randomized queue we have used 
	and Items array to make the random function easier with an array and resizing.

/******************************************************************************
 *  How much memory (in bytes) do your data types use to store n items
 *  in the worst case? Use the 64-bit memory cost model from Section
 *  1.4 of the textbook and use tilde notation to simplify your answer.
 *  Briefly justify your answers and show your work.
 *
 *  Do not include the memory for the items themselves (as this
 *  memory is allocated by the client and depends on the item type)
 *  or for any iterators, but do include the memory for the references
 *  to the items (in the underlying array or linked list).
 *****************************************************************************/

Randomized Queue:   ~  48N bytes

Deque:              ~  48N bytes


From the documentation for the assignment description.
	48n + 192
	remove constant
	48N
/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
	The Program is casted to Item generic.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
	Sara help solve the assignment by co thinking of an algorithm to make the 
	data structures.
	


/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/
	We both figured out what each method wants to accomplished and figure out
	an algorithm to solve each method to make the data types.


/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
	None


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
 	I learned that you can use other data structure to build more data structures.