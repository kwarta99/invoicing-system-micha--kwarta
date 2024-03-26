package pl.futurecollars.invocing1.model

import spock.lang.Specification

class VatTest extends Specification {

    def "Vat enum should have correct rates"() {
        expect:
        Vat.VAT_23.rate == 23
        Vat.VAT_8.rate == 8
        Vat.VAT_5.rate == 5
        Vat.Vat_0.rate == 0
    }

}