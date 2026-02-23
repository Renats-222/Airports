/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.gm.renato.airports.repositories;

import br.gm.renato.airports.entities.Airport;
import br.gm.renato.airports.projections.AirportNearMeProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author digma
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {
    @Query(nativeQuery = true, value = """
    SELECT 
        airport.id,
        airport.name,
        airport.city,
        airport.iatacode,
        airport.latitude,
        airport.longitude,
        airport.altitude,
        SQRT(
            power(airport.latitude - ?1, 2) +
            power(airport.longitude - ?2, 2)
        ) * 60 * 1.852 AS distanciaKM
    FROM AIRPORT airport
    ORDER BY distanciaKM
    LIMIT 10
""")
List<AirportNearMeProjection> findNearMe(double latOrigem, double lonOrigem);

    List<Airport> findByCityIgnoreCase(String city);
    List<Airport> findByCountryIgnoreCase(String country);
    
    Airport findByIataCode(String iataCode);
    
}
    
    
