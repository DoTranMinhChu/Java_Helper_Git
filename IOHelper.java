package Helper;

public class IOHelper {
    public static int IsnputInt(String msg){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int value;
        do{
            try{
                System.out.print(msg);value=Integer.parseInt(scanner.nextLine());
                scanner.close();
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter integer please [!]");
            }
        }while (true);
    }
    public static float InputFloat(String msg){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        float value;
        do{
            try{
                System.out.print(msg);value=Float.parseFloat(scanner.nextLine());
                scanner.close();
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter real number please [!]");
            }
        }while (true);
    }
    public static double InputDouble(String msg){
        double value;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        do{
            try{
                System.out.print(msg);value=Double.parseDouble(scanner.nextLine());
                scanner.close();
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter real number please [!]");
            }
        }while (true);
    }
    public static long InputLong(String msg){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        long value;
        do{
            try{
                System.out.print(msg);value=Long.parseLong(scanner.nextLine());
                scanner.close();
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter real number please [!]");
            }
        }while (true);
    }

    public static String InputString(String msg){
        String value;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print(msg);value=scanner.nextLine();
        scanner.close();
        return value;
    }
    public static String InputString(String msg,boolean trim){
        String value;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print(msg);value=scanner.nextLine();
        scanner.close();
        if(trim)return value.trim();
        else return value;
    }
    public static String InputPattern(String msg,String pattern){
        String value;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        do{
            System.out.print(msg);value=scanner.nextLine();
        }while (!value.matches(pattern));

        scanner.close();
        return value;
    }

}
