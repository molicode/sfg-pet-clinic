package molicode.springframework.sfgpetclinic.services;

import java.util.Set;

import molicode.springframework.sfgpetclinic.model.Owner;

public interface OwnerService {

  Owner findByLastName(String lastName);

  Owner findById(Long id);

  Owner save(Owner owner);

  Set<Owner> findAll();

}
