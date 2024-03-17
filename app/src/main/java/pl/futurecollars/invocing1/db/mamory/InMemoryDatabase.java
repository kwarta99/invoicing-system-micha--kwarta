package pl.futurecollars.invocing1.db.mamory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import pl.futurecollars.invocing1.db.Database;
import pl.futurecollars.invocing1.model.Invoice;

public class InMemoryDatabase implements Database {

  private final Map<Integer, Invoice> invoices = new HashMap<>();
  private int nexId = 1;

  @Override
  public int save(Invoice invoice) {
    invoice.setId(nexId);
    invoices.put(nexId, invoice);
    return nexId++;
  }

  @Override
  public Optional<Invoice> getById(int id) {
    return Optional.empty();
  }

  @Override
  public List<Invoice> getAll() {
    return null;
  }

  @Override
  public void uodate(int id, Invoice updateInvoice) {

  }

  @Override
  public void detete(int id) {

  }
}
