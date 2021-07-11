package Helper;

public class ObjectHelper<T>{
    public T obj;
    public ObjectHelper(T obj){
        this.obj=obj;
    }

    public ObjectHelper() {

    }

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
    public Object getFiled(String filedName){
        if(hasField(filedName)){
            try {
                java.lang.reflect.Field field = obj.getClass().getDeclaredField(filedName);
                return field.get(obj);
            }catch (Exception e){
                e.printStackTrace();

            }
        }
        return null;
    }

}
