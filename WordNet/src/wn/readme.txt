/******************************************************************************
 *  Name: Henry Doan    
 *  NetID:    
 *  Precept:  
 *
 *  Partner Name: Jeneve Castro, Tatiana Nicoara, Dimitar Ivanov    
 *  Partner NetID:    
 *  Partner Precept:  
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 6: WordNet


/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in synsets.txt. Why did you make this choice?
 *****************************************************************************/
	We used two Separate Chaining Hash Symbol Tables because for the helper 
	methods it provided.



/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in hypernyms.txt. Why did you make this choice?
 *****************************************************************************/
 	Hypernymns data was stored in a Digraph to display the correct
 	representation of the nouns lists.


/******************************************************************************
 *  Describe concisely the algorithm you use in the constructor of
 *  ShortestCommonAncestor to check if the digraph is a rooted DAG.
 *  What is the order of growth of the worst-case running times of
 *  your algorithms as a function of the number of vertices V and the
 *  number of edges E in the digraph?
 *****************************************************************************/

Description: The isRootedDAG method checks the digraph is a DAG and
the paths of the vertices.



Order of growth of running time:
V + E

/******************************************************************************
 *  Describe concisely your algorithm to compute the shortest common
 *  ancestor in ShortestCommonAncestor. For each method, what is the order of
 *  growth of the worst-case running time as a function of the number of
 *  vertices V and the number of edges E in the digraph? For each method,
 *  what is the order of growth of the best-case running time?
 *
 *  If you use hashing, you should assume the uniform hashing assumption
 *  so that put() and get() take constant time.
 *
 *  Be careful! If you use a BreadthFirstDirectedPaths object, don't
 *  forget to count the time needed to initialize the marked[],
 *  edgeTo[], and distTo[] arrays.
 *****************************************************************************/

Description: To find the shortest common ancestor, two BreadthFirstDirectedPaths
	are created and a loop is created searches for an ancestor in reversePost order
	and find th ancestor with the shortest distance.

                                              running time
method                               best case            worst case
------------------------------------------------------------------------
length(int v, int w)                   V + E              any multiples of V

ancestor(int v, int w)                 V + E              any multiples of V

length(Iterable<Integer> v,            V + E              any multiples of V
       Iterable<Integer> w)

ancestor(Iterable<Integer> v,          V + E              any multiples of V
         Iterable<Integer> w)




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
Needs files to test.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
Jeneve Castro, Tatiana Nicoara, Dimitar Ivanov we all did the same amount of work and
split the task and worked on different parts of the assignments

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
none.

/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/
Jeneve Castro, Tatiana Nicoara, Dimitar Ivanov we all did the same amount of work and
split the task and worked on different parts of the assignments



/**********************************************************************
 *  Have you completed the mid-semester survey? If you haven't yet,
 *  please complete the brief mid-course survey at https://goo.gl/gB3Gzw
 * 
 ***********************************************************************/
N/A

/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/