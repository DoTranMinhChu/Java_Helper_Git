package Java_Helper_Git;

import java.util.Scanner;

public class MenuHelper {
    public static void DisplayMenu(java.util.List<String> listOptions,String menu){
        System.out.println(menu);
        for (int i=0;i<listOptions.size();i++){
            System.out.print("["+(i+1)+"] - ");
            System.out.println(listOptions.get(i));
        }
    }
    public static void DisplayMenu(Object[] listOptions,String menu){
        System.out.println(menu);
        for (int i=0;i<listOptions.length;i++){
            System.out.print("["+(i+1)+"] - ");
            System.out.println(listOptions[i]);
        }
    }
    public static int GetChoice(java.util.List<String> listOptions,String msg){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int options ;
        do{
            try{
                System.out.print(msg);options=Integer.parseInt(scanner.nextLine());
                if(options>0&&options<=listOptions.size()) return options;
            }catch (Exception e){
            }
        }while (true);
    }
    public static int GetChoice(Object[] listOptions,String msg){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int options ;
        do{
            try{
                System.out.print(msg);options=Integer.parseInt(scanner.nextLine());
                if(options>0&&options<=listOptions.length) return options;
            }catch (Exception e){
            }
        }while (true);
    }
    public static boolean GetYesNo(String msg){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String options;
        do{
            System.out.print(msg);options=scanner.nextLine();
            if(options.toLowerCase().equals("yes")||options.toLowerCase().equals("y")) return true;
                else if(options.toLowerCase().equals("no")||options.toLowerCase().equals("n")) return false;
        }while (true);
    }
}
