package Java_Helper_Git;




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



    public static String InputString(String msg,String[] arr){
        while (true) {
            String value = InputString(msg);
            //check input
            for(int i=0;i<arr.length;i++){
                if(value.equalsIgnoreCase(arr[i])) return arr[i];
            }
            System.out.print("[!] There are only: ");
            for (String e: arr
            ) {
                System.out.print(e+ " ");
            }
            System.out.print("[!]\n");
        }
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






    public static java.util.Date InputDate(String msg,String regex){
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(regex);
        java.util.Date date = new java.util.Date();
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



    public static String DateToString(java.util.Date date,String regex){
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(regex);
        try {
            return df.format(date);
        }catch (Exception e){
            return null;
        }
    }


    public static String InputStringMostSame(String msg,java.util.ArrayList<String> arr){

        int index = -1;
        while (true) {
            double mostSame=0,maxSame = 0 ;
            String value = InputString(msg);
            //check input
            for(int i=0;i<arr.size();i++){
                if(value.equalsIgnoreCase(arr.get(i))) return arr.get(i);
                mostSame=CheckDeviation(value,arr.get(i));;
                if(mostSame>maxSame){
                    index = i;
                    maxSame = mostSame;
                }

            }
            if(maxSame!=0){
                if(GetYesNo("[?] Your meaning \""+arr.get(index)+"\" [?]\n|Your Choice (Y/N):")) return arr.get(index);
            }

            System.out.println("[!] Re-enter please [!]");
        }
    }

    public static double CheckMostSame(String stringA,String stringB){
        StringBuilder strA = new StringBuilder(stringA);
        StringBuilder strB = new StringBuilder(stringB);
        for(int i = 0 ; i<strA.length();i++){
            for (int j =0 ; j<strB.length();j++){
                if(Character.toLowerCase(strA.charAt(i))==Character.toLowerCase(strB.charAt(j))){
                    strA=strA.deleteCharAt(i);
                    strB=strB.deleteCharAt(j);
                    i=-1;
                    break;
                }
            }
        }
        return 1/((Double.valueOf(strA.length())/Double.valueOf(stringA.length()))+(Double.valueOf(strB.length())/Double.valueOf(stringB.length())));
    }



    public static double CheckDeviation(String stringA,String stringB){
        double count=0,allCount=0;
        stringA = stringA.replaceAll("\\s","");
        stringB = stringB.replaceAll("\\s","");
        if(stringA.equalsIgnoreCase(stringB)) return Double.POSITIVE_INFINITY;
        if(stringA.length()>stringB.length()){
            String stringTemp = stringA;
            stringA=stringB;
            stringB=stringTemp;
        }
        StringBuilder strA = new StringBuilder(stringA);
        StringBuilder strB = new StringBuilder(stringB);

        for(int gap=1;gap<=strA.length();gap++){
            for(int a = 0;a<=strA.length()-gap;a++){
                for(int b =0;b<=strB.length()-gap;b++){
                    if(stringA.substring(a,a+gap).equalsIgnoreCase(stringB.substring(b,b+gap))) count+=gap;
                    allCount++;
                }
            }
        }
        return count/allCount;

    }

    public static boolean GetYesNo(String msg){
        String options;
        do{
            System.out.print(msg);options=scanner.nextLine();
            if(options.equalsIgnoreCase("yes")||options.equalsIgnoreCase("y")) return true;
            else if(options.equalsIgnoreCase("no")||options.equalsIgnoreCase("n")) return false;
        }while (true);
    }

}
