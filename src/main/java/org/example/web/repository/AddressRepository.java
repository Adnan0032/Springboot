package org.example.web.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.example.web.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}