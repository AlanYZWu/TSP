/**
 * Name: Alan Wu
 * Pennkey: wualan
 * Execution: java Tour int numPoints
 *
 * Description: Class that creates the Tour object and its related methods
**/

public class Tour implements TourInterface {
    Node head; // First node in chain
    Node lastNode; // Last node in chain
    
    /*
     * Constructor: Creates new instance of Tour object
     */ 
    public Tour() {
        lastNode = new Node(null, null);
        head = new Node(lastNode, null);
    }
    
    /**
     * Input: None
     * Output: String stringRepresentation
     * Description: Return a string representation of points in the tour, in order
     *              @return string representation of points in the tour, in order
     */
    public String toString() {
        // If Tour is empty
        if (this.head.point == null) {
            return "";
        } else { // If Tour is not empty
            String s = ""; // String to be returned
            Node curr = head; // Node that iterates over list
        
            // Iterating loop, stops at last node
            while (curr.next != null) {
                s += curr.point.toString(); // Adds point to s
                curr = curr.next; // Sets curr to curr.next
            }
            s += curr.point.toString(); // Adds last node to string
        
            return s;
        }
    }

    /**
     * Input: Point p
     * Output: None 
     * Description: Draws the tour @param p draws any edge whose start or end 
     *              point is p in a different color
     */
    public void draw(Point p) {
        if (this.head.point == null) { // If tour is empty
            return;
        } else { // If tour is not empty
            // Iterating loop
            for (Node curr = head; curr.next != null; curr = curr.next) {
                // Checks if lines are being drawn to or from. Point p
                if (curr.next.point == p || curr.point == p) { 
                    PennDraw.setPenColor(PennDraw.RED);
                }    
                curr.point.drawTo(curr.next.point); // Draws line
                PennDraw.setPenColor(PennDraw.BLACK); // Resets pen color
            }
        }
    }
        

    /**
     * Input: None
     * Output: int size
     * Description: Returns the number of points in the tour
     *              @return the number of points in the tour
     */
    public int size() {
        int count = 0; // Counter for number of nodes
        Node curr = this.head; // Iterating node
        
        // Checks if tour is empty 
        if (head.point == null) {
            return 0;
        }
        
        // Checks if head is initialized
        if (curr.next == null && head.point != null) {
            count = 1;
        }
        
        // Iterating loop
        while (curr.next != null) {
            count++; // Increase count every iteration
            curr = curr.next; // Updates curr
        } 
        
        return count;
    }

    /**
     * Input: None
     * Output: double distance
     * Description: Returns the total length of the tour
     *              @return the total length of the tour
     */
    public double distance() {
        double distance = 0; // Returned value
        
        // Checks if tour is empty
        if (head.point == null) {
            return 0;
        }
        
        // Iterating loop
        for (Node curr = head; curr.next != null; curr = curr.next) {
            distance += curr.point.distanceTo(curr.next.point); // Updates distance
        }
        
        return distance;
    }

    /**
     * Input: Point p
     * Output: None 
     * Description: Insert p at the end of the tour; does nothing if p is null
     *              @param p the point to add to the tour
     */
    public void insertInOrder(Point p) {
        if (p != null) { // Checks if p is null
            // Tour is empty
            if (this.head.point == null) {
                head.point = p; // Initializes head.point
                lastNode.point = head.point; // Initialize lastNode.point
            } else { // Tour is not empty
                Node curr = this.head; // Iterating node
                int i = 1; // Index of current node
                
                // Iterates to end of Tour
                while (i < this.size()) {
                    curr = curr.next; // Updates curr
                    i++; // Updates index
                }
                
                Node newNode = new Node(lastNode, p); // New node to be inserted
                curr.next = newNode; // Sets curr.next to be the new node
            }    
        }
    }

    /**
     * Input: Point p
     * Output: None
     * Description: Insert p after the point to which it is closest; does nothing 
     *              if p is null @param p the point to add to the tour
     */
    public void insertNearest(Point p) { 
        if (p != null) { // Checks if p is null
            // If tour is empty
            if (this.head.point == null) {
                head.point = p; // Initializes head.point
                lastNode.point = head.point; // Initializes lastNode.point
            } else { // If tour is not empty
                double shortDist = Double.MAX_VALUE; // Shortest distance found
                
                // Iterating loop
                for (Node curr = head; curr.next != null; curr = curr.next) {
                    // Checks if curr's closer to p than current stored distance
                    if (curr.point.distanceTo(p) < shortDist) { 
                        shortDist = curr.point.distanceTo(p);
                    }
                }
                
                // Iterating loop
                for (Node curr = head; curr.next != null; curr = curr.next) {
                    // Finds first point with shortest distance
                    if (curr.point.distanceTo(p) == shortDist) {
                        // Adds new node after shortest distance
                        Node newNode = new Node(curr.next, p);
                        curr.next = newNode;
                        break;
                    }
                }
            }
        }
    }


    /**
     * Input: Point p
     * Output: None
     * Description: Insert p where it will cause the shortest detour; does nothing 
     *              if p is null @param p the point to add to the tour
     */
    public void insertSmallest(Point p) {
        if (p != null) { // Checks if p is null
            if (this.head.point == null) { // If tour is empty
                head.point = p; // Initializes head.point
                lastNode.point = head.point; // Initializes lastNode.point
            } else { // If tour is not empty
                double incDist = Double.MAX_VALUE; // Stored smallest distance
                
                // Iterating loop
                for (Node curr = head; curr.next != null; curr = curr.next) {
                    // Checks if curr to p would have a new smallest distance
                    if (curr.point.distanceTo(p) + p.distanceTo(curr.next.point) - 
                        curr.point.distanceTo(curr.next.point) < incDist) {
                        incDist = curr.point.distanceTo(p) + 
                            p.distanceTo(curr.next.point) - 
                            curr.point.distanceTo(curr.next.point);
                    }
                }
                
                // Iterating loop
                for (Node curr = head; curr.next != null; curr = curr.next) {
                    // Finds first node with matching shortest distance
                    if (curr.point.distanceTo(p) + p.distanceTo(curr.next.point) - 
                        curr.point.distanceTo(curr.next.point) == incDist) {
                        // Inserts node
                        Node newNode = new Node(curr.next, p);
                        curr.next = newNode;
                        break;
                    }
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        // Tests printing empty tour
        Tour t = new Tour();
        System.out.println(t);
        
        // Adds points
        Point a = new Point(0, 0);
        Point b = new Point(0.5, 0.1);
        Point c = new Point(0.6, 0.7);
        Point d = new Point(0.2, 0.9);
        
        // Draws different number of points based on commandLineArguments
        if (Integer.parseInt(args[0]) == 0) {
            t.draw(null);
        } else if (Integer.parseInt(args[0]) == 1) {
            t.insertInOrder(a);
            t.draw(a);
        } else if (Integer.parseInt(args[0]) == 2) {
            t.insertInOrder(a);
            t.insertInOrder(b);
            t.draw(a);
        } else if (Integer.parseInt(args[0]) == 4) {
            t.insertInOrder(a);
            t.insertInOrder(b);
            t.insertInOrder(c);
            t.insertInOrder(d);
            t.draw(c);
        }

        // Prints the tour
        System.out.println(t);
    }
}