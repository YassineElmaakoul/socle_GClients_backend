package com.example.socle_user.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    public Client createUser(@RequestBody Client client) {
        return clientRepository.save(client);
    }


    @GetMapping("")
    public List<Client> searchUsers(@RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "email", required = false) String email) {
        if (name != null && email != null) {
            return clientRepository.findByNameAndEmail(name, email);
        } else if (name != null) {
            return clientRepository.findByName(name);
        } else if (email != null) {
            return clientRepository.findByEmail(email);
        } else {
            return clientRepository.findAll();
        }
    }
    //@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
   /* @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteClients(@PathVariable(value = "id", required = true) Long id){
        Optional<Client> client = clientRepository.findById(id);

        if(client.isPresent()){
            clientRepository.deleteById(id);
            return ResponseEntity.ok("client with id : "+ id + "has been deleted succesfully");
        }else {
            return ResponseEntity.notFound().build();
        }


    }
*/
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteClient(@PathVariable Long id) {
        Optional<Client> client = clientRepository.findById(id);

        if(client.isPresent()){
        clientRepository.deleteById(id);
            return ResponseEntity.ok("client with id : "+ id + "has been deleted succesfully");
        }else {
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("all")
        public List<Client> ListAll(){
        return clientRepository.findAll();
        }

}
