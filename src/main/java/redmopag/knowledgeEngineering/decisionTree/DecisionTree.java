package redmopag.knowledgeEngineering.decisionTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DecisionTree {
    private final Node root;
    private Node current;

    public DecisionTree(String text){
        root = new Node(text);
        current = root;
    }

    public void addNode(String text, String parentKey){
        if(current.answers.containsKey(parentKey))
            current = current.answers.get(parentKey);
        else {
            Node newNode = new Node(text);
            current.answers.put(parentKey, newNode);
            current = newNode;
        }
    }
    public void toRoot(){
        current = root;
    }
    public boolean isLeaf(){
        return current.isLeaf();
    }
    public String getText(){
        return current.text;
    }
    public Set<String> getAnswers(){
        return current.answers.keySet();
    }
    public void next(String key){
        current = current.answers.get(key);
    }

    public static class Node{
        private final String text;
        private Map<String, Node> answers;

        public Node(String text) {
            this.text = text;
            answers = new HashMap<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(text, node.text) && Objects.equals(answers, node.answers);
        }

        @Override
        public int hashCode() {
            return Objects.hash(text, answers);
        }

        public boolean isLeaf(){
            return answers.isEmpty();
        }
    }
}