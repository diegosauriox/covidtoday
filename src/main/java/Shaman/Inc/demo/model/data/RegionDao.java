package Shaman.Inc.demo.model.data;

import Shaman.Inc.demo.model.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionDao extends CrudRepository<Region,Long> {

    Region findByNombre(String nombre);
}
