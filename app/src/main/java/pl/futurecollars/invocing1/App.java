package pl.futurecollars.invocing1;

import pl.futurecollars.invocing1.model.Company;
import pl.futurecollars.invocing1.model.Vat;

public class App {

  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String[] args) {
    System.out.println(new App().getGreeting());

    Company seller = new Company("123","example-seller-address","example-seller");
    Company buyer = new Company("456","example-buyer-address","example-buyer");




  }
}
