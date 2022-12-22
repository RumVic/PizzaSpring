package by.it_academy.jd2.Mk_JD2_92_22.pizziria.service.entity;

import by.it_academy.jd2.Mk_JD2_92_22.pizziria.DTO.entity.PizzaInfoDTO;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.builders.PizzaInfoBuilder;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.service.api.IPizzaInfoService;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.api.IPizzaInfoDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.entity.PizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.entity.api.IPizzaInfo;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Transactional
public class PizzaInfoService implements IPizzaInfoService {

    private final IPizzaInfoDao pizzaInfoDao;

    public PizzaInfoService(IPizzaInfoDao pizzaInfoDao) {
        this.pizzaInfoDao = pizzaInfoDao;}

    @Override
    public PizzaInfo create(PizzaInfoDTO pizzaInfoDTO) {
               return pizzaInfoDao.save(PizzaInfoBuilder.create()
                .setDtCreate(LocalDateTime.now())
                .setDtUpdate(LocalDateTime.now())
                .setName(pizzaInfoDTO.getName())
                .setDescription(pizzaInfoDTO.getDescription())
                .setSize(pizzaInfoDTO.getSize())
                .build());
    }

    @Override
    @Transactional
    public PizzaInfo update(long id, LocalDateTime dtUpdate, PizzaInfoDTO pizzaInfoDTO) {


        PizzaInfo readed = pizzaInfoDao.getReferenceById(id);

        if (readed == null) {
            throw new IllegalArgumentException("Меню не найдено");
        }


        if (!readed.getDtUpdate().isEqual(dtUpdate)) {
            throw new IllegalArgumentException("К сожалению меню уже было отредактировано кем-то другим");
        }

        PizzaInfo pizzaInfoUpdate = PizzaInfoBuilder.create()
                .setDtCreate(readed.getDtCreate())
                .setDtUpdate(LocalDateTime.now())
                .setName(pizzaInfoDTO.getName())
                .setDescription(pizzaInfoDTO.getDescription())
                .setSize(pizzaInfoDTO.getSize())
                .build();

        return pizzaInfoDao.save(pizzaInfoUpdate);
    }

    @Override
    public PizzaInfo read(long id) {
        return pizzaInfoDao.getReferenceById(id);
    }

    @Override
    public List<PizzaInfo> get() {
        return pizzaInfoDao.findAll();
    }


/*    @Override
    public void delete(long id, LocalDateTime dtUpdate) {
        pizzaInfoDao.delete(id, dtUpdate);
    }*/
}

