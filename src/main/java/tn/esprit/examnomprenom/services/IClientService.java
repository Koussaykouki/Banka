package tn.esprit.examnomprenom.services;

import tn.esprit.examnomprenom.entities.Client;

public interface IClientService {
    Client addClient(Client client);
    Client getClientById(Long id);
}
