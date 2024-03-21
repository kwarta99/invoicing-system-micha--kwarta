package pl.futurecollars.invocing1.model

import spock.lang.Specification

import java.time.LocalDate

class InvoiceTest extends Specification {
    def "should create invoice with all "() {
        given:
        Integer Id = 1
        LocalDate date = LocalDate.now()
        Company buyer = new Company("1","12345","Company addres")
        Company seller = new Company("2","9876","CompanyTo addres")
        Invoice entry = new InvoiceEntry("Service", new BigDecimal("100.00"),new BigDecimal("23"),Vat.VAT_23)
        List<InvoiceEntry> entries = [entry]

        when:
        Invoice invoice = new Invoice(date,buyer,seller,entries)

        then:
        invoice.getId() == Id
        invoice.getDate() == date
        invoice.getBuyer() == buyer
        invoice.getSeller() == seller
        invoice.getEntries() == entries
    }

    def "should allow modification of invoice fields"(){
        given:
        Invoice invoice = new Invoice()
        LocalDate newDate = LocalDate.now()
        Company newCompanyBuyer = new Company("3","abide","addresses")
        Company newCompany
    }
}
