package molicode.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet {

  private PetType petType;

  private Owner owner;

  private LocalDate bithDate;

  public PetType getPetType() {
    return petType;
  }

  public void setPetType(PetType petType) {
    this.petType = petType;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  public LocalDate getBithDate() {
    return bithDate;
  }

  public void setBithDate(LocalDate bithDate) {
    this.bithDate = bithDate;
  }
}
