package file;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;


public class FileFilterAgregator implements FileFilter {
    private List<FileFilter> fileFilterList;

    public FileFilterAgregator(FileFilter... fileFilterList) {
//        Objects.requireNonNull(fileFilterList,"");
        this.fileFilterList = Arrays.asList(fileFilterList);
    }

    @Override
    public boolean accept(File pathname) {
        boolean result=true;
        for(FileFilter fileFilter:fileFilterList){
            if(fileFilter.accept(pathname)){
                result=false;
                break;
            }

        }
        return result;
    }
}
