import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {

    public static void main(String args[]){
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.print("Enter expression : ");
                String input = br.readLine();

                if (input.equals("exit")) {
                    System.out.println("Exit!");
                    System.exit(0);
                }

                if (input.equals("help") || input.equals("?") || input.equals("h") || input.isEmpty()) {
                    System.out.println("enter expression");
                    System.out.println("available operators");
                    System.out.println("+ - * / ^");
                    System.out.println("or print exit");
                    continue;
                }

                Calc calc = new Calc();
                System.out.println(calc.calculate(input));



            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
