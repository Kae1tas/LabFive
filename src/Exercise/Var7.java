package Exercise;

import java.util.Scanner;
import java.io.*;

public class Var7 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\numbers.txt");
        File f2 = new File("D:\\result.txt");
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
            assert wr != null;
            wr.flush();
            wr.close();
            assert wr2 != null;
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
            if (max != 0) {
                System.out.println("\nНаибольшее число => " + max);
            }
        } catch (IOException ie) {
            System.out.println("Ошибка");
        }
        finally{
            assert rd2 != null;
            rd2.close();
        }

    }
}
