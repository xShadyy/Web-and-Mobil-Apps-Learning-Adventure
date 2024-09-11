import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        //====================
        //Zadanie 4.1
        //====================

        File f = new File("C:\\Users\\student\\Videos\\JavaLearning\\Lab2\\liczby.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        if (br.ready()) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                int a = Integer.parseInt(line);
                float l = (float)(Math.log(a) / Math.log(3));
                if (l == (int) l) {
                    count++;
                }
            }
            System.out.println("Ilosc poteg liczby 3 w pliku liczby.txt:" + count);

            FileWriter writer = new FileWriter("C:\\Users\\student\\Videos\\JavaLearning\\Lab2\\wynik.txt");
            String data = "Odpowiedź do zadania 4 wynosi: " + count;
            writer.write(data);
            writer.close();
            br.close();
        }
        //====================
        //Koniec zadania 4.1
        //====================
    }
    //====================
    //Zadanie 4.2
    //====================

    public static int silnia(int n) {
        if (n == 0)
            return 1;
        return silnia(n - 1) * n;
    }

    static boolean sprawdzWarunek(String line) {
        int n = Integer.parseInt(line);
        int sum = 0;
        while (n > 0) {
            sum += silnia(n % 10);
            n /= 10;
        }
        return sum == Integer.parseInt(line);
    }

    BufferedReader br = new BufferedReader(new FileReader(f));
    if (br.ready()) {
        String line;

        while ((line = br.readLine()) != null) {
            if (sprawdzWarunek(line)) {
                    System.out.println(line);
            }
        }
    }

    br.close();
}
