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

  public int save(Invoice invoice){
  return database.save(invoice);
  }
  public  Optional<Invoice> getById(int id){

    return database.getById(id);
  }
  public List<Invoice> getAll(){

    return database.getAll();
  }
  private void update(int id, Invoice updateInvoice){
    database.update(id, updateInvoice);
  }
  private void delete(int id){
   database.delete(id);
  }

}
