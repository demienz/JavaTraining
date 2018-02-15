package addBinary;

/**
 * Description:
 * Add binary numbers
 * 
 * @author edampaw
 */
public class Training {

    public static void main(String[] args) {
        String input0 = "11";
        String input1 = "1";

        int number0 = Integer.parseInt(input0, 2);
        int number1 = Integer.parseInt(input1, 2);

        int sum = number0 + number1;
        System.out.println(Integer.toBinaryString(sum));
    }

}
