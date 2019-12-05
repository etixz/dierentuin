package eb.egonb.dierentuin.controllers;

import eb.egonb.dierentuin.model.Beest;
import eb.egonb.dierentuin.model.BeestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/bisj")
public class BeestController {

    @Autowired
    BeestDAO dao;

    @RequestMapping(value = "/lijst", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity maakBeest(@RequestParam(value = "naam") String naam,
                                    @RequestParam(value = "soort") String soort){
        Beest nBeest = new Beest();
        nBeest.setNaam(naam);
        nBeest.setSoort(soort);

        dao.save(nBeest);

        return new ResponseEntity(HttpStatus.I_AM_A_TEAPOT);
    }

    @RequestMapping(value = "/lijst", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Beest> toonBisj(){
        return dao.findAll();
    }

}
