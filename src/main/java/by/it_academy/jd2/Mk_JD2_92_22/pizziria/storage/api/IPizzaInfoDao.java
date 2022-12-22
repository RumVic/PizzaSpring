package by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.api;


import by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.entity.PizzaInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPizzaInfoDao extends JpaRepository<PizzaInfo,Long> {
}
