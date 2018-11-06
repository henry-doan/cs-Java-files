/******************************************************************************
 *  Name:	Henry Doan
 *  NetID:    
 *  Precept:  
 *
 *  Partner Name:  Jeneve Castro, Tatiana Nicoara, Dimitar Ivanov     
 *  Partner NetID:      
 *  Partner Precept:    
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 4: Slider Puzzle


/******************************************************************************
 *  Explain briefly how you implemented the Board data type.
 *****************************************************************************/
Created a virtual board  with the needed methods



/******************************************************************************
 *  Explain briefly how you represented a search node
 *  (board + number of moves + previous search node).
 *****************************************************************************/
A Block, contains a board, number of moves to get to that board, and the 
previous board. the previous board traces up to give the full solution and 
with the priority queue.






/******************************************************************************
 *  Explain briefly how you detected unsolvable puzzles.
 *
 *  What is the order of growth of the running time of your isSolvable()
 *  method as function of the board size n? Recall that with order-of-growth
 *  notation, you should discard leading coefficients and lower-order terms,
 *  e.g., n log n or n^3.

 *****************************************************************************/

Description:
isSolvable() counts the number of inversions seeing if everything is in place.


Order of growth of running time:



/******************************************************************************
 *  For each of the following instances, give the minimum number of moves to
 *  solve the instance (as reported by your program). Also, give the amount
 *  of time your program takes with both the Hamming and Manhattan priority
 *  functions. If your program can't solve the instance in a reasonable
 *  amount of time (say, 5 minutes) or memory, indicate that instead. Note
 *  that your program may be able to solve puzzle[xx].txt even if it can't
 *  solve puzzle[yy].txt even if xx > yy.
 *****************************************************************************/


                 min number          seconds
     instance     of moves     Hamming     Manhattan
   ------------  ----------   ----------   ----------
   puzzle28.txt 
   puzzle30.txt 
   puzzle32.txt 
   puzzle34.txt 
   puzzle36.txt 
   puzzle38.txt 
   puzzle40.txt 
   puzzle42.txt 



/******************************************************************************
 *  If you wanted to solve random 4-by-4 or 5-by-5 puzzles, which
 *  would you prefer: a faster computer (say, 2x as fast), more memory
 *  (say 2x as much), a better priority queue (say, 2x as fast),
 *  or a better priority function (say, one on the order of improvement
 *  from Hamming to Manhattan)? Why?
 *****************************************************************************/
I think a faster and more memory computer will handle anything with the same algorthims.
But with current computer you would need a better priority function to solve it




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
Couldn't test the puzzle text files.


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
Jeneve Castro, Tatiana Nicoara, Dimitar Ivanov helped a lot and spliting up the 
program and algorithms.




/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
Couldn't test the puzzle text files.



/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/
Jeneve Castro, Tatiana Nicoara, Dimitar Ivanov we all did the same amount of work and
split the task and worked on different parts of the assignments






/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/