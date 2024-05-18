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
import services.ClientService;

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
	private ClientService clientSerice;
	
	@PostConstruct
	public void init() {
		clientSerice = new ClientService();
//		clients = clientSerice.getAllClients();  // enable it after setting getAllClients CRUD method
		
		// initialize cities list (chi baraka w safi)
		cities = new ArrayList();
		cities.add("Rabat");
		cities.add("Sale");
		cities.add("Kenitra");
		cities.add("Casablanca");
		cities.add("Tangier");
		cities.add("Fes");
	}
	
	public void addClient() {
		clientSerice.addClient(new Client(firstName, lastName, address, selectedCity, phone));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Client added"));

		// return clients = clientSerice.getAllClients();  
		// enable it after setting getAllClients CRUD method to refresh table after inserting
	}
	
	public String getSelectedCity() {
		return selectedCity;
	}

	public void setSelectedCity(String selectedCity) {
		this.selectedCity = selectedCity;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public ClientService getClientSerice() {
		return clientSerice;
	}

	public void setClientSerice(ClientService clientSerice) {
		this.clientSerice = clientSerice;
	}

}
