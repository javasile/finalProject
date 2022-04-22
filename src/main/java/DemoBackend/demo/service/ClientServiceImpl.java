package DemoBackend.demo.service;

import DemoBackend.demo.model.Client;
import DemoBackend.demo.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;


    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Client not found!"));
    }

    @Override
    public void addClient(Client client) {
        Optional<Client> clientOp = clientRepository.findById(client.getId());
        if (clientOp.isPresent())
            throw new IllegalArgumentException("Client already exists!");

        clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        this.getClientById(client.getId());
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Integer id) {
        this.getClientById(id);
        clientRepository.deleteById(id);

    }
}
