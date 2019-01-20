package com.fosagri.rest;



import com.fosagri.model.entity.Adherent;
import com.fosagri.repository.adherent.AdherentRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdherentApi {

    @Autowired
    private AdherentRepository adherentRepository;

    public   String extractPPR(String pprStr){
        String numberOnly= pprStr.replaceAll("[^0-9]", "");
        return numberOnly;
    }

    @RequestMapping(value = "/adherent/getbyppr", params = { "ppr"}, method = RequestMethod.GET, produces = "application/json")
    public  Adherent findByPPR(@RequestParam("ppr") String ppr) {
        String codAg=extractPPR(ppr);
        Adherent adherent = adherentRepository.findByPpr(extractPPR(codAg));
        return adherent;
    }
    @RequestMapping(value = "/adherents" , method = RequestMethod.GET)
    public List<Adherent> findAll()
    {
        System.out.println("Je suis dans Rest");
        return IteratorUtils.toList(adherentRepository.findAll().iterator());
    }





}

