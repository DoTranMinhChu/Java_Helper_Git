package Helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ListObjectHelper<T> {
    private java.util.List<T> listObject ;
    public ListObjectHelper(java.util.List<T> list){

        listObject=list;
    }

    public String WriteBrand(String fileName, String separator){
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(fileName);
            for(int i=0;i<listObject.size();i++)fileWriter.write(listObject.get(i).toString()+(i<listObject.size()-1?separator:""));
            fileWriter.close();
            return "Successfully wrote to the file.";
        }catch (Exception e){
            return  e.getMessage();
        }
    }
    public void DisplayList(){
        listObject.forEach(element->{
            System.out.println(element.toString());
        });
    }
    public List<T> Sort(){
        java.util.List<T> listTemp = new ArrayList<>();
        listTemp.addAll(listObject);
        java.util.Collections.sort(listTemp,new Comparator<T>(){
            public int compare(T o1,T o2){
                return o1.toString().compareTo(o2.toString());
            }
        });
        return listTemp;
    }
    public List<T> Sort(String sortBy){
        java.util.List<T> listTemp = new ArrayList<>();
        listTemp.addAll(listObject);
        ObjectHelper<T> checkObj= new ObjectHelper<T>(listObject.get(0));
        if(checkObj.hasMethod(sortBy)){
            java.util.Collections.sort(listTemp,new Comparator<T>(){
                public int compare(T o1,T o2){
                    ObjectHelper<T> obj1= new ObjectHelper<T>(o1);
                    ObjectHelper<T> obj2= new ObjectHelper<T>(o2);
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
            java.util.Collections.sort(listTemp,new Comparator<T>(){
                public int compare(T o1,T o2){
                    ObjectHelper<T> obj1= new ObjectHelper<T>(o1);
                    ObjectHelper<T> obj2= new ObjectHelper<T>(o2);
                    Object filed1 =obj1.getFiled(sortBy);
                    Object filed2 =obj2.getFiled(sortBy);
                    if(filed1 instanceof Integer || filed1 instanceof Byte || filed1 instanceof Short ||filed1 instanceof Long  ){
                        int l1 = (int)filed2;
                        int l2= (int)filed2;
                        return l1-l2==0?0:l1-l2<0?-1:1;
                    }else if(filed2 instanceof Double || filed2 instanceof Float){
                        double d1 = (double)filed2;
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
    public void add(T obj){
        listObject.add(obj);
    }
    public List<Object> getMethod(String methodName){
        List<Object> list = new ArrayList<Object>();
        for(int i=0;i<listObject.size();i++){
            ObjectHelper<T> obj= new ObjectHelper<T>(listObject.get(i));
            list.add(obj.getMethod(methodName));

        }
        return list;
    }

}
