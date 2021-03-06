package com.luxoft.j8airport.clients;

import com.luxoft.j8airport.domain.Client;
import com.luxoft.j8airport.domain.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService
{
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll()
    {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long clientId)
    {
        return clientRepository.findById(clientId).get();
    }

    @Override
    public Map<Status, Set<Client>> getAllClientsGroupByStatus()
    {
        return clientRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(c -> c.getStatus(), Collectors.toSet()));
    }

    @Override
    public double getAverageAge()
    {
        return getAverageAge(clientRepository.findAll());
    }

    @Override
    public double getAverageAge(Status status)
    {
        return getAverageAge(clientRepository.findByStatus(status));
    }

    private double getAverageAge(List<Client> clients)
    {
        return clients.stream()
                .mapToInt(c -> c.getAge())
//                .peek(i -> System.out.println(i))
                .average()
                .getAsDouble();
    }


}
