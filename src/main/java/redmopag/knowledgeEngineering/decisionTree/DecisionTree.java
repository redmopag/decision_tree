package redmopag.knowledgeEngineering.decisionTree;

import java.util.HashMap;
import java.util.Map;

public class DecisionTree {
    private Node root;
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
        root = current;
    }
    public static class Node{
        private String text;
        private Map<String, Node> answers;

        public Node(String text) {
            this.text = text;
            answers = new HashMap<>();
        }
        public void addChild(String key, Node child){
            answers.put(key, child);
        }
    }
}