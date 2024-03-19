package pl.futurecollars.invocing1.db;

import java.util.List;
import java.util.Optional;
import pl.futurecollars.invocing1.model.Invoice;

public interface Database {

  int save(Invoice invoice);

  Optional<Invoice> getById(int id);
  List<Invoice> getAll();
  void update(int id, Invoice updateInvoice);
  void detete(int id);

}
