package br.com.woz.wozlog.wozlog.services;

import br.com.woz.wozlog.wozlog.domain.models.Client;
import br.com.woz.wozlog.wozlog.domain.repositories.ClientRepository;
import br.com.woz.wozlog.wozlog.exceptions.RuleExcetion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;

    public Client getById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuleExcetion("Cliente não encontrado."));
    }

    @Transactional
    public Client save(Client client) {
        boolean emailInUse = clientRepository.findByEmail(client.getEmail())
                .stream()
                .anyMatch(clientExist -> !clientExist.equals(client));

        if(emailInUse) {
            throw new RuleExcetion("E-mail em uso!");
        }

        return clientRepository.save(client);
    }

    @Transactional
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
