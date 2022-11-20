package molicode.springframework.sfgpetclinic.services.map;

import java.util.Set;

import molicode.springframework.sfgpetclinic.model.Speciality;
import molicode.springframework.sfgpetclinic.services.SpecialitiesService;

public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialitiesService {

  @Override
  public Set<Speciality> findAll() {
    return super.findAll();
  }

  @Override
  public Speciality findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Speciality save(Speciality object) {
    return super.save(object);
  }

  @Override
  public void delete(Speciality object) {
    super.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    super.findById(id);
  }

}
