package pl.futurecollars.invocing1.service;

import java.util.List;
import java.util.Optional;
import pl.futurecollars.invocing1.db.Database;
import pl.futurecollars.invocing1.model.Invoice;

public class InvoiceService {

  private final Database database;

  public InvoiceService(Database database) {
    this.database = database;
  }

  public int saveInvoice(Invoice invoice) {
    return database.save(invoice);
  }

  public List<Invoice> getAllInvoices() {
    return database.getAll();
  }

  public Optional<Invoice> getInvoiceById(int id) {
    return database.getById(id);
  }

  public Invoice updateInvoice(int id, Invoice updatedInvoice) {
    return database.update(id, updatedInvoice);
  }

  public boolean deleteInvoice(int id) {
    return database.delete(id);
  }
}
