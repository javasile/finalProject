package DemoBackend.demo.service;
import DemoBackend.demo.model.Invoice;
import DemoBackend.demo.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoice(){
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(Integer id){
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    @Override
    public void addInvoice(Invoice invoice) {
        Optional<Invoice> invoiceOp = invoiceRepository.findById(invoice.getId());
        if(invoiceOp.isPresent()) {
            throw new IllegalArgumentException("Product already exists!");
        }
        invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        getInvoiceById(invoice.getId());
        return invoiceRepository.save(invoice);
    }

    @Override
    public void deleteInvoice(Integer id) {
        getInvoiceById(id);
        invoiceRepository.deleteById(id);

    }
}
