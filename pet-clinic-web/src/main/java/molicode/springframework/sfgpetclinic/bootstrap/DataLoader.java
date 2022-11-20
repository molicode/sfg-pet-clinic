package molicode.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import molicode.springframework.sfgpetclinic.model.Owner;
import molicode.springframework.sfgpetclinic.model.Pet;
import molicode.springframework.sfgpetclinic.model.PetType;
import molicode.springframework.sfgpetclinic.model.Speciality;
import molicode.springframework.sfgpetclinic.model.Vet;
import molicode.springframework.sfgpetclinic.services.OwnerService;
import molicode.springframework.sfgpetclinic.services.PetTypeService;
import molicode.springframework.sfgpetclinic.services.SpecialtyService;
import molicode.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;

  private final VetService vetService;

  private final PetTypeService petTypeService;

  private final SpecialtyService specialtyService;

  public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialtyService = specialtyService;
  }

  @Override
  public void run(String... args) throws Exception {

    int count = petTypeService.findAll().size();
    if (count == 0) {
      loadData();
    }

  }

  private void loadData() {
    //***************************************************** PetType

    PetType dog = new PetType();
    dog.setName("Dog");
    PetType savedDogPetType = petTypeService.save(dog);

    PetType cat = new PetType();
    cat.setName("Cat");
    PetType savedCatPetType = petTypeService.save(cat);

    System.out.println("Loaded PetType...");

    //***************************************************** Speciality

    Speciality radiology = new Speciality();
    radiology.setDescription("Radiology");
    Speciality savedRadiology = specialtyService.save(radiology);

    Speciality surgery = new Speciality();
    surgery.setDescription("Surgery");
    Speciality savedSurgery = specialtyService.save(surgery);

    Speciality dentistry = new Speciality();
    dentistry.setDescription("Dentistry");
    Speciality savedDentistry = specialtyService.save(dentistry);

    System.out.println("Loaded Speciality...");

    //***************************************************** Owner

    Owner owner1 = new Owner();
    owner1.setFirstName("Michael");
    owner1.setLastName("Weston");
    owner1.setAddress("123 Brickerel");
    owner1.setCity("Miami");
    owner1.setTelephone("111111111");

    Pet mikesPet = new Pet();
    mikesPet.setPetType(savedDogPetType);
    mikesPet.setOwner(owner1);
    mikesPet.setBithDate(LocalDate.now());
    mikesPet.setName("Rosco");
    owner1.getPets().add(mikesPet);

    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Fiona");
    owner2.setLastName("Gleananne");
    owner2.setAddress("123 Brickerel");
    owner2.setCity("Miami");
    owner2.setTelephone("111111111");

    Pet fionasCat = new Pet();
    fionasCat.setPetType(savedCatPetType);
    fionasCat.setOwner(owner2);
    fionasCat.setBithDate(LocalDate.now());
    fionasCat.setName("Just Cat");
    owner2.getPets().add(fionasCat);

    ownerService.save(owner2);

    System.out.println("Loaded Owners...");

    //***************************************************** Vet

    Vet vet1 = new Vet();
    vet1.setFirstName("Sam");
    vet1.setLastName("Axe");
    vet1.getSpecialities().add(savedRadiology);

    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Jessie");
    vet2.setLastName("Porter");
    vet2.getSpecialities().add(savedSurgery);

    vetService.save(vet2);

    Vet vet3 = new Vet();
    vet3.setFirstName("Harry");
    vet3.setLastName("Potter");
    vet3.getSpecialities().add(savedDentistry);

    vetService.save(vet3);

    System.out.println("Loaded Vets...");

  }

}
