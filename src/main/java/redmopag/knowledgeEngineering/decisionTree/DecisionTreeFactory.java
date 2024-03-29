package redmopag.knowledgeEngineering.decisionTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DecisionTreeFactory {
    public static DecisionTree createDecisionTree(String path) throws FileNotFoundException {
        DecisionTree decisionTree;
        try(Scanner scanner = new Scanner(new File(path))){
            scanner.nextLine();
            String str = scanner.nextLine();
            String[] strings = str.split("=");

            decisionTree = new DecisionTree(getText(strings[0]));

            while (scanner.hasNextLine()){
                String parentKey = getText(strings[1]);
                str = scanner.nextLine();
                if(str.equals("И")) {
                    strings = scanner.nextLine().split("=");
                    decisionTree.addNode(getText(strings[0]), parentKey);
                } else if(str.contains("ТО")){
                    strings = scanner.nextLine().split(" ");
                    decisionTree.addNode(getText(strings[1].replace(";", "")), parentKey);
                } else if(str.contains("ЕСЛИ"))
                    decisionTree.toRoot();
            }
        }
        return decisionTree;
    }
    private static String getText(String str){
        int i1 = str.indexOf("\n");
        int i2 = str.indexOf("\n", i1);
        return str.substring(i1, i2);
    }
}
