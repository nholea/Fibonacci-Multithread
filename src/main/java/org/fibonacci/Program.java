package org.fibonacci;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Program{
  Scanner scanner = new Scanner(System.in);

  private final Fibonacci fibonacci;

  private final OptionsMenu optionsMenu;

  ArrayList<Fibonacci> fibonacciCollection = new ArrayList();

  public Program(Fibonacci fibonacci, OptionsMenu optionsMenu) {
    this.fibonacci = fibonacci;
    this.optionsMenu = optionsMenu;
  }

  public void run(){
    while (true) {
      optionsMenu.choose();
      String userInput = scanner.nextLine();
      if (userInput.equals("2")){
        showTasksCreated();
      }
      if (userInput.equals("3")) {
        fibonacciCollection.add(new Fibonacci("3"));
      }
      if (userInput.equals("4")) {
        System.out.print(fibonacciCollection.get(0).getName());
        fibonacciCollection.get(0).start();
      }
    }
  }

  private void showTasksCreated() {
    IntStream.range(0, fibonacciCollection.size())
      .forEach(index ->
        System.out.printf("Task %d: Fibonacci of %s%n", index, fibonacciCollection.get(index).getNumber()));
  }
}
