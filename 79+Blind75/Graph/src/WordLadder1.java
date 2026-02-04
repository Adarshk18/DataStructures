import java.util.*;

public class WordLadder1 {
    static class Pair{
        String word;
        int steps;

        Pair(String word, int steps){
            this.word = word;
            this.steps = steps;
        }
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        Set<String> st = new HashSet<>(wordList);
        if (!st.contains(endWord)) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        st.remove(beginWord);
        while (!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.word;
            int steps = curr.steps;

            if (word.equals(endWord)) return steps;

            for (int i = 0; i < wordList.size(); i++) {
                char[] replacedArray = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    replacedArray[i] = ch;
                    String replacedWord = new String(replacedArray);
                    if (st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            String beginWord = in.next();
            String endWord = in.next();


            List<String> wordList = new ArrayList<>();
        }
    }
}
