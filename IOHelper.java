package Helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IOHelper {
    static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /*
    Parameter:
        'msg' is the message print before enter data
    Note:
       The function will ask for re-enter until you enter the correct integer
       And return value entered
    */
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



    /*
    Parameter:
        'msg' is the message print before enter data
        'min' is minimum value you can enter
    Note:
       The function will ask for re-enter until you enter the correct
       And return value entered
    */
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




    /*
    Parameter:
        'msg' is the message print before enter data
        'min' is minimum value you can enter
        'max' is maximum value you can enter
    Note:
       The function will ask for re-enter until you enter the correct
       And return value entered
    */
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




    /*
    Parameter:
        'msg' is the message print before enter data
    Note:
       Return value entered
    */
    public static String InputString(String msg){
        String value;
        System.out.print(msg);value=scanner.nextLine();
        return value;
    }

    /*
   Parameter:
       'msg' is the message print before enter data
       'trim' set 'true' when you want removes whitespace from both ends of a string
   Note:
      Return value entered after handling
   */
    public static String InputString(String msg,boolean trim){
        String value;
        System.out.print(msg);value=scanner.nextLine();
        if(trim)return value.trim();
        else return value;
    }





    /*
    Parameter:
        'msg' is the message print before enter data
        'pattern' is regular expression patterns
    Note:
       The function will ask for re-enter until you enter the correct
       And return value entered
    */
    public static String InputPattern(String msg,String pattern){
        String value;
        do{
            System.out.print(msg);value=scanner.nextLine();
        }while (!value.matches(pattern));
        return value;
    }






    public static Date InputDate(String msg,String regex){
        SimpleDateFormat df = new SimpleDateFormat(regex);
        Date date = new Date();
        String value;
        df.setLenient(false);
        do{
            try {
                System.out.print(msg); value=scanner.nextLine();
                date=df.parse(value);
                return date;
            }catch (Exception e){
                System.out.println("[!] Invalid [!]");
            }
        }while (true);

    }



    public static String DateToString(Date date,String regex){
        SimpleDateFormat df = new SimpleDateFormat(regex);
        try {
            return df.format(date);
        }catch (Exception e){
            return null;
        }
    }

}
