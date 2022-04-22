package DemoBackend.demo.controller;

import DemoBackend.demo.model.Invoice;
import DemoBackend.demo.service.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceServiceImpl orderService;

    @GetMapping("/all")
    @ResponseStatus(OK)
    public List<Invoice> findAll() {
        return orderService.getAllInvoice();
    }

    @GetMapping(value = "/invoice/{id}")
    public Invoice getOrderById(@PathVariable("id") Integer id) {
        return orderService.getInvoiceById(id);
    }

    @PutMapping("/editInvoice")
    public void addOrder(@RequestBody Invoice invoice) {
        orderService.addInvoice(invoice);
    }

    @DeleteMapping("/deleteInvoice/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderService.deleteInvoice(id);
    }

    @PatchMapping("/updateInvoice")
    public void updateOrder(@RequestBody Invoice invoice){
        orderService.updateInvoice(invoice);
    }

    @PostMapping("/newInvoice")
    public void saveOrder(@RequestBody Invoice invoice) {
        orderService.addInvoice(invoice);
    }

}
