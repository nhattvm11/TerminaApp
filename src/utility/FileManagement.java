package utility;

import java.io.*;

public class FileManagement implements Management{

    @Override
    public boolean copy(String src, String des) throws IOException {
        File sourceFile = new File(src);
        File desFile = new File(des);
        if(sourceFile.exists()) {
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(desFile);
            byte[] data = new byte[1024];
            while(fis.read(data) != -1) {
                fos.write(data);
                fos.flush();
            }
            fis.close();
            fos.close();
            System.out.println("Thanh cong");
            return true;
        } else {
            System.out.println("K ton tai");
            return false;
        }
    }

    @Override
    public boolean delete(String name) {
        return false;
    }

    @Override
    public boolean cut(String src, String des) {
        return false;
    }

    @Override
    public boolean create(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
