import java.util.HashMap;
import java.util.Map;

public class NewsDistributedSystem {
    private Map<String, String> newsDatabase = new HashMap<>();

    public void publishNews(String title, String content) {
        // Simulare publicare știri în sistemul distribuit
        newsDatabase.put(title, content);
    }

    public void retrieveNews(String keyword) {
        // Simulare căutare și recuperare știri în sistemul distribuit
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
