package pl.futurecollars.invocing1.model

import spock.lang.Specification

import static pl.futurecollars.invocing1.TestHelpers.company
import static pl.futurecollars.invocing1.TestHelpers.invoice
import static pl.futurecollars.invocing1.TestHelpers.product

import java.time.LocalDate

class InvoiceTest extends Specification {
    def "should create invoice with all "() {
        given:
        Integer id = 1
        LocalDate date = LocalDate.now()
        Company buyer = company(0)
        Company seller = company(0)
        InvoiceEntry entry = product(0)
        List<InvoiceEntry> entries = [entry]

        when:
        Invoice invoice = new Invoice(date,buyer,seller,entries)
        invoice.setId(id)

        then:
        invoice.getId() == id
        invoice.getDate() == date
        invoice.getBuyer() == buyer
        invoice.getSeller() == seller
        invoice.getEntries() == entries
    }


}
