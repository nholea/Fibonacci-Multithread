package org.fibonacci;

import java.util.ArrayList;
import java.util.Scanner;

public class Program implements Runnable{
  Scanner scanner = new Scanner(System.in);

  private final Fibonacci fibonacci;

  private final OptionsMenu optionsMenu;

  ArrayList<Fibonacci> fibonacciCollection = new ArrayList();

  public Program(Fibonacci fibonacci, OptionsMenu optionsMenu) {
    this.fibonacci = fibonacci;
    this.optionsMenu = optionsMenu;
  }

  public void run(){
    optionsMenu.choose();
    String userInput = scanner.nextLine();
    if (userInput.equals("3")){
      fibonacciCollection.add(new Fibonacci("3"));
    }
    if (userInput.equals("4")){
      System.out.println(fibonacciCollection.get(0).getName());
      fibonacciCollection.get(0).start();
    }
  }
}
