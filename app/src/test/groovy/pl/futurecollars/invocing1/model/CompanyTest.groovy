package pl.futurecollars.invocing1.model

import spock.lang.Specification

class CompanyTest extends Specification {
    def "should correctly create Company instance"() {
        given:
        def taxId = "1"
        def address = "put some address"
        def name = "name"

        when:

        def company = new Company("1",address,name)

        then:
        company.taxIdentifications == "1"
        company.address == "put some address"
        company.name == "name"

    }
}
