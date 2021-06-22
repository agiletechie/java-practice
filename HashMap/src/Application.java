import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String args[]){
        HashMap<String,String> dictionary = new HashMap<>();

        dictionary.put("Brave","Ready to face and endure danger and pain");
        dictionary.put("Brilliant","Exceptionally clever or talented");
        dictionary.put("Joy","A feeling of great pleasure and happiness");
        dictionary.put("Confidence","The state of feeling certain about the truth of something");

//        for(String words : dictionary.keySet()){
//            System.out.println(words);
//        }
//
//        for(String words : dictionary.keySet()){
//            System.out.println(dictionary.get(words));
//        }

        for(Map.Entry<String,String> entry : dictionary.entrySet()){
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
