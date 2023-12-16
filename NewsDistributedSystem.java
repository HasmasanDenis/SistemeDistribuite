import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

public class NewsDistributedSystem {
    private static final Logger LOGGER = Logger.getLogger(NewsDistributedSystem.class.getName());
    private Map<String, String> newsDatabase = new HashMap<>();

    public NewsDistributedSystem() {
        try {
            FileHandler fileHandler = new FileHandler("jurnal.txt", true);
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Eroare la crearea FileHandler.", e);
        }
    }

    public void publishNews(String title, String content) {
        newsDatabase.put(title, content);
        LOGGER.log(Level.INFO, "Știre publicată: " + title + "| Continut : " + content);

    }

    public void deleteNews(String title) {
        System.out.println("Știri găsite pentru cuvânt-cheie '" + title + "':");
        for (Map.Entry<String, String> entry : newsDatabase.entrySet()) {
            if (entry.getKey().toLowerCase().contains(title.toLowerCase())) {
                newsDatabase.remove(title);
                LOGGER.log(Level.INFO, "Știre ștearsă: " + title);
                System.out.println("Știre ștearsă cu succes!");
            } else {
                System.out.println("Știrea cu titlul '" + title + "' nu a fost găsită.");
            }
        }
    }

    public void retrieveNews(String keyword) {
        System.out.println("Știri găsite pentru cuvânt-cheie '" + keyword + "':");
        for (Map.Entry<String, String> entry : newsDatabase.entrySet()) {
            if (entry.getKey().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Titlu: " + entry.getKey());
                System.out.println("Conținut: " + entry.getValue());
                System.out.println("----------------------");
            }
        }
    }
}