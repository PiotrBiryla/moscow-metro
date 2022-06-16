import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static final String SOURCE_WEB_SITE = "https://skillbox-java.github.io/";
    public static final String MOSCOW_METRO = "src/main/resources/MoscowMetro.json";
    public static Document webSite;

    public static void main(String[] args) {
        try {
            File moscowMetroFile = new File(MOSCOW_METRO);
            moscowMetroFile.delete();
            moscowMetroFile.createNewFile();
            webSite = Jsoup.connect(SOURCE_WEB_SITE).maxBodySize(0).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.write(Paths.get(MOSCOW_METRO), JsonParser.getMetroData().toString().getBytes(), StandardOpenOption.WRITE);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        JsonParser.getStationIndex();
        JsonParser.getMoscowMetroInfo();
        JsonParser.getMoscowMetroConnectionsInfo();
    }
}
