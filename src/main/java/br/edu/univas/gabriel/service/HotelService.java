package br.edu.univas.gabriel.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univas.gabriel.controller.exception.InvalidDataException;
import br.edu.univas.gabriel.controller.exception.ObjectNotFoundException;
import br.edu.univas.gabriel.dto.HotelDto;
import br.edu.univas.gabriel.model.Hotel;
import br.edu.univas.gabriel.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	public List<HotelDto> getAll(){
		List<Hotel> hoteis = (List<Hotel>) hotelRepository.findAll();
		return hoteis.stream()
				.map(hotel -> new HotelDto(hotel.getNumeroQuarto(), hotel.getClasse(), hotel.getDescricao(), hotel.getValorDiaria(), convertDateToString(hotel.getDataManutencao())))
				.collect(Collectors.toList());
	}
	
	public HotelDto getById(Long id){
		Hotel hotel = hotelRepository.findOne(id);
		if(hotel == null) {
			throw new ObjectNotFoundException("Id não encontrado");
		} else {
			return new HotelDto(hotel.getNumeroQuarto(), hotel.getClasse(), hotel.getDescricao(), hotel.getValorDiaria(), convertDateToString(hotel.getDataManutencao()));
		}
	}


	public void create(HotelDto dto)  {
		validateNumeroQuarto(dto.getNumeroQuarto());	
		try {
			Hotel hotel = toHotel(dto);
			hotelRepository.save(hotel);
		} catch (ParseException e) {
			throw new InvalidDataException("Data inválida");
		}
	}
	
	public void delete(Long id) {
		Hotel hotel = hotelRepository.findOne(id);
		if(hotel == null) {
			throw new ObjectNotFoundException("Id não encontrado");
		} else {
			hotelRepository.delete(hotel);
		}
	}
	
	public void update(Long id, HotelDto dto) {
		Hotel oldHotel = hotelRepository.findOne(id);
		
		if(oldHotel == null) {
			throw new ObjectNotFoundException("Id não encontrado");
		} else {
			try {
				validateNumeroQuartoOnUpdate(dto.getNumeroQuarto(), oldHotel.getId());
				
				Hotel hotel = toHotel(dto);
				hotel.setId(oldHotel.getId());
				
				hotelRepository.save(hotel);
			} catch (ParseException e) {
				throw new InvalidDataException("Data inválida");
			}
		}
	}
	
	
	private Hotel toHotel(HotelDto dto) throws ParseException {
		Hotel hotel = new Hotel();
		hotel.setDescricao(dto.getDescricao());
		hotel.setDataManutencao(convertDateToLong(dto.getDataManutencao()));
		hotel.setNumeroQuarto(dto.getNumeroQuarto());
		hotel.setClasse(dto.getClasse());
		hotel.setValorDiaria(dto.getValorDiaria());
		return hotel;
	}
	
	private long convertDateToLong(String dateString) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		dateFormat.setLenient(false);
		Date date = dateFormat.parse(dateString);
		return date.getTime();
	}

	private String convertDateToString(long date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		dateFormat.setLenient(false);
        return dateFormat.format(date);
	}
	
	private void validateNumeroQuarto(int number) {
		Optional<Hotel> hotel = hotelRepository.findHotelByNumeroQuarto(number);
		if(hotel.isPresent()) {
			throw new InvalidDataException("O número do quarto já foi utilizado");
		}
	}
	
	private void validateNumeroQuartoOnUpdate(int number, Long id) {
		Optional<Hotel> hotel = hotelRepository.findHotelByNumeroQuarto(number);
		if(hotel.isPresent() && !id.equals(hotel.get().getId())) {
			throw new InvalidDataException("O número do quarto já foi utilizado");
		}
	}

}
