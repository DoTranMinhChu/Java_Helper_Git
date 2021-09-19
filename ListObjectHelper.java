package Java_Helper_Git;



/*
    ListObjectHelper<T> need using with ObjectHelper<T>
    ListObjectHelper<T> is used by declaring and passing as parameter the List Object itself needs help
    Example: ListObjectHelper<Object> listObjectHelper = new ListObjectHelper<Object>(list);

    ListObjectHelper<T> is only used to help List Object, there is no substitute for List Object
*/
public class ListObjectHelper<T> {
    private java.util.List<T> listObject ;
    public ListObjectHelper(java.util.List<T> list){
        listObject=list;
    }


    public java.util.List<T> getListObject() {
        return listObject;
    }
    public void setListObject(java.util.List<T> listObject) {
        this.listObject = listObject;
    }


    /*
    Parameter:
        'fileName' is the name of file
        'separator' is the separating each element of the list
    Note:
        When the 'separator' parameter is "\n" each element of the list is written on a new line
        Return "Successfully wrote to the file." when successful write the content to file as a String
    */
    public String WriteFile(String fileName, String separator){
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(fileName);
            for(int i=0;i<listObject.size();i++)fileWriter.write(listObject.get(i).toString()+(i<listObject.size()-1?separator:""));
            fileWriter.close();
            return "Successfully wrote to the file.";
        }catch (Exception e){
            return  e.getMessage();
        }
    }




    /*
    Parameter:

    Note:
        Display data list as a toString()
    */
    public void DisplayList(){
        listObject.forEach(element->{
            System.out.println(element.toString());
        });
    }




    /*
    Parameter:

    Note:
        Return List<Object> after sort
    */
    public java.util.List<T> Sort(){
        java.util.List<T> listTemp = new java.util.ArrayList<>();
        listTemp.addAll(listObject);
        java.util.Collections.sort(listTemp,new java.util.Comparator<T>(){
            public int compare(T o1,T o2){
                return o1.toString().compareTo(o2.toString());
            }
        });
        return listTemp;
    }





    /*
    Parameter:
        'sortBy' can be a field name or a method name
    Note:
        List<Object> sort by field or a method you want if this it exists
        Return List<Object> after sort by 'sortBy' order
    */
    public java.util.List<T> Sort(String sortBy){
        java.util.List<T> listTemp = new java.util.ArrayList<>();
        listTemp.addAll(listObject);
        ObjectHelpers<T> checkObj= new ObjectHelpers<T>(listObject.get(0));
        if(checkObj.hasMethod(sortBy)){
            java.util.Collections.sort(listTemp,new java.util.Comparator<T>(){
                public int compare(T o1,T o2){
                    ObjectHelpers<T> obj1= new ObjectHelpers<T>(o1);
                    ObjectHelpers<T> obj2= new ObjectHelpers<T>(o2);
                    Object method1 =obj1.getMethod(sortBy);
                    Object method2 =obj2.getMethod(sortBy);
                    if(method1 instanceof Integer || method1 instanceof Byte || method1 instanceof Short ||method1 instanceof Long  ){
                        int l1 =(int)method1;
                        int l2= (int)method2;
                        return l1-l2==0?0:l1-l2<0?-1:1;
                    }else if(method1 instanceof Double || method1 instanceof Float){
                        double d1 = (double)method1;
                        double d2= (double)method2;
                        return d1-d2==0?0:d1-d2<0?-1:1;
                    }else{
                        return method1.toString().compareTo(method2.toString());
                    }

                }
            });

        }else if(checkObj.hasField(sortBy)){
            java.util.Collections.sort(listTemp,new java.util.Comparator<T>(){
                public int compare(T o1,T o2){
                    ObjectHelpers<T> obj1= new ObjectHelpers<T>(o1);
                    ObjectHelpers<T> obj2= new ObjectHelpers<T>(o2);
                    Object filed1 =obj1.getFiled(sortBy);
                    Object filed2 =obj2.getFiled(sortBy);
                    if(filed1 instanceof Integer || filed1 instanceof Byte || filed1 instanceof Short ||filed1 instanceof Long ){
                        int l1 = (int)filed1;
                        int l2= (int)filed2;
                        return l1-l2==0?0:l1-l2<0?-1:1;
                    }else if(filed2 instanceof Double || filed2 instanceof Float){
                        double d1 = (double)filed1;
                        double d2= (double)filed2;
                        return d1-d2==0?0:d1-d2<0?-1:1;
                    }else{
                        return filed2.toString().compareTo(filed2.toString());
                    }

                }
            });
        }

        return listTemp;
    }



    /*
        ObjectHelpers<T> using help Object in List Object
     */
    private class ObjectHelpers<T>{
        public T obj;

        public ObjectHelpers(T obj){
            this.obj=obj;
        }

        /*
        Parameter:
            'methodName' is name of method you want check
        Note:
            Return 'true' if the Object has this method, and 'false' if vice versa
        */
        public boolean hasMethod(String methodName){
            try{
                java.lang.reflect.Method[] methods = obj.getClass().getMethods();
                for (int i=0;i<methods.length;i++){
                    if(methodName.equals(methods[i].getName())) return true;
                }
            }catch (Exception e){
                e.printStackTrace();

            }
            return false;
        }


        /*
        Parameter:
            'methodName' is name of field you want check
        Note:
            Return 'true' if the Object has this field, and 'false' if vice versa
        */
        public boolean hasField(String fieldName){
            try{
                java.lang.reflect.Field[] fields = obj.getClass().getFields();
                for (int i=0;i<fields.length;i++){
                    if(fieldName.equals(fields[i].getName())) return true;
                }
            }catch (Exception e){
                e.printStackTrace();

            }
            return false;
        }




        /*
        Parameter:
            'methodName' is name of method you want execute
        Note:
            Execute method and return if this method exists
        */
        public Object getMethod(String methodName){
            if(hasMethod(methodName)){
                try {
                    java.lang.reflect.Method method = obj.getClass().getDeclaredMethod(methodName);
                    return method.invoke(obj);
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
            return null;
        }


        /*
        Parameter:
            'fieldName' is name of filed you get data
        Note:
             Get filed of Object if this filed exists
        */
        public Object getFiled(String fieldName){
            if(hasField(fieldName)){
                try {
                    java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
                    return field.get(obj);
                }catch (Exception e){
                    e.printStackTrace();

                }
            }
            return null;
        }

    }
}
