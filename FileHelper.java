package Helper;




import Object.*;
public class FileHelper {

    /*
    Parameter:
        'fileName' is the name of file
    Note:
        Create the file named 'fileName'.
        Return "Create Success" when successful file deletion, and "already exists." if the file already exists
     */
    public static String CreateNewFiles(String fileName){
        try{
            if(new java.io.File(fileName).createNewFile())return fileName+" create success.";
            else return fileName+" already exists.";
        }catch (Exception e){
            return e.getMessage();
        }
    }


    /*
    Parameter:
        'fileName' is the name of file
    Note:
        Delete the file named 'fileName'.
        Return "Delete Success" when successful file deletion, and "didn't exist." when unsuccessful
     */
    public static String DeleteFiles(String fileName){
        try {
            if(new java.io.File(fileName).delete())return fileName+" delete success.";
            else return fileName+" didn't exist.";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    /*
   Parameter:
        'fileName' is the name of file
        'text' is the content you to write to the file
   Note:
        The new content will write override up old content
        Return "Successfully wrote to the file." when successful write the content to file
     */
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

    /*
    Parameter:
        'fileName' is the name of file
        'text' is the content you want to write to the file
        'append' set 'true' when you want append content to the file
    Note:
        When the 'append' parameter is 'true', the new content will be added after the old content
        When the 'append' parameter is 'false', the new content will overwrite the old content
        Return "Successfully append to the file." when successful append the content to file
    */
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



    /*
    Parameter:
        'fileName' is the name of file
        'listText' is the list of lines of content you want to write to file
        'separator' is the separating each element of the list
    Note:
        When the 'separator' parameter is "\n" each element of the list is written on a new line
        Return "Successfully append to the file." when successful write the content to file
    */
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


    /*
    Parameter:
        'fileName' is the name of file
        'listText' is the list of lines of content you want to write to file
        'separator' is the separating each element of the list
        'append' set 'true' when you want append content to the file
    Note:
        When the 'separator' parameter is "\n" each element of the list is written on a new line
        When the 'append' parameter is 'true', the new content will be added after the old content
        When the 'append' parameter is 'false', the new content will overwrite the old content
        Return "Successfully append to the file." when successful append the content to file
    */
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


    /*
    Parameter:
        'fileName' is the name of file
    Note:
        Read data from file 'fileName' and return it as a ArrayList<String>
    */
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



    /*
    Parameter:
        'fileName' is the name of file
    Note:
       What method to use to check that a file has previous object?
       Return 'true' if the file has previous object, and 'false' if vice versa
    */
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


    /*
    Parameter:
        'fileName' is the name of file
        'object' is the object you want to write to file
    Note:
        *('Object' need 'implements Serializable' when using this method)*
        Return "Successfully wrote to the file." when successful append the content to file
    */
    public static String WriteObject(String fileName,Object object){
        try {
            java.io.File file = new java.io.File(fileName);
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(fileOutputStream);
            if(object instanceof java.util.List || object instanceof java.util.ArrayList || object.getClass().isArray() ) {
                java.util.List listObject = (java.util.List)object;
                for (int i=0;i<listObject.size();i++){
                    objectOutputStream.writeObject(listObject.get(i));
                }
            }else{
                objectOutputStream.writeObject(object);
            }
            objectOutputStream.close();
            fileOutputStream.close();

            return "Successfully wrote to the file.";
        }catch (Exception e) {
            return e.getMessage();
        }
    }


    /*
    Parameter:
        'fileName' is the name of file
        'object' is the object you want to write to file
        'append' set 'true' when you want append content to the file
    Note:
        *('Object' need 'implements Serializable' when using this method)*
        When the 'separator' parameter is "\n" each element of the list is written on a new line
        When the 'append' parameter is 'true', the new content will be added after the old content
        When the 'append' parameter is 'false', the new content will overwrite the old content
        Return "Append to the file." when successful append the content to file
    */
    public static String WriteObject(String fileName,Object object,boolean append){
        if(!append){
            return WriteObject(fileName,object);
        }else {
            if(HasObject(fileName)){
                try {
                    java.io.File file = new java.io.File(fileName);
                    java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file, true);
                    java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(fileOutputStream) {
                        protected void writeStreamHeader() throws java.io.IOException {
                            return;
                        }
                    };
                    if(object instanceof java.util.List || object instanceof java.util.ArrayList || object.getClass().isArray() ) {
                        java.util.List listObject = (java.util.List)object;
                        for (int i=0;i<listObject.size();i++){
                            objectOutputStream.writeObject(listObject.get(i));
                        }
                    }else{
                        objectOutputStream.writeObject(object);
                    }
                    objectOutputStream.close();
                    fileOutputStream.close();
                    return "Append successfully to the file.";
                }catch (Exception e){
                    return e.getMessage();
                }
            }else {
                return WriteObject(fileName,object);
            }
        }
    }




    /*
    Parameter:
        'fileName' is the name of file
    Note:
        ('Object' need 'implements Serializable' when using this method)
        Read data from file 'fileName' and return it as a Object
        (You should casting ReadOneObject type to your datatype relevant...
        ...Example: int a = (int)ReadOneObject(fileName) )
     */
    public static Object ReadOneObject(String fileName){
        try {
            java.io.File file = new java.io.File(fileName);
            java.io.FileInputStream fileInputStream= new java.io.FileInputStream(file);
            java.io.ObjectInputStream objectInputStream = new java.io.ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        }catch (Exception e){
            e.getMessage();
            return null;
        }

    }



    /*
    Parameter:
        'fileName' is the name of file
    Note:
        ('Object' need 'implements Serializable' when using this method)
        Read data from file 'fileName' and return it as a List<Object>
        (You should casting ReadListObject type to your datatype relevant...
        ...Example: List<String> a = (List<String>)ReadListObject(fileName) )
     */
    public static java.util.List ReadListObject(String fileName){
        java.util.List<Object> list = new java.util.ArrayList<Object>();
        try {
            java.io.File file = new java.io.File(fileName);
            java.io.FileInputStream fileInputStream= new java.io.FileInputStream(file);
            java.io.ObjectInputStream objectInputStream = new java.io.ObjectInputStream(fileInputStream);
            while (true) {
                list.add(objectInputStream.readObject());
            }
        }catch (Exception e){
             e.getMessage();
            return list;
        }

    }




    /*
    Parameter:
        'fileName' is the name of file
        'oldDirectory' is the directory containing the file you want to move
        'newDirectory' is the directory you want to store the file after successful moving
    Note:
        Return "Moving file successful." when successful move the file
     */
    public static String MovingFile(String fileName,String oldDirectory,String newDirectory){
        String oldPath=CombinePath(oldDirectory,fileName);
        String newPath=CombinePath(newDirectory,fileName);
        if(IsFileExists(oldPath)&&IsDirectoryExists(oldDirectory)&&IsDirectoryExists(newDirectory)){
            try {
                if(IsFileExists(oldPath)) {
                    java.io.File file = new java.io.File(oldPath);
                    file.renameTo(new java.io.File(newPath));
                    return "Moving file successful.";
                }
                else {
                    throw new java.io.IOException();

                }

            } catch (java.io.IOException e) {
                return "Moving file unsuccessful.";
            }
        }else{
            return "Moving file unsuccessful.";
        }


    }



    /*
    Parameter:
        'path1' is the beginning of the file
        'path2' is the latter part of the file
    Note:
        Return new path that combined to path1 and path2
     */
    public static String CombinePath(String path1, String path2)
    {
        java.io.File file1 = new java.io.File(path1);
        java.io.File file2 = new java.io.File(file1, path2);
        return file2.getPath();
    }



    /*
    Parameter:
        'fileName' is the name of file
    Note:
        What method to use to check that a file is exists?
        Return 'true' if the file is exists, and 'false' if vice versa
     */
    public static boolean IsFileExists(String filePath){
        java.io.File file = new java.io.File(filePath);
        if(file.exists()&&!file.isDirectory()) return true;
        return false;
    }




    /*
        Parameter:
            'fileName' is the name of folder
        Note:
            What method to use to check that a folder is exists?
            Return 'true' if the folder is exists, and 'false' if vice versa
         */
    public static boolean IsDirectoryExists(String filePath){
        java.io.File file = new java.io.File(filePath);
        if(file.exists()&&!file.isFile()) return true;
        return false;
    }


}
