package cat.itb.damir.autenticaio.basic.jwt.jwt.controladors;


import cat.itb.damir.autenticaio.basic.jwt.jwt.model.entitats.Videojoc;
import cat.itb.damir.autenticaio.basic.jwt.jwt.model.serveis.ServeiVideojoc;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/* CRUD Videojocs *******************************
- 1) llistar tots els videojocs
- 2) Afegir videojoc
- 3) Consultar un Videojoc per long id
- 4) Modificar Videojoc
- 5) Eliminar Videojoc per long id
 ***********************************************/


@RestController
@RequiredArgsConstructor
public class ControladorVideojocs {
    private final ServeiVideojoc serveiVideojocs;

    @GetMapping("/videojocs")
    public ResponseEntity<?> consultarVideojocs() {
        List<Videojoc> res = serveiVideojocs.llistarVideojocs();
        if (res != null) return ResponseEntity.ok(res);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping("/videojocs")
    public ResponseEntity<?> afegirVideojoc(@RequestBody Videojoc v) {
        try {
            serveiVideojocs.afegirVideojoc(v);
            return new ResponseEntity<Videojoc>(v, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping("/videojocs/{id}")
    public ResponseEntity<?> consultarUnVideojoc(@PathVariable long id) {
        Videojoc v = serveiVideojocs.consultarPerId(id);
        if (v != null) {
            return ResponseEntity.ok(v);
        } else return ResponseEntity.notFound().build();
    }

    @PutMapping("/videojocs")
    public ResponseEntity<?> modificarVideojoc(@RequestBody Videojoc vmod){
        Videojoc res=serveiVideojocs.modificarVideojoc(vmod);
        if(res!=null) return ResponseEntity.ok(res);
        else return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/videojocs/{id}")
    public ResponseEntity<?> eliminarVideojoc(@PathVariable long id){
        Videojoc res=serveiVideojocs.eliminarVideojoc(id);
        if(res!=null){
            return ResponseEntity.noContent().build();
        }
        else return ResponseEntity.notFound().build();
    }

}
