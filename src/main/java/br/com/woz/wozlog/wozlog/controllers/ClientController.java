package br.com.woz.wozlog.wozlog.controllers;

import br.com.woz.wozlog.wozlog.domain.models.Client;
import br.com.woz.wozlog.wozlog.domain.repositories.ClientRepository;
import br.com.woz.wozlog.wozlog.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> list() {
        return clientRepository.findAll();
    }

    @GetMapping("/name/{name}")
    public List<Client> getByName(@PathVariable String name) {
        return clientRepository.findByNameContaining(name);
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getById(@PathVariable Long id) {
        return clientRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@Valid @RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("{id}")
    public ResponseEntity<Client> update(@Valid @PathVariable Long id, @RequestBody Client client) {
        if(!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        client.setId(id);
        client = clientService.save(client);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if(!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        clientService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
