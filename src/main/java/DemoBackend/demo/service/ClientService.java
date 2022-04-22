package DemoBackend.demo.service;

import DemoBackend.demo.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClient();

    Client getClientById(Integer id);

    void addClient(Client client);

    Client updateClient(Client client);

    void deleteClient(Integer id);
}
