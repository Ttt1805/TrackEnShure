package HomeWork.Lesson6;

import java.io.File;
import java.util.Arrays;

public class MyMain {

    public static void main(String[] args) {
        try {
            File curDir = new File ("d:\\foto");
            if (curDir.exists()) {
                printDir(curDir, 1);
            }else {
                System.out.println("Directory not found");
            }
        }
        catch (NullPointerException e){
            System.out.println("Path is null");
        }
    }

    public static void printDir(File dir, int level){
        System.out.println(repeatSpace(level) + "|->" + dir.getName());
        int nlevel= level + 1;
        if  (dir.isDirectory()) {
            try {
                File[] arrDir = dir.listFiles();
                assert arrDir != null;
                for (File f : arrDir) {
                    if (f.isFile()) {
                        System.out.println(repeatSpace( nlevel ) + "|->" + f.getName());
                    } else {
                        printDir(f, nlevel);
                    }
                }
            }
            catch (NullPointerException e) {
                System.out.println(dir + " - not found" );
            }
        }
    }

    public static String repeatSpace(int num){
        String s = "";
        if (num > 0) {
            char[] chars = new char[num];
            Arrays.fill(chars, ' ');
            s = new String(chars);
        }
        return s;
    }
}
