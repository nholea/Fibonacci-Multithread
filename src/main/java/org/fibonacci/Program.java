package org.fibonacci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Program {

  Scanner scanner = new Scanner(System.in);

  private final Fibonacci fibonacci;

  private final OptionsMenu optionsMenu;

  ArrayList<Fibonacci> fibonacciThreads = new ArrayList();
  HashMap<String, Long> taskResults = new HashMap<>();

  public Program(Fibonacci fibonacci, OptionsMenu optionsMenu) {
    this.fibonacci = fibonacci;
    this.optionsMenu = optionsMenu;
  }

  public void start() {
    optionsMenu.choose();
    chooseOptions();
  }

  private void chooseOptions() {
    String userInput = scanner.nextLine();
    switch (userInput) {
      case "0":
        showTasksCreated();
        start();
        break;
      case "1":
        System.out.println("Calculate Fibonacci number ...");
        String inputNumber = scanner.nextLine();
        fibonacciThreads.add(new Fibonacci(inputNumber));
        start();
        break;
      case "2":
        showTasksCreated();
        System.out.println("Which task do you want to execute?");
        String taskToExecute = scanner.nextLine();
        int index = Integer.parseInt(taskToExecute);
        fibonacciThreads.get(index).start();
        taskResults.put("Fibonacci" + fibonacciThreads.get(index).getNumber(), fibonacciThreads.get(index).getFibonacci());
        System.out.printf("Task Fibonacci of %s started\n", fibonacciThreads.get(index).getNumber());
        start();
      case "3":
        showTasksResult();
        start();
        break;
      case "4":
        break;
    }
    start();
  }

  private void showTasksCreated() {
    IntStream.range(0, fibonacciThreads.size())
      .forEach(index ->
        System.out.printf("Task %d: Fibonacci of %s\n", index, fibonacciThreads.get(index).getNumber()));
  }

  private void showTasksResult() {
    for (Map.Entry<String, Long> result : taskResults.entrySet()) {
      System.out.printf("%s: %d", result.getKey(), result.getValue());
    }
  }
}
