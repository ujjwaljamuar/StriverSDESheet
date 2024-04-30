package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q12_WordLadder1 {
    int wordLadder(String beginWord, String endWord, ArrayList<String> words) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        Set<String> set = new HashSet<>();
        for (String st : words) {
            set.add(st);
        }
        set.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.peek().first;
            int level = q.peek().second;
            q.remove();

            if (word.equals(endWord)) {
                return level;
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedWordArray = word.toCharArray();
                    replacedWordArray[i] = ch;
                    String replacedWord = new String(replacedWordArray);

                    if (set.contains(replacedWord)) {
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, level + 1));
                    }

                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Q12_WordLadder1 graph = new Q12_WordLadder1();

        // ArrayList<String> words = new ArrayList<>(Arrays.asList("hot", "dot", "dog",
        // "lot", "log", "cog"));
        ArrayList<String> words = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(graph.wordLadder("hit", "cog", words));

    }

    class Pair {
        String first;
        int second;

        Pair(String _first, int _second) {
            this.first = _first;
            this.second = _second;
        }
    }
}
