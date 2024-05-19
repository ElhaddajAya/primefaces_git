package beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import services.ClientService;

@Data
@NoArgsConstructor
@AllArgsConstructor

@ManagedBean
@ViewScoped
public class ClientView {
    private List<Client> clients;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String phone;
    private List<String> cities;
    private String selectedCity;

    @Inject
    private ClientService clientService;

    @PostConstruct
    public void init() {
        clients = clientService.getAllClients();
        cities = new ArrayList<>();
        cities.add("Rabat");
        cities.add("Sale");
        cities.add("Kenitra");
        cities.add("Casablanca");
        cities.add("Tangier");
        cities.add("Fes");
    }

    public void addClient() {
        Client newClient = new Client();
        newClient.setFirstName(firstName);
        newClient.setLastName(lastName);
        newClient.setAddress(address);
        newClient.setCity(selectedCity);
        newClient.setPhone(phone);

        clientService.addClient(newClient);
        clients = clientService.getAllClients();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Client added"));
    }

}
