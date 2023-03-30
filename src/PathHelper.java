import javax.xml.crypto.Data;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class PathHelper {

    private PathHelper() {
    }

    public static Path buildFileName(String path, String suffix) {

        Path fullPath = Path.of(path);
        Path directory = fullPath.getParent();
        String fileName = fullPath.getFileName().toString();
        String newFileName;
        if (fileName.contains(".")) {
            int index = fileName.lastIndexOf(".");
            newFileName = fileName.substring(0, index) + suffix + LocalDateTime.now() + fileName.substring(index);
        } else {
            newFileName = fileName + suffix ;
        }

        return directory.resolve(Path.of(newFileName));
    }
}
