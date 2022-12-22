package by.it_academy.jd2.Mk_JD2_92_22.pizziria.DTO.api;


import by.it_academy.jd2.Mk_JD2_92_22.pizziria.DTO.entity.MenuDTO;

public interface IMenuDTO extends IEssenceDTO<MenuDTO> {
    String getName();

    boolean isEnabled();
}
