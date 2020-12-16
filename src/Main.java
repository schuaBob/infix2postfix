import java.util.Scanner;
import utils.Transfer;
/**
 * JDK version:11.0.2
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("Enter Infix or 0 to eixt:");
        Scanner scannerObj = new Scanner(System.in);
        String inputObj = scannerObj.nextLine();
        while (!"0".equals(inputObj)) {
            Transfer tfer = new Transfer();
            String res = tfer.transfer(inputObj);
            System.out.println(res);
            System.out.print("Enter Infix or 0 to eixt:");
            inputObj = scannerObj.nextLine();

        }
        scannerObj.close();
        System.out.print("Bye!");
    }
}
