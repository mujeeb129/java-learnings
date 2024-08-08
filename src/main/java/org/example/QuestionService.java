package org.example;

import java.util.Scanner;

public class QuestionService {

    Question[] questions = new Question[5];
    int[] answers = new int[5];

    public QuestionService() {
        this.questions[0] = new Question(1, "What is the capital of India?", "Delhi", "Mumbai", "Chennai", "Kolkata", "Delhi");
        this.questions[1] = new Question(2, "What is the capital of USA?", "New York", "Chicago", "Washington", "Los Angeles", "Washington");
        this.questions[2] = new Question(3, "What is the capital of UK?", "London", "Manchester", "Bristol", "Cardiff", "London");
        this.questions[3] = new Question(4, "What is the capital of Australia?", "Sydney", "Melbourne", "Perth", "Canberra", "Canberra");
        this.questions[4] = new Question(5, "What is the capital of Canada?", "Ottawa", "Toronto", "Vancouver", "Calgary", "Ottawa");
    }

    public int checkScore() {
        return 0;
    }

    public void playQuiz() {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        for (Question q : questions) {
            System.out.println(q.getId() + " : " + q.getQuestion());
            System.out.println("1. " + q.getOpt1());
            System.out.println("2. " + q.getOpt2());
            System.out.println("3. " + q.getOpt3());
            System.out.println("4. " + q.getOpt4());
            System.out.println("Enter your answer");
            answers[i] = scanner.nextInt();
            i++;
        }
    }
}
