package pl.futurecollars.invocing1.model;

import lombok.Data;

@Data

public class Company {
  private String taxIdentifications;
  private String adress;
  private String name;

  public Company(String taxIdentifications, String adress, String name) {
    this.taxIdentifications = taxIdentifications;
    this.adress = adress;
    this.name = name;
  }
}
