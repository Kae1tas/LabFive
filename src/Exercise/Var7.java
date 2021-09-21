package Exercise;

import java.util.Scanner;
import java.io.*;

public class Var7 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\файлы 1\\numbers.txt");
        File f2 = new File("D:\\файлы 1\\result.txt");
        DataOutputStream wr = null;
        DataInputStream rd = null;
        DataOutputStream wr2 = null;
        DataInputStream rd2 = null;
        Scanner sc = new Scanner(System.in);
        double max = 0;
        try {
            if(f1.exists()) f1.createNewFile();
            f2.createNewFile();

            wr = new DataOutputStream(new FileOutputStream(f1));
            System.out.println("Введите длину");
            int count = sc.nextInt();
            for (int i = 0; i < count; i++) {
                double number = sc.nextInt();
                wr.writeDouble(number);
            }

            rd = new DataInputStream(new FileInputStream(f1));
            wr2 = new DataOutputStream(new FileOutputStream(f2));

            double j;
            while (true){
                j = rd.readDouble();
                if (j > 0) {
                    wr2.writeDouble(j);
                }
            }
        } catch (EOFException eofException) {

        } catch(IOException ioException) {
            System.out.println("Не создан файл");
        }
        finally {
            wr.flush();
            wr.close();
            wr2.flush();
            wr2.close();
            rd.close();
        }
        try {
            rd2 = new DataInputStream(new FileInputStream(f2));
            double n;
            while (true) {
                n = rd2.readDouble();
                System.out.print(n + "   ");
                if (n > max)
                    max = n;
            }
        } catch (EOFException eofException) {
            System.out.println("\nНаибольшее число => " + max);
        } catch (IOException ie) {

        }

    }
}