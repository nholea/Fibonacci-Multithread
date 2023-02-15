package org.fibonacci;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Program {

  private final OptionsMenu optionsMenu;

  ArrayList<Fibonacci> fibonacciThreads = new ArrayList<>();
  HashMap<String, Long> taskResults = new HashMap<>();

  public Program(OptionsMenu optionsMenu) {

    this.optionsMenu = optionsMenu;
  }

  public void start() throws InterruptedException {
    optionsMenu.choose();
    chooseOptions();
  }

  private void chooseOptions() throws InterruptedException {
    switch (userInput()) {
      case "0":
        showTasksCreated();
        start();
        break;
      case "1":
        System.out.println("Calculate Fibonacci number ...");
        String inputNumber = userInput();
        fibonacciThreads.add(new Fibonacci(inputNumber));
        start();
        break;
      case "2":
        tasksAvailableToExecute();
        System.out.println("Which task do you want to execute?");
        String taskToExecute = userInput();
        int index = Integer.parseInt(taskToExecute);
        fibonacciThreads.get(index).start();
        System.out.printf(
          "%s -> Fibonacci of %s started\n",
          fibonacciThreads.get(index).getName(),
          fibonacciThreads.get(index).getNumber()
        );
        taskResults.put(
          "Fibonacci of " + fibonacciThreads.get(index).getNumber(),
          fibonacciThreads.get(index).getFibonacci()
        );
        start();
        break;
      case "3":
        showTasksResult();
        start();
        break;
      case "4":
        break;
      default:
        optionsMenu.invalidOption();
        start();
        break;
    }
  }

  private void showTasksCreated() {
    IntStream.range(0, fibonacciThreads.size())
      .forEach(index ->
        System.out.printf(
          "Task %d: Fibonacci of %s state: %s \n",
          index, fibonacciThreads.get(index).getNumber(),
          fibonacciThreads.get(index).getState())
      );
  }

  private void tasksAvailableToExecute() {
    IntStream.range(0, fibonacciThreads.size())
      .filter(index -> fibonacciThreads.get(index).getState() == State.NEW)
      .forEach(index ->
        System.out.printf("Task %d: Fibonacci of %s\n", index, fibonacciThreads.get(index).getNumber()));
  }

  private void showTasksResult() {
    for (Map.Entry<String, Long> result : taskResults.entrySet()) {
      System.out.printf("%s: %d\n", result.getKey(), result.getValue());
    }
  }

  private String userInput() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
}
