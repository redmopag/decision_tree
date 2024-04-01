package redmopag.knowledgeEngineering.decisionTree;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Создание дерева
        DecisionTree decisionTree = DecisionTreeFactory.createDecisionTree("src/main/resources/rulesbase.txt");
        // Для чтения консольного ввода
        Scanner in = new Scanner(System.in);

        while(!decisionTree.isLeaf())
        {
            // Вывод текста и ответов узла
            System.out.println(decisionTree.getText());
            for(String answer : decisionTree.getAnswers())
                System.out.println(answer);

            // Считывание ответа пользователя
            String input = in.nextLine();
            decisionTree.next(input);
        }
        System.out.println(decisionTree.getText());
    }
}
