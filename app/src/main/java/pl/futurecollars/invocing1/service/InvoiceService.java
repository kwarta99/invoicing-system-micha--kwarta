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

  public void updateInvoice(int id, Invoice updatedInvoice) {
    database.update(id, updatedInvoice);
  }

  public void deleteInvoice(int id) {
    database.delete(id);
  }

}
