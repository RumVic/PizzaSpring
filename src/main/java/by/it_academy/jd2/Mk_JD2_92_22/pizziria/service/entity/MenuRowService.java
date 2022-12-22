package by.it_academy.jd2.Mk_JD2_92_22.pizziria.service.entity;


import by.it_academy.jd2.Mk_JD2_92_22.pizziria.DTO.entity.MenuRowDTO;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.builders.MenuRowBuilder;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.service.api.IMenuRowService;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.api.IMenuRowDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.entity.MenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.entity.api.IMenuRow;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Transactional(readOnly = true)
public class MenuRowService implements IMenuRowService {

    private final IMenuRowDao menuRowDao;

    public MenuRowService(IMenuRowDao menuRowDao) {
        this.menuRowDao = menuRowDao;
    }

    @Override
    public MenuRow create(MenuRowDTO menuRowDTO) {
        return menuRowDao.save(MenuRowBuilder
                .create()
                .setDtCreate(LocalDateTime.now())
                .setDtUpdate(LocalDateTime.now())
                .setInfoNumber(menuRowDTO.getInfoNumber())
                .setPrice(menuRowDTO.getPrice())
                .setMenu(menuRowDTO.getMenu())
                .build());
    }

    @Override
    @Transactional
    public MenuRow update(long id, LocalDateTime dtUpdate, MenuRowDTO menuRowDTO) {

         IMenuRow readed = menuRowDao.getReferenceById(id);

        if (readed == null) {
            throw new IllegalArgumentException("Menu wasn't find");
        }


        if (!readed.getDtUpdate().isEqual(dtUpdate)) {
            throw new IllegalArgumentException("Unfortunately this line was edit somebody else");
        }

        MenuRow menuRowUpdate = MenuRowBuilder.create()
                .setDtCreate(readed.getDtCreate())
                .setDtUpdate(LocalDateTime.now())
                .setInfoNumber(menuRowDTO.getInfoNumber())
                .setPrice(menuRowDTO.getPrice())
                .setMenu(menuRowDTO.getMenu())
                .build();

        return menuRowDao.save(menuRowUpdate);

    }

    @Override
    public MenuRow read(long id) {
        return menuRowDao.getReferenceById(id);
    }

    @Override
    public List<MenuRow> get() {
        return menuRowDao.findAll();
    }

/*

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {
        menuRowDao.delete(id, dtUpdate);
*/


}
