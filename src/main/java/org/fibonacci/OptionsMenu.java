package org.fibonacci;


public class OptionsMenu {

  public void choose() {
      System.out.println("\nChoose an option...\n");
      System.out.println("0. Tasks created\n");
      System.out.println("1. Add a task\n");
      System.out.println("2. Start a task\n");
      System.out.println("3. Show results\n");
      System.out.println("4. Exit Program\n");
  }

  public void invalidOption() {
    System.out.println("Invalid option. Try again!");
  }

}
