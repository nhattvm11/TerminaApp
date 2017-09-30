package utility;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Management {
    public boolean copy(String src, String des) throws FileNotFoundException, IOException;
    public boolean delete(String name);
    public boolean cut(String src, String des);
    public boolean create(String fileName);
}
