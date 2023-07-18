/* Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals 
that are covered by another interval in the list... The interval [a, b) is covered by the interval [c, d) if and 
only if c <= a and b <= d... Return the number of remaining intervals...
* Eg 1 : Input = [[1,4],[3,6],[2,8]]                      Output = 2
* Eg 2 : Input = [[1,4],[2,3]]                            Output = 1
 */
import java.util.*;
public class Covered
{
      public int CoeveredIntervals(int intervals[][])
      {
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));  //! Sorting => O(N log N)
            int i = 1;
            int Intervals = 0;       //*  Variables => O(1)
            int start = intervals[0][0], end = intervals[0][1];   //* Variables => O(1)
            while(i < intervals.length)     //! Comparison => O(N)
            {
                  if((intervals[i][0] > start) && (end > intervals[i][1]))
                  {     // If two intervals are overlapping...
                        Intervals++;
                        start = intervals[i][0];    // change the start index...
                        end = intervals[i][1];      // change the end index...
                  }
                  else if((end > intervals[i][1]) && (start == intervals[i][0]))
                        end =intervals[i][1];     // If start is same, but overlapping from end...
                  i++;
            }
            return Intervals;    // Returning the number of Overlaps...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter number of pairs (Intervals) : ");
            x = sc.nextInt();
            int array[][] = new int[x][2];
            for(int i = 0; i < array.length; i++)
            {
                  System.out.print("Enter start : ");
                  array[i][0] = sc.nextInt();
                  System.out.print("Enter stop : ");
                  array[i][1] = sc.nextInt();
            }
            Covered covered = new Covered();    // Object creation...
            System.out.println("The Total Number of Intervals : "+covered.CoeveredIntervals(array));
            sc.close();
      }
}


//! Time Complexity => O(N log N)
//* Space Complexity => O(1)

/** //? DEDUCTIONS :-
 * ? Sort the array in increasing order on the basis of start time of each interval...
 * ? Then we compare two adjacent intervals to check if they overlap...
 */