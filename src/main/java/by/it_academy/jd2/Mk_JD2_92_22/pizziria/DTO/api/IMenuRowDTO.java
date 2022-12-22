package by.it_academy.jd2.Mk_JD2_92_22.pizziria.DTO.api;


import by.it_academy.jd2.Mk_JD2_92_22.pizziria.DTO.entity.MenuRowDTO;

public interface IMenuRowDTO extends IEssenceDTO<MenuRowDTO> {

    long getInfoNumber();

    double getPrice();

    long getMenu();



}
