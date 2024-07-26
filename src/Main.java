package todolist.src;

import java.util.HashMap;
import java.util.Scanner;

//   TODO: SAVE THE TASKS AND UREGENCY IN A FILE

public class Main {
    public static void main(String[] args){
        //  FIRST STRING IS UREGENCY
        //  SECOND IS THE TASK
        HashMap<String, String> todoHashMap = new HashMap<String, String>();
        Scanner scannerObj = new Scanner(System.in);
        while (true) {
            System.out.print("Action (add, remove, list or exit): ");
            String actionInput = scannerObj.nextLine();
            switch (actionInput.toLowerCase()) {
                case "add":
                    AddTodo(todoHashMap, scannerObj);
                break;

                case "list":
                    ListTodo(todoHashMap, scannerObj);
                break;

                case "remove":
                    RemoveTodo(todoHashMap, scannerObj);
                break;

                case "exit":
                    scannerObj.close();
                    System.out.println("Exiting..");
                return;
            }
        }
    }

    static void AddTodo(HashMap<String, String> Hashmap, Scanner scanner){
        System.out.print("Urgency level (LOW, MEDIUM, HIGH): ");
        String uregencyInput = scanner.nextLine();
        switch (uregencyInput.toLowerCase()) {
            case "low":
                System.out.print("Task: ");
                String taskInput1 = scanner.nextLine();
                Hashmap.put(taskInput1, uregencyInput + " 🟡");
                System.out.println("-----------------------------------");
                System.out.println("TASK: " + taskInput1);
                System.out.println("UREGENCY: " + uregencyInput + " 🟡");
                System.out.println("-----------------------------------");
            break;
            case "medium":
                System.out.print("Task: ");
                String taskInput2 = scanner.nextLine();
                Hashmap.put(taskInput2, uregencyInput + " 🟠");
                System.out.println("-----------------------------------");
                System.out.println("TASK: " + taskInput2);
                System.out.println("UREGENCY: " + uregencyInput + " 🟠");
                System.out.println("-----------------------------------");
            break;
            case "high":
                System.out.print("Task: ");
                String taskInput3 = scanner.nextLine();
                Hashmap.put(taskInput3, uregencyInput + " 🔴");
                System.out.println("-----------------------------------");
                System.out.println("TASK: " + taskInput3);
                System.out.println("UREGENCY: " + uregencyInput + " 🔴");
                System.out.println("-----------------------------------");
            break;
        }
    }

    static void ListTodo(HashMap<String, String> Hashmap, Scanner scanner){
        for(String x : Hashmap.keySet()){
            System.out.println("-----------------------------------");
            System.out.println("TASK: " + x);
            System.out.println("UREGENCY: " + Hashmap.get(x));
            System.out.println("-----------------------------------");
        }
    }

    static void RemoveTodo(HashMap<String, String> Hashmap, Scanner scanner){
        System.out.print("Task to remove: ");
        String removeInput = scanner.nextLine();
        if(Hashmap.containsKey(removeInput)){
            Hashmap.remove(removeInput);
            System.out.println("-----------------------------------");
            System.out.println("TASK: " + removeInput + " REMOVED!");
            System.out.println("-----------------------------------");
        } else {
            System.out.println("Task doesn't exist!");
        }
    }
}
