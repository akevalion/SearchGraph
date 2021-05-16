
import java.util.ArrayList;

public class Path2 {
    ArrayList<String> words;
    int size = 0;
    public Path2(ArrayList<String> words){
        this.words= new ArrayList<>(words);
    }
    public Path2(){
        words = new ArrayList<>();
    }
    public int size(){
        if (size > 0) return size;
        int sum = 0;
        for(String word: words)
            sum += word.length();
        return (size = sum);
    }

    public void add(String value) {
        words.add(value);
    }
    public boolean isValid() {
        int s = words.size();
        if(s < 2) return true;
        String last1 = words.get(s-1);
        String last2 = words.get(s-2);
        return last1.charAt(0) != last2.charAt(0);
    }
}
