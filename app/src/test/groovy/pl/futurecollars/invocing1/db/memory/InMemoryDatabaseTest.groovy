package pl.futurecollars.invocing1.db.memory

import pl.futurecollars.invocing1.db.Database
import pl.futurecollars.invocing1.model.Invoice
import spock.lang.Specification
import static pl.futurecollars.invocing1.TestHelpers.invoice

class InMemoryDatabaseTest extends Specification {

    //setUp -> new InMemoryDatabase();
    private Database database

    def setup(){
        database = new InMemoryDatabase()
    }


    def "Save"() {
        given:
            Database database = new InMemoryDatabase()
            Invoice invoice = invoice(1)

        when:
            int id = database.save(invoice)

        then:
            assert id == 1
    }

    def "getById should return correct invoice"() {
        given:
        Invoice invoice1 = invoice(1)
        Invoice invoice2 = invoice(2)
        database.save(invoice1)
        database.save(invoice2)

        when:
        Optional<Invoice> result = database.getById(1)

        then:
        assert result.isPresent()
        assert result.get() == invoice1
    }

    def "getAll should return all invoices"() {
        given:
        Invoice invoice1 = invoice(1)
        Invoice invoice2 = invoice(2)
        database.save(invoice1)
        database.save(invoice2)

        when:
        List<Invoice> result = database.getAll()

        then:
        assert result.size() == 2
        assert result.containsAll([invoice1, invoice2])
    }

    def "update should modify existing invoice"() {
        given:
        Invoice originalInvoice = invoice(1)
        database.save(originalInvoice)
        Invoice updatedInvoice = invoice(2)

        when:
        database.update(1, updatedInvoice)

        then:
        assert database.getById(1).get() == updatedInvoice
    }

    def "delete should remove invoice from database"() {
        given:
        Invoice invoice = invoice(1)
        database.save(invoice)

        when:
        database.delete(1)

        then:
        assert database.getAll().isEmpty()
    }
    def "updating not existing invoice throws exception"() {
        when:
        Invoice notPresentInDatabaseInvoice = invoice(1)
        database.update(213, notPresentInDatabaseInvoice)

        then:
        def ex = thrown(IllegalArgumentException)
        ex.message == "Id 213 does not exist"
    }
}