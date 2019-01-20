package com.fosagri.rest;

import com.fosagri.model.entity.Prestation;
import com.fosagri.repository.adherent.AdherentRepository;
import com.fosagri.repository.prestation.PrestationRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PrestationApi {

    @Autowired
    private PrestationRepository prestationRepository;

    @Autowired
    private AdherentRepository adherentRepository;



    @RequestMapping(value = "/prestation/{ppr}/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateEnafant(@PathVariable(value = "ppr") String ppr, @RequestBody Prestation prestationDto, HttpServletRequest request) {
        prestationDto.setCodAg(ppr);
        prestationDto.setStatut("Nouveau");
        prestationDto.setDateprestation(new Date());
        prestationRepository.save(prestationDto);
    }

    @RequestMapping(value = "/prestation/add", method = RequestMethod.POST)
    public @ResponseBody
    String addPrestation( @RequestBody Prestation prestationDto) {

        System.out.println("----------------------------------------------------------------#################################");
        System.out.println(prestationDto);
        prestationDto.setStatut("Nouveau");
        prestationDto.setDateprestation(new Date());
        Prestation presta= new Prestation();
        //PrestationDto(prestationId=0, nom=, titre=null, dateprestation=null, statut=null, type=Ellaouzi, distination=null, benificiare=Casa, codAg=1)

        presta.setAdherent(adherentRepository.findByPpr(prestationDto.getCodAg()));
        presta.setType(prestationDto.getType());
        presta.setNom("Colonie 2019");
        presta.setTitre("Colonie de vacance");
        presta.setStatut("Nouvelle");
        presta.setType("Adhérent");
        presta.setCodAg(prestationDto.getCodAg());
        presta.setChoix1(prestationDto.getChoix1());
        presta.setPeriode1(prestationDto.getPeriode1());
        presta.setBenificiare(prestationDto.getBenificiare());
        presta.setDateprestation(new Date());
        presta.setDistination(prestationDto.getDistination());
        prestationRepository.save(presta);
        return "OK";

    }




    @RequestMapping(value = "/demandes", method = RequestMethod.GET)
    public List<Prestation> read() {
        System.out.println(IteratorUtils.toList(prestationRepository.findAll().iterator()));
        return  IteratorUtils.toList(prestationRepository.findAll().iterator());
    }


}

