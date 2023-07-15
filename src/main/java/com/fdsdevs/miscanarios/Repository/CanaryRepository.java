package com.fdsdevs.miscanarios.Repository;

import com.fdsdevs.miscanarios.Models.Canary;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CanaryRepository extends JpaRepository<Canary, Long> {
    /*@Query("select p from Persona p where p.nombre like %?1%")//busqueda por un solo campo
    List<Persona> findByName(String nombre);*/
    //@Query("select c from Canary c where c.user_id")
    List<Canary> findCanariesByUserId(Long userId);
}
