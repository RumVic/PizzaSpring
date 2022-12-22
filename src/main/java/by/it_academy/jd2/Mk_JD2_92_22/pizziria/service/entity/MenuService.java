package by.it_academy.jd2.Mk_JD2_92_22.pizziria.service.entity;


import by.it_academy.jd2.Mk_JD2_92_22.pizziria.DTO.entity.MenuDTO;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.builders.MenuBuilder;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.service.api.IMenuService;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.api.IMenuDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.entity.Menu;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.entity.api.IMenu;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Transactional(readOnly = true)
public class MenuService implements IMenuService {

    private final IMenuDao menuDao;

    public MenuService(IMenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Override
    public Menu create(MenuDTO menuDTO) {
        return menuDao.save(MenuBuilder.create()
                .setDtCreate(LocalDateTime.now())
                .setDtUpdate(LocalDateTime.now())
                .setName(menuDTO.getName())
                .setEnabled(menuDTO.isEnabled())
                .build());
    }

    @Override
    public Menu read(long id) {
        return menuDao.getReferenceById(id);
    }

    @Override
    public List<Menu> get() {
        return menuDao.findAll();
    }

    @Override
    @Transactional
    public Menu update(long id, LocalDateTime dtUpdate, MenuDTO menuDTO) {
        IMenu readed = menuDao.getReferenceById(id);

        if (readed == null) {
            throw new IllegalArgumentException("Меню не найдено");
        }


        if (!readed.getDtUpdate().isEqual(dtUpdate)) {
            throw new IllegalArgumentException("К сожалению меню уже было отредактировано кем-то другим");
        }

        Menu menuUpdate = MenuBuilder.create()
                .setDtCreate(readed.getDtCreate())
                .setDtUpdate(LocalDateTime.now())
                .setName(menuDTO.getName())
                .setEnabled(menuDTO.isEnabled())
                .build();

        return menuDao.save(menuUpdate);
    }


 /*   @Transactional
    public Menu update(long id, LocalDateTime dtUpdate, MenuDTO menuDTO) {

        IMenu readed = menuDao.getReferenceById(id);

        if (readed == null) {
            throw new IllegalArgumentException("Меню не найдено");
        }


        if (!readed.getDtUpdate().isEqual(dtUpdate)) {
            throw new IllegalArgumentException("К сожалению меню уже было отредактировано кем-то другим");
        }

        Menu menuUpdate = MenuBuilder.create()
                .setDtCreate(readed.getDtCreate())
                .setDtUpdate(LocalDateTime.now())
                .setName(menuDTO.getName())
                .setEnabled(menuDTO.isEnabled())
                .build();

        return menuDao.save(menuUpdate);
    }*/

 /*   @Override
    public void delete(long id, LocalDateTime dtUpdate) {
        menuDao.delete();
    }*/
}
