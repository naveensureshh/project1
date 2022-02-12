import java.util.*;

public class project1 {

public class main



    

    public static int[] decToBin(int num) {

        if (num < -128 || num > 127) {

            System.out.println("Number out of range");

            return null;

        }



        int[] result = new int[8];



       

        if (num < 0) {

            result[0] = 1; 

        } else {

            result[0] = 0; 

        }



        num = (int) Math.abs(num) % 128;



        for (int i = 7; i > 0; i--) {

            result[i] = num % 2;

            num = num / 2;

        }



        return result;

    }

 

    public static int binToDec(int[] binary) {

        if (binary.length != 8) {

            System.out.println("incorrect binary");

            return 0;

        }



        int num = 0;

        for (int i = 7; i > 0; i--) {

            num = num + binary[i] * (int) Math.pow(2, 7 - i);

        }

        if (num == 0 && binary[0] == 1) {

            return -1;

        }

        if (binary[0] == 1) {

            num = -1 * num;

        }



        return num;

    }

 

    public static int[] comp1s(int[] binary) {

        int result[] = new int[8];

        for (int i = 7; i > 0; i--) {

            if (binary[i] == 1)

                result[i] = 0;

            else if (binary[i] == 0)

                result[i] = 1;

        }

        result[0] = binary[0];

        return result;



    }





    public static int[] comp2s(int[] binary) {

        int result[] = new int[8];

        boolean flag = true;

        for (int i = 7; i > 0; i--) {

            if (flag && binary[i] == 0) {

                result[i] = 0;

                continue;

            } else if (flag && binary[i] == 1) {

                result[i] = 1;

                flag = false;

                continue;

            }

            if (binary[i] == 1)

                result[i] = 0;

            else if (binary[i] == 0)

                result[i] = 1;

        }

        result[0] = binary[0];

        return result;



    }

    public static int[] excess128(int[] bin1) {

        int carry = 0;

        int[] bin2 = { 1, 0, 0, 0, 0, 0, 0, 0 };

        int result[] = new int[8];



        for (int i = 7; i >= 0; i--) {

            result[i] = (bin1[i] + bin2[i] + carry) % 2;

            carry = (bin1[i] + bin2[i] + carry) / 2;

        }

        return result;

    }

    public static String arrToStr(int[] arr) {

        String result = "";

        for (int i = 0; i < arr.length; i++) {

            result = result + arr[i];

            if (i == 3) {

                result = result + " ";

            }

        }

        return result;

    }

    public static void main(String[] args) {

        int choice = 0;

        Scanner sc = new Scanner(System.in);

        int n = 0;



        do {



            System.out.println("Enter 1 to enter an 8-bit string");

            System.out.println("Enter 2 to enter a signed decimal integer (-128, +127).");

            System.out.println("Enter 3 to quit");

            System.out.print("Enter your choice:  ");

            choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {

            case 1:

                System.out.print("Enter 8-bit String Input: ");

                String input = sc.nextLine();

                boolean flag = true;

                int num[] = new int[8];

                if (input.length() != 8) {

                    System.out.println("Incorrect input");

                } else {



                    for (int i = 0; i < 8; i++) {

                        num[i] = input.charAt(i) - 48;

                        if (!(num[i] == 0 || num[i] == 1)) {

                            System.out.println("Incorrect input");

                            flag = false;

                            break;

                        }

                    }

                }

                if (flag) {

                    System.out.println("signed magnitude: " + binToDec(num));

                    System.out.println("ones complement: " + binToDec(comp1s(num)));

                    System.out.println("twos complement: " + binToDec(comp2s(num)));

                    System.out.println("excess-128 notation: " + binToDec(excess128(num)));

                }



                break;

            case 2:

               

                    System.out.print("Enter a signed decimal integer (-128, +127): ");

                    n = sc.nextInt();



                    if (n < -128 || n > 127) {

                        System.out.println("incorrect i/p");

                    } else {



                        System.out.println("signed magnitude: " + arrToStr(decToBin(n)));

                        System.out.println("ones complement: " + arrToStr(comp1s(decToBin(n))));

                        System.out.println("twos complement: " + arrToStr(comp2s(decToBin(n))));

                        System.out.println("excess-128 notation: " + arrToStr(excess128(comp2s(decToBin(n)))));

                    }



                    break;

            case 3:

                System.out.println("program ends");

                break;

            default:

                System.out.println("no input");

                break;

        }



    } while (choice != 3);

}

}
