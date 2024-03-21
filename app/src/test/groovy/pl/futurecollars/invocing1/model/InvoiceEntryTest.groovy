package pl.futurecollars.invocing1.model

import spock.lang.Specification

class InvoiceEntryTest extends Specification {

    def "should create invoice entry with correct values"() {
        given:
        String description = "Test Description"
        BigDecimal price = BigDecimal.valueOf(100.00)
        BigDecimal vatValue = BigDecimal.valueOf(23.00)
        Vat vatRate = Vat.VAT_23

        when:
        InvoiceEntry entry = new InvoiceEntry(description,price,vatValue,vatRate)

        then:
        entry.description == description
        entry.price == price
        entry.vatValue == vatValue
        entry.vatRate == vatRate
    }

    def "equals and hashCode should work correctly"(){
        given:
        InvoiceEntry entry1 = new InvoiceEntry("Description",BigDecimal.valueOf(100.00),BigDecimal.valueOf(23),Vat.VAT_23)
        InvoiceEntry entry2 = new InvoiceEntry("Description",BigDecimal.valueOf(100.00),BigDecimal.valueOf(23),Vat.VAT_23)
        InvoiceEntry entry3 = new InvoiceEntry("Description",BigDecimal.valueOf(200.00),BigDecimal.valueOf(8),Vat.VAT_8)

        expect:
        entry1 == entry2
        entry1 != entry3
        entry1.hashCode() == entry2.hashCode()
        entry1.hashCode() != entry3.hashCode()

    }

    def "toString should include description, price, vatValue, and vatRate"(){
        given:
        InvoiceEntry entry = new InvoiceEntry("Description",BigDecimal.valueOf(100.00),BigDecimal.valueOf(23),Vat.VAT_23)

        expect:
        entry.toString().contains("Description")
        entry.toString().contains("100.00")
        entry.toString().contains("23")
        entry.toString().contains("Vat_23")
    }
}
