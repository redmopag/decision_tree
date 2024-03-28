package redmopag.knowledgeEngineering.decisionTree;

import java.util.Map;

public class DecisionTree {
    public static void main(String[] args) {

    }
    public static class Node{
        private final String text;
        private final Map<String, Node> answers;

        public Node(String text, Map<String, Node> answers) {
            this.text = text;
            this.answers = answers;
        }
        public void getNode(){
            System.out.println(text);
            for(String key : answers.keySet())
                System.out.println(key);
        }
        public Node nextNode(String answer){
            return answers.get(answer);
        }
    }
}