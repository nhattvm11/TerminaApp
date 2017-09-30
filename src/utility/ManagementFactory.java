package utility;

public class ManagementFactory {
    public Management getManagement(String managementType) {
        if(managementType == null) {
            return null;
        }
        if(managementType.equalsIgnoreCase("FileManagement")) {
            return new FileManagement();
        } else if(managementType.equalsIgnoreCase("FolderManagement")) {
            return new FolderManagement();
        }
        return null;
    }
}
