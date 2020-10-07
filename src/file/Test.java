package file;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {



        File file=new File("C:\\Temp\\ListArr\\src\\file");

        System.out.println ("Имя файла: " + file .getName());
        System.out.println ("Путь: " + file.getPath());
        System.out.println ("Полный путь: " +
                file.getAbsolutePath());
        System.out.println ("Родительский каталог: " +
                file.getParent());
        System.out.println (file.exists() ?
                "Файл существует" :
                "Файл  не существует");
        System.out.println (file.canWrite() ?
                "Свойство - можно записывать" :
                "Свойство - нельзя записывать");
        System.out.println (file.canRead() ?
                "Свойство - можно читать" :
                "Свойство - нельзя читать");
        System.out.println ("Это директория ? " +
                (file.isDirectory() ?
                        "да": " нет"));
        System.out.println ("Это обычный файл ? " +
                (file.isFile() ?
                        "да" : "нет"));
        System.out.println ("Последняя модификация файла : "
                + file. lastModified());
        System.out.println ("Размер файла : " + file.length()
                + " bytes");


        if (file.delete()) {
            System.out.println(file.getName() + " deleted");
        } else {
            System.out.println(file.getName() + " not deleted");
        }

        List<File> files = walkDir(file,3);
        for (File file1:files){
            System.out.println(file1);
        }

    }
    private static List<File> walkDir(File file){
        return walkDir(file,1);
    }
    private static List<File> walkDir(File file,int deep){
        return walkDir(file,deep,null);
    }
private static List<File> walkDir(File file,int deep, FileFilter fileFilter){
        if(deep< 0){
            throw new IllegalArgumentException  ();
        }
        int theDeep=deep-1;
        final List<File> fileList=new ArrayList<>();
       if(file.isDirectory()){
           if(deep==0){
               return fileList;
           }
           File[] fileArr;
           if(fileFilter!=null){
               fileArr=file.listFiles(fileFilter);

           }else {
               fileArr=file.listFiles();
           }
    for(File nextFile:fileArr)
    fileList.addAll(walkDir(nextFile,deep-1,fileFilter));
}else {
           fileList.add(file);
       }
       return fileList;


}

}
