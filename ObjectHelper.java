package Java_Helper_Git;

/*
    ObjectHelper is used by declaring and passing as parameter the Object itself needs help
    Example: ObjectHelper<Object> Obj= new ObjectHelper<Object>(new Object(....));

    ObjectHelper is only used to help Object, there is no substitute for Object
*/
public class ObjectHelper<T>{
    public T obj;

    public ObjectHelper(T obj){
        this.obj=obj;
    }



    /*
    Parameter:

    Note:
        Returns the names of all the filed of an Object as a List<String>
    */
    public java.util.List<String> getFiledList(){
        try{
            java.lang.reflect.Field[] fields = obj.getClass().getFields();
            java.util.List<String> fieldList=new java.util.ArrayList<String>();
            for (int i=0;i<fields.length;i++) fieldList.add(fields[i].getName());
            return fieldList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }





    /*
    Parameter:

    Note:
        Returns the names of all the method of an Object as a List<String>
    */
    public java.util.List<String> getMethodList(){
        try{
            java.lang.reflect.Method[] methods = obj.getClass().getMethods();
            java.util.List<String> methodsList=new java.util.ArrayList<String>();
            for (int i=0;i<methods.length;i++) methodsList.add(methods[i].getName());
            return methodsList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
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
        'methodName' is name of method you want execute
    Note:
        Execute method if this method exists but not return something
    */
    public void callMethod(String methodName){
        if(hasMethod(methodName)){
            try {
                java.lang.reflect.Method method = obj.getClass().getDeclaredMethod(methodName);
                method.invoke(obj);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
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