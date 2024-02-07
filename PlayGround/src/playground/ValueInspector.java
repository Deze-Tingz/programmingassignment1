package playground;
import java.util.Scanner;

public class ValueInspector {

   public static boolean inspectValues(Scanner scnr) {
      boolean isValid = true;
     int valueRead = scnr.nextInt();
     
       while (valueRead < 1) {
      valueRead = scnr.nextInt();
      
      if (valueRead >= 0) { // If the value is zero or positive, it's not all negative
         isValid = false;
         
      }
      
      
      }
      return isValid;
      }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      boolean allNegative;
      
      allNegative = inspectValues(scnr);
      if (allNegative) {
			System.out.println("All true");
		}
		else {
			System.out.println("Not all true");
		}
   }
}