/**********************************************************************
 *  readme template                                                   
 *  Traveling Salesperson Problem
 **********************************************************************/

Name: Alan Wu
PennKey: wualan
Hours to complete assignment (optional): 5


/**********************************************************************
 *  Please list all help, collaboration, and outside resources
 *  you used here. 
 *
 *  If you did not get any help in outside of TA office hours,
 *  and did not use any materials outside of the standard
 *  course materials and piazza, write the following statement below:
 *  "I did not receive any help outside of TA office hours.  I
 *  did not collaborate with anyone, and I did not use any
 *  resources beyond the standard course materials."
 **********************************************************************/
I did not receive any help outside of TA office hours. I did not colaborate
with anyone, and I did not use any resources beyond the standard course materials.



/**********************************************************************
 *  Explain how you implemented the nearest insertion heuristic.
 **********************************************************************/
I first iterated over the entire existing tour and found the point that had the 
smallest distance between it and point p. I stored that distance as a double. Then
I went back and interated through the entire tour again, stopping on the point that
has matches the stored distance. It inserts a point after the matching point.

/**********************************************************************
 *  Explain how you implemented the smallest insertion heuristic.
 *  It's sufficient to list only the differences between this
 *  heuristic and the nearest insertion heuristic.
 **********************************************************************/
Does the same thing as insertion except it calculates the smallest change in
distance instead of the smallest distance straight up.


/**********************************************************************
 *  Fill in the distances computed by your heuristics.                
 **********************************************************************/

data file        order     nearest     smallest      extra credit
-----------------------------------------------------------------------
tsp10.txt       2586.7.     1556.1.    1655.7
tsp100.txt      25547       7389.9      4887.2 
tsp1000.txt   3.2769e+15    27869       17266
usa13509.txt  3.9108e+06    77450      45075




 
 /**********************************************************************
 *  Why is it a good idea to repeat the first Node at the end of the
 *  Tour?
 **********************************************************************/
It's a good idea because the fundamentally this problem is about a sales person
finding the shortest route that returns home. The repeated first node represents 
him returning home. Functionally, the closes the drawing basically and also helps
with certain function calculations.
 

 
/**********************************************************************
 *  If you did the extra credit, explain your heuristic, and how
 *  you went about implementing it.
 **********************************************************************/


 
 
 
/**********************************************************************
 *  If you did the extra credit, give instructions here for 
 *  running it.
 **********************************************************************/



 
/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
Runtime for large amounts of points and also my screen was sometimes not big
enough to display the entire drawing and information like distance and size.



/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/

 
 
 
