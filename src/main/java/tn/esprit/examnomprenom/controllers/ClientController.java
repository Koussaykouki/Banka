package tn.esprit.examnomprenom.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examnomprenom.entities.Client;
import tn.esprit.examnomprenom.services.IClientService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final IClientService clientService;

    @PostMapping("/add")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @GetMapping("/get/{id}")
    public Client getClient(@PathVariable Long id){
        return clientService.getClientById(id);
    }

}
