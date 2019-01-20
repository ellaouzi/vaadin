package com.fosagri.repository.prestation;

import com.fosagri.model.entity.Prestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestationRepository extends JpaRepository<Prestation, Integer> {
	@Query("select p from Prestation p order by p.titre")
	List<Prestation> getAllPrestations();
	
	@Query("select count(p) from Prestation p where p.prestationId =:prestationId")
	Integer getNumOfAdherentForPrestations(@Param("prestationId") Integer prestationId);

}
