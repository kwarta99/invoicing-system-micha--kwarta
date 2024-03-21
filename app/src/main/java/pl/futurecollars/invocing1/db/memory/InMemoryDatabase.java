package pl.futurecollars.invocing1.db.memory;

import java.util.ArrayList;
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
    return Optional.ofNullable(invoices.get(id));
  }

  @Override
  public List<Invoice> getAll() {
    return new ArrayList<>(invoices.values());
  }

  @Override
  public Invoice update(int id, Invoice updatedInvoice) {
    if (!invoices.containsKey(id)) {
      throw new IllegalArgumentException("Id " + id + " does not exist");
    }

    updatedInvoice.setId(id);
    invoices.put(id, updatedInvoice);
    return updatedInvoice;
  }

  @Override
  public boolean delete(int id) {
    invoices.remove(id);
    return false;
  }

}
