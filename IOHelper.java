package Helper;

public class IOHelper {
    public static int IsnputInt(String mess){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        do{
            int value;
            try{
                System.out.print(mess);value=Integer.parseInt(scanner.nextLine());
                scanner.close();
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter integer please [!]");
            }
        }while (true);
    }
    public static float InputFloat(String mess){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        do{
            float value;
            try{
                System.out.print(mess);value=Float.parseFloat(scanner.nextLine());
                scanner.close();
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter real number please [!]");
            }
        }while (true);
    }
    public static double InputDouble(String mess){
        do{
            double value;
            try{
                java.util.Scanner scanner = new java.util.Scanner(System.in);
                System.out.print(mess);value=Double.parseDouble(scanner.nextLine());
                scanner.close();
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter real number please [!]");
            }
        }while (true);
    }

    public static String InputString(String mess){
        String value;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print(mess);value=scanner.nextLine();
        scanner.close();
        return value;
    }
    public static String InputString(String mess,boolean trim){
        String value;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print(mess);value=scanner.nextLine();
        scanner.close();
        if(trim)return value.trim();
        else return value;
    }
    public static String InputPattern(String mess,String pattern){
        String value;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        do{
            System.out.print(mess);value=scanner.nextLine();
        }while (!value.matches(pattern));

        scanner.close();
        return value;
    }

}
