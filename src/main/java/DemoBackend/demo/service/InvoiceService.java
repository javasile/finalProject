package DemoBackend.demo.service;


import DemoBackend.demo.model.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getAllInvoice();

    Invoice getInvoiceById(Integer id);

    void addInvoice(Invoice invoice);

    Invoice updateInvoice(Invoice invoice);

    void deleteInvoice(Integer id);
}
