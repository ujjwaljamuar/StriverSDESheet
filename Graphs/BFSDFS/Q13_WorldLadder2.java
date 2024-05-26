package BFSDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q13_WorldLadder2 {
    ArrayList<ArrayList<String>> worldLadderTwo(String startWord, String endWord, ArrayList<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        ls.add(startWord);
        q.add(ls);

        ArrayList<String> seq = new ArrayList<>();
        seq.add(startWord);

        int level = 0;

        while (!q.isEmpty()) {
            ArrayList<String> lastSeq = q.peek();
            q.remove();

            if (lastSeq.size() > level) {
                level++;
                for (String str : seq) {
                    set.remove(str);
                }
            }

            String lastWord = lastSeq.get(lastSeq.size() - 1);

            if (lastWord.equals(endWord)) {
                if (res.size() == 0) {
                    res.add(lastSeq);
                } else if (res.get(0).size() == lastSeq.size()) {
                    res.add(lastSeq);
                }
            }

            // start permuting
            for (int i = 0; i < lastWord.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] charArray = lastWord.toCharArray();
                    charArray[i] = ch;
                    String newWord = new String(charArray);

                    if (set.contains(newWord)) {
                        lastSeq.add(newWord);

                        ArrayList<String> temp = new ArrayList<>(lastSeq);
                        q.add(temp);

                        // mark visited on level
                        seq.add(newWord);
                        lastSeq.remove(lastSeq.size() - 1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q13_WorldLadder2 graph = new Q13_WorldLadder2();

        String beginWord = "hit";
        String endWord = "cog";
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        System.out.println(graph.worldLadderTwo(beginWord, endWord, wordList));
    }
}
