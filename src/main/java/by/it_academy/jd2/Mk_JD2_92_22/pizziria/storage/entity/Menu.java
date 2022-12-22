package by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.entity;


import by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.entity.api.IMenu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Menu implements IMenu {
    @Id
    private long id;
    @Column(name = "dt_create")
    private LocalDateTime dtCreate;
    @Column(name = "dt_update")
    private LocalDateTime dtUpdate;
    private String name;
    @Column(name = "enable")
    private boolean enabled;
    @OneToMany
    private List<MenuRow> items;

    public Menu() {
    }

    public Menu(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, String name, boolean enabled, List<MenuRow> items) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.name = name;
        this.enabled = enabled;
        this.items = items;
    }

    public Menu(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, String name, boolean enabled) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.name = name;
        this.enabled = enabled;
    }

    public Menu(LocalDateTime dtCreate, LocalDateTime dtUpdate, String name, boolean enabled) {
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.name = name;
        this.enabled = enabled;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    @Override
    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public List<MenuRow> getItems() {
        return items;
    }

    @Override
    public void setItems(List<MenuRow> items) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id && enabled == menu.enabled && dtCreate.equals(menu.dtCreate) && dtUpdate.equals(menu.dtUpdate) && name.equals(menu.name) && items.equals(menu.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dtCreate, dtUpdate, name, enabled, items);
    }


    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", dtCreate=" + dtCreate +
                ", dtUpdate=" + dtUpdate +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                ", items=" + items +
                '}';
    }

    @Override
    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    @Override
    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
