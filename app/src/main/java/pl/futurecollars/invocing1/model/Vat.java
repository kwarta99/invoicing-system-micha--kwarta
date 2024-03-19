package pl.futurecollars.invocing1.model;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public enum Vat {

 VAT_23(23),
 VAT_8(8),
 Vat_7(7),
 VAT_5(5),
 Vat_0(0),
 VAT_ZW(0);

 private final BigDecimal rate;

 Vat(int rate) {
  this.rate = BigDecimal.valueOf(rate);
 }
}
