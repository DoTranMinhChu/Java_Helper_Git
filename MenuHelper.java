package Helper;

import java.util.Scanner;

public class MenuHelper {
    public static void CreateMenu(java.util.List<String> listOptions,String menu){
        System.out.println(menu);
        for (int i=0;i<listOptions.size();i++){
            System.out.print("["+(i+1)+"] - ");
            System.out.println(listOptions.get(i));
        }
    }
    public static int Choice(java.util.List<String> listOptions,String msg){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int options ;
        do{
            try{
                System.out.print(msg);options=Integer.parseInt(scanner.nextLine());
                if(options>0&&options<=msg.length()) return options;
            }catch (Exception e){
            }
        }while (true);
    }
}
