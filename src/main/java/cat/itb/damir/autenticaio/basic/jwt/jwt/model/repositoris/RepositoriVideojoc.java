package cat.itb.damir.autenticaio.basic.jwt.jwt.model.repositoris;


import cat.itb.damir.autenticaio.basic.jwt.jwt.model.entitats.Videojoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoriVideojoc extends JpaRepository<Videojoc, Long> {

}
