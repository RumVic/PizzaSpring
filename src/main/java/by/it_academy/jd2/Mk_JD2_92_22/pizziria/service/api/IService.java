package by.it_academy.jd2.Mk_JD2_92_22.pizziria.service.api;

import java.time.LocalDateTime;
import java.util.List;

public interface IService<TYPE,DTO>  {

    TYPE create(DTO dto);

    TYPE read(long id);

    List<TYPE> get();

    TYPE update(long id, LocalDateTime dtUpdate, DTO item);


 //   void delete(long id, LocalDateTime dtUpdate);
}
