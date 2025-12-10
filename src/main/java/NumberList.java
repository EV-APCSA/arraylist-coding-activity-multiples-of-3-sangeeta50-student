import java.util.ArrayList;

/**
 * Last name:
 * First name:
 * Student ID:
 * Period:
 *
 * Write a short program to create an ArrayList to print the first 100 multiples of 3
 * starting with 0.
 *
 * Do the following:
 *
 * 1. Create the multiplesOf3 method that creates and returns a list of first 100 multiples of 3.
 * 2. Write the toString method that takes a list of values and returns the list as a String so
 *    that it can be printed in a tabular format with 10 numbers on each row.
 * 3. Write the removeEvens method that removes all the evens from the given list.
 */
public class NumberList {

    /**
     * Creates and returns a list consisting of first 100 multiples of 3.
     * @return list containing multiples of 3
     */
    public ArrayList<Integer> multiplesOf3() {
        ArrayList<Integer> threes = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            threes.add(3 * i);
        }
        return threes;
    }

    /**
     * Converts the given list to a String. When the string is printed, it
     * prints a sequence of 10 numbers per line.
     * @param list - list of numbers to be converted
     * @return String containing the list of numbers to print 10 numbers per line
     */
    public String toString(ArrayList<Integer> list) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\t");
            count++;
            if (count % 10 == 0) {
                // end of a row
                sb.append("\n");
            }
        }

        return sb.toString().trim();
    }

    /**
     * Removes all the evens from list
     * @param list - list of numbers
     */
    public void removeEvens(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--; // step back so we don't skip the next element
            }
        }
    }
}
