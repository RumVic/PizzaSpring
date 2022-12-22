package by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.api;


import by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuDao extends JpaRepository<Menu,Long> {

}
