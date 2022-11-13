package molicode.springframework.sfgpetclinic.bootstrap;

import molicode.springframework.sfgpetclinic.model.Owner;
import molicode.springframework.sfgpetclinic.model.Vet;
import molicode.springframework.sfgpetclinic.services.OwnerService;
import molicode.springframework.sfgpetclinic.services.VetService;
import molicode.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import molicode.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;


  public DataLoader() {
    ownerService = new OwnerServiceMap();
    vetService = new VetServiceMap();

  }

  @Override
  public void run(String... args) throws Exception {
    Owner owner1 = new Owner();
    owner1.setId(1L);
    owner1.setFirstName("Michael");
    owner1.setLastName("Weston");

    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner1.setId(2L);
    owner2.setFirstName("Fiona");
    owner2.setLastName("Gleananne");

    ownerService.save(owner2);

    System.out.println("Loaded Owners...");

    Vet vet1 = new Vet();
    owner1.setId(1L);
    vet1.setFirstName("Sam");
    vet1.setLastName("Axe");

    vetService.save(vet1);

    Vet vet2 = new Vet();
    owner1.setId(2L);
    vet2.setFirstName("Jessie");
    vet2.setLastName("Porter");

    vetService.save(vet2);

    System.out.println("Loaded Vets...");


  }
}
