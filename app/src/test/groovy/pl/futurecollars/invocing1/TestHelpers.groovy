package pl.futurecollars.invocing1

import pl.futurecollars.invocing1.model.Company
import pl.futurecollars.invocing1.model.Invoice
import pl.futurecollars.invocing1.model.InvoiceEntry
import pl.futurecollars.invocing1.model.Vat

import java.time.LocalDate

class TestHelpers {

    static company(int id) {
        new Company(("$id").repeat(10),
                "ul. Bukowińska 24d/$id 02-703 Warszawa, Polska",
                "iCode Trust $id Sp. z o.o");
    }

    static product(int id) {
        new InvoiceEntry("Programming course $id", BigDecimal.valueOf(id * 1000), BigDecimal.valueOf(id * 1000 * 0.08), Vat.VAT_8)
    }

    static invoice(int id) {
        new Invoice(LocalDate.now(), company(id), company(id), List.of(product(id)))
    }
}