package pl.futurecollars.invocing1.service

import pl.futurecollars.invocing1.db.memory.InMemoryDatabase
import pl.futurecollars.invocing1.model.Invoice
import pl.futurecollars.invocing1.TestHelpers
import spock.lang.Specification

class IntegratedSystemTest extends Specification{

    def "CRUD operations should work correctly for InvoiceService"() {
        given: "An instance of InvoiceService with InMemoryDatabase"
        InMemoryDatabase database = new InMemoryDatabase()
        InvoiceService service = new InvoiceService(database)
        Invoice invoice = TestHelpers.invoice(1)

        when: "Invoice is saved"
        int savedInvoiceId = service.saveInvoice(invoice)

        then: "Saved invoice has an ID"
        savedInvoiceId != null

        when: "Invoice is read by ID"
        Invoice readInvoice = service.getInvoiceById(savedInvoiceId).get()

        then: "Read invoice is equal to the saved invoice"
        assert readInvoice.id.equals(savedInvoiceId)

        when: "Invoice is updated"
        readInvoice.entries[0].description = "Updated service"
        service.updateInvoice(readInvoice.id, readInvoice)
        Invoice updatedInvoice = service.getInvoiceById(readInvoice.id).get()

                then: "Updated invoice has the updated description"
        assert updatedInvoice.entries[0].description == "Updated service"

        when: "Invoice is deleted"
        service.deleteInvoice(updatedInvoice.id)

        then: "Invoice cannot be found in the database"
        !service.getInvoiceById(updatedInvoice.id).isPresent()
    }
}
