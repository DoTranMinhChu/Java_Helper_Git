package Helper;



public class FileHelper {

    public static String CreateNewFiles(String fileName){
        try{
            if(new java.io.File(fileName).createNewFile())return fileName+" create success.";
            else return fileName+" already exists.";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public static String DeleteFiles(String fileName){
        try {
            if(new java.io.File(fileName).delete())return fileName+" delete success.";
            else return fileName+" didn't exist.";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public static String WriteText(String fileName,String text){
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(fileName);
            fileWriter.write(text);
            fileWriter.close();
            return "Successfully wrote to the file.";
        }catch (Exception e){
            return  e.getMessage();
        }
    }
    public static String WriteText(String fileName,String text,Boolean append){
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(fileName,append);
            fileWriter.write(text);
            fileWriter.close();
            return "Successfully append to the file.";
        }catch (Exception e){
            return  e.getMessage();
        }
    }
    public static String WriteText(String fileName, java.util.List<String> listText,String separator){
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(fileName);
            for(int i=0;i<listText.size();i++)fileWriter.write(listText.get(i)+(i<listText.size()-1?separator:""));
            fileWriter.close();
            return "Successfully wrote to the file.";
        }catch (Exception e){
            return  e.getMessage();
        }
    }
    public static String WriteText(String fileName, java.util.List<String> listText,String separator,boolean append){
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(fileName,append);
            for(int i=0;i<listText.size();i++)fileWriter.write(listText.get(i)+(i<listText.size()-1?separator:""));
            fileWriter.close();
            return "Successfully wrote to the file.";
        }catch (Exception e){
            return  e.getMessage();
        }
    }
    public static java.util.ArrayList<String> ReadText(String fileName){
        java.util.ArrayList<String> data = new java.util.ArrayList<String>();
        try {
            java.io.File fileReader = new java.io.File(fileName);
            java.util.Scanner scanner = new java.util.Scanner(fileReader);
            while (scanner.hasNextLine())data.add(scanner.nextLine());
            scanner.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return data;
    }

    public static String WriteUTF8(String fileName,String text){
        try{
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(fileName,"rw");
            randomAccessFile.writeUTF(text);
            randomAccessFile.close();
            return "Successfully wrote to the file.";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public static String WriteUTF8(String fileName,java.util.List<String> listText,String separator){
        try{
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(fileName,"rw");

            for(int i=0;i<listText.size();i++)randomAccessFile.writeUTF(listText.get(i)+(i<listText.size()-1?separator:""));
            randomAccessFile.close();
            return "Successfully wrote to the file.";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public static java.util.ArrayList<String> ReadUTF8(String fileName){
        java.util.ArrayList<String> data = new java.util.ArrayList<String>();
        String dataLine;
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(fileName,"r");

            while ((dataLine= randomAccessFile.readUTF())!=null){
                data.add(dataLine.trim());
            }
            randomAccessFile.close();
        }catch (Exception e){

        }
        return data;
    }

    public static boolean HasObject(String fileName){
        boolean check=true;
        try{
            java.io.File file = new java.io.File(fileName);
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            java.io.ObjectInputStream objectInputStream = new java.io.ObjectInputStream(fileInputStream);
            if(objectInputStream.readObject()==null) check = false;
            objectInputStream.close();
            fileInputStream.close();
        }catch (java.io.FileNotFoundException fileNotFoundException){
            check=false;
        }catch (java.io.IOException ioException){
            check=false;
        }catch (java.lang.ClassNotFoundException classNotFoundException){
            check=false;
        }
        return check;
    }

    public static String WriteObject(String fileName,Object object){
        try {
            java.io.File file = new java.io.File(fileName);
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            return "Successfully wrote to the file.";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public static String WriteObject(String fileName,Object object,boolean append){
        if(!append){
            return WriteObject(fileName,object);
        }else {
            if(HasObject(fileName)){
                try {
                    java.io.File file = new java.io.File(fileName);

                    java.io.FileOutputStream fo = new java.io.FileOutputStream(file, true);

                    java.io.ObjectOutputStream oStream = new java.io.ObjectOutputStream(fo) {
                        protected void writeStreamHeader() throws java.io.IOException {
                            reset();
                        }
                    };
                    oStream.writeObject(object);
                    return "Append successfully to the file.";
                }catch (Exception e){
                    return e.getMessage();
                }
            }else {
                return WriteObject(fileName,object);
            }
        }
    }
    public static Object ReadObject(String fileName){
        java.util.List<Object> list = null;
        try {
            java.io.File file = new java.io.File(fileName);
            java.io.FileInputStream fileInputStream= new java.io.FileInputStream(file);
            java.io.ObjectInputStream objectInputStream = new java.io.ObjectInputStream(fileInputStream);

            while (true) {
                return objectInputStream.readObject();
            }

        }catch (Exception e){
             e.getMessage();

        }
        return list;
    }
}
