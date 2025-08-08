package springbootassi15.controller;

import springbootassi15.entity.Client;
import springbootassi15.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    // Show all clients
    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", repository.findAll());
        return "list"; // matches list.html
    }

    // Show add client form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("client", new Client());
        return "add-client"; // matches add-client.html
    }

    // Handle add client form submit
    @PostMapping("/add")
    public String addClient(@ModelAttribute Client client) {
        repository.save(client);
        return "redirect:/clients";
    }

    // Show edit client form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Client client = repository.findById(id).orElseThrow();
        model.addAttribute("client", client);
        return "edit-client"; // matches edit-client.html
    }

    // Handle edit client form submit
    @PostMapping("/edit/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute Client client) {
        client.setId(id);
        repository.save(client);
        return "redirect:/clients";
    }

    // Handle delete client
    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/clients";
    }
}
