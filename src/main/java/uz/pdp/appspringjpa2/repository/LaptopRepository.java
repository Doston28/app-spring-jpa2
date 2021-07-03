package uz.pdp.appspringjpa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appspringjpa2.model.Laptop;


@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Integer> {
}
