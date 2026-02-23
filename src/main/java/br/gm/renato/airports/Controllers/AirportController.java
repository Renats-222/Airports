package br.gm.renato.airports.Controllers;

import br.gm.renato.airports.Service.AirportService;
import br.gm.renato.airports.entities.Airport;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */

@RestController
public class AirportController {
    
    @Autowired
    private AirportService airportService;

    @GetMapping("/airport")
    public List<Airport> findAll() {

        List<Airport> result = airportService.findAll();
        return result;

    }
}
