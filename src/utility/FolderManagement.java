package utility;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FolderManagement implements Management {
    @Override
    public boolean copy(String src, String des) throws FileNotFoundException, IOException {
        return false;
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
        return false;
    }

}
