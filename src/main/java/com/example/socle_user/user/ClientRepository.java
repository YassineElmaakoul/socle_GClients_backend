package com.example.socle_user.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


    

    List<Client> findByName(String name);

    List<Client> findByNameAndEmail(String name, String email);

    List<Client> findByEmail(String email);
}