package DemoBackend.demo.controller;

import DemoBackend.demo.model.Client;
import DemoBackend.demo.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping("/all")
    public ResponseEntity<List<Client>>findAll() {
        return ResponseEntity.ok(clientService.getAllClient());
    }

    @GetMapping(value ="/client/{id}")
    public Client getClientById(@PathVariable("id") Integer id) {
        return clientService.getClientById(id);
    }

    @PutMapping("/editClient")
    public void addClient(@RequestBody Client client) {
        clientService.updateClient(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClientById(@PathVariable("id") Integer id) {
        clientService.deleteClient(id);
    }

    @PatchMapping("/updateClient")
    public void updateClient(@RequestBody Client client){
        clientService.updateClient(client);
    }
    @PostMapping("/newClient")
    public void  saveClient(@RequestBody Client client){
        clientService.addClient(client);
    }

}
