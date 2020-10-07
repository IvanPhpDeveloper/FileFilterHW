package file;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtentionFileFilter implements FileFilter {
private final List<String> extList= new ArrayList<>(
);

    public ExtentionFileFilter(String [] extArr) {
        extList.addAll(Arrays.asList(extArr));//добавляем всю коллекцмю
    }

    public ExtentionFileFilter(String contains, String gif, String tiff, String psd, String pdf, String jpeg, String jpg, String bmp, String png) {

    }


    @Override
    public boolean accept(File pathname) {
        String name=pathname.getName();
        int dolastIndexOf = name.lastIndexOf(".");
        if(dolastIndexOf!=-1) {
            String ext = name.substring(dolastIndexOf+1);
            ext=ext.toLowerCase();
            return extList.contains(ext);   //возращаем принцип соответсвия ext
        }

        return false;
    }
}
