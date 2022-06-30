package br.edu.univas.gabriel.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.gabriel.model.Hotel;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {
	
	Optional<Hotel> findHotelByNumeroQuarto(int numeroQuarto);
}
