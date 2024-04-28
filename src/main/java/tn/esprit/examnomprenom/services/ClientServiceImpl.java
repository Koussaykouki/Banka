package tn.esprit.examnomprenom.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examnomprenom.entities.Client;
import tn.esprit.examnomprenom.repositories.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService{
    private final ClientRepository clientRepository;
    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
}
