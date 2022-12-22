package by.it_academy.jd2.Mk_JD2_92_22.pizziria.controllers;

import by.it_academy.jd2.Mk_JD2_92_22.pizziria.DTO.entity.MenuDTO;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.service.api.IMenuService;
import by.it_academy.jd2.Mk_JD2_92_22.pizziria.storage.entity.api.IMenu;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuServlet {

    private final IMenuService service;

    public MenuServlet(IMenuService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/{id}")
    protected ResponseEntity<IMenu> get(@PathVariable long id){
        return ResponseEntity.ok(service.read(id));
    }
    @RequestMapping
    protected ResponseEntity<List<? extends IMenu>> getList(){
        return ResponseEntity.ok(service.get());
    }
    @PostMapping
    protected ResponseEntity<IMenu> doPost(@RequestBody MenuDTO menuDTO){
        IMenu created = this.service.create(menuDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    @PutMapping("/{id}/dt_update/{dt_update}")
    protected ResponseEntity<IMenu> doPut(@PathVariable long id,
                                          @PathVariable("dt_update") long dtUpdateRaw,
                                          @RequestBody MenuDTO menuDTO){

        LocalDateTime dtUpdate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(dtUpdateRaw),
                ZoneId.of("UTC")
        );

        return ResponseEntity.ok(this.service.update(id, dtUpdate, menuDTO));
    }
}
