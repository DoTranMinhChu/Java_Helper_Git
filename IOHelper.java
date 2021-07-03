package Helper;

public class IOHelper {
    static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static int InputInt(String msg){
        int value;
        do{
            try{
                System.out.print(msg);value=Integer.parseInt(scanner.nextLine());
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter please [!]");
            }
        }while (true);
    }
    public static int InputInt(String msg,int min){
        int value;
        do{
            try{
                System.out.print(msg);value=Integer.parseInt(scanner.nextLine());
                if(value<min) throw new Exception();
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter please [!]");
            }
        }while (true);
    }
    public static int InputInt(String msg,int min,int max){
        int value;
        do{
            try{
                System.out.print(msg);value=Integer.parseInt(scanner.nextLine());
                if(value<min||value>max) throw new Exception();
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter please [!]");
            }
        }while (true);
    }

    public static float InputFloat(String msg){
        float value;
        do{
            try{
                System.out.print(msg);value=Float.parseFloat(scanner.nextLine());
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter please [!]");
            }
        }while (true);
    }
    public static float InputFloat(String msg,float min){
        float value;
        do{
            try{
                System.out.print(msg);value=Float.parseFloat(scanner.nextLine());
                if(value<min) throw new Exception();
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter please [!]");
            }
        }while (true);
    }
    public static float InputFloat(String msg,float min,float max){
        float value;
        do{
            try{
                System.out.print(msg);value=Float.parseFloat(scanner.nextLine());
                if(value<min||value>max) throw new Exception();
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter please [!]");
            }
        }while (true);
    }

    public static double InputDouble(String msg){
        double value;
        do{
            try{
                System.out.print(msg);value=Double.parseDouble(scanner.nextLine());
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter please [!]");
            }
        }while (true);
    }
    public static double InputDouble(String msg,double min){
        double value;
        do{
            try{
                System.out.print(msg);value=Double.parseDouble(scanner.nextLine());
                if(value<min) throw new Exception();
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter please [!]");
            }
        }while (true);
    }
    public static double InputDouble(String msg,double min,double max){
        double value;
        do{
            try{
                System.out.print(msg);value=Double.parseDouble(scanner.nextLine());
                if(value<min||value>max) throw new Exception();
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter please [!]");
            }
        }while (true);
    }

    public static long InputLong(String msg){
        long value;
        do{
            try{
                System.out.print(msg);value=Long.parseLong(scanner.nextLine());
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter please [!]");
            }
        }while (true);
    }
    public static long InputLong(String msg,long min){
        long value;
        do{
            try{
                System.out.print(msg);value=Long.parseLong(scanner.nextLine());
                if(value<min) throw new Exception();
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter please [!]");
            }
        }while (true);
    }
    public static long InputLong(String msg,long min,long max){
        long value;
        do{
            try{
                System.out.print(msg);value=Long.parseLong(scanner.nextLine());
                if(value<min||value>max) throw new Exception();
                return value;
            }catch (Exception e){
                System.out.println("[!] Re-enter please [!]");
            }
        }while (true);
    }

    public static String InputString(String msg){
        String value;
        System.out.print(msg);value=scanner.nextLine();
        return value;
    }
    public static String InputString(String msg,boolean trim){
        String value;
        System.out.print(msg);value=scanner.nextLine();
        if(trim)return value.trim();
        else return value;
    }
    public static String InputPattern(String msg,String pattern){
        String value;
        do{
            System.out.print(msg);value=scanner.nextLine();
        }while (!value.matches(pattern));
        return value;
    }

}
