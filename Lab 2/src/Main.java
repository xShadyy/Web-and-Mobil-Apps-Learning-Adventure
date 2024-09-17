import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //====================
        // Zadanie 4.1
        //====================

        File f = new File("C:\\Users\\student\\Videos\\JavaLearning\\Lab2\\liczby.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));

        if (br.ready()) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                int a = Integer.parseInt(line);
                float l = (float) (Math.log(a) / Math.log(3));
                if (l == (int) l) {
                    count++;
                }
            }

            System.out.println("Ilosc poteg liczby 3 w pliku liczby.txt: " + count);

            FileWriter writer = new FileWriter("C:\\Users\\student\\Videos\\JavaLearning\\Lab2\\wynik.txt");
            String data = "Odpowiedź do zadania 4 wynosi: " + count;
            writer.write(data);
            writer.close();
            br.close();
        }

        //====================
        // Zadanie 4.2
        //====================

        br = new BufferedReader(new FileReader(f));

        if (br.ready()) {
            String line;

            while ((line = br.readLine()) != null) {
                if (sprawdzWarunek(line)) {
                    System.out.println("Liczba spełniająca warunek z zadania 4.2: " + line);
                }
            }
        }

        br.close();

        //====================
        // Zadanie 4.3
        //====================

        br = new BufferedReader(new FileReader(f));

        List<Integer> liczby = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            liczby.add(Integer.parseInt(line));
        }
        br.close();


        int najlepszaPierwszaLiczba = 0;
        int najlepszaDlugoscCiagu = 0;
        int najlepszyNWD = 0;


        for (int i = 0; i < liczby.size(); i++) {
            int obecnyNWD = liczby.get(i);
            int dlugoscCiagu = 1;

            for (int j = i + 1; j < liczby.size(); j++) {
                obecnyNWD = nwd(obecnyNWD, liczby.get(j));
                if (obecnyNWD > 1) {
                    dlugoscCiagu++;
                } else {
                    break;
                }
            }

            if (dlugoscCiagu > najlepszaDlugoscCiagu) {
                najlepszaPierwszaLiczba = liczby.get(i);
                najlepszaDlugoscCiagu = dlugoscCiagu;
                najlepszyNWD = obecnyNWD;
            }
        }

        System.out.println("Pierwsza liczba w najdłuższym ciągu: " + najlepszaPierwszaLiczba);
        System.out.println("Długość ciągu: " + najlepszaDlugoscCiagu);
        System.out.println("Największy wspólny dzielnik: " + najlepszyNWD);

        FileWriter writer = new FileWriter("C:\\Users\\student\\Videos\\JavaLearning\\Lab2\\wynik.txt");
        writer.write("Pierwsza liczba w najdłuższym ciągu: " + najlepszaPierwszaLiczba + "\n");
        writer.write("Długość ciągu: " + najlepszaDlugoscCiagu + "\n");
        writer.write("Największy wspólny dzielnik: " + najlepszyNWD + "\n");
        writer.close();
    }

    public static int nwd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return nwd(b, a % b);
    }



    public static int silnia(int n) {
        if (n == 0)
            return 1;
        return silnia(n - 1) * n;
    }

    static boolean sprawdzWarunek(String line) {
        int n = Integer.parseInt(line);
        int sum = 0;
        int temp = n;

        while (temp > 0) {
            sum += silnia(temp % 10);
            temp /= 10;
        }
        return sum == n;
    }
}
