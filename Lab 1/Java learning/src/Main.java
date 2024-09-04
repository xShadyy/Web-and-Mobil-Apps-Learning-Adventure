import java.util.Scanner;
class Reverse {

    public static void main(String[] args)
    {
        String str;
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj stringa do reverse'a: ");
        str=scan.nextLine();
        System.out.print("Reverse stringa:  '"+str+"' is :");
        int i = str.length();
        while (i>0) {
            System.out.print(str.charAt(i - 1));
            i--;
        }
    }
}
