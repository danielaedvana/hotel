package br.edu.univas.gabriel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.univas.gabriel.dto.HotelDto;
import br.edu.univas.gabriel.service.HotelService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private HotelService service;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("");
		System.out.println("Mostrando informações dos hoteis antes de nenhuma operação");
		List<HotelDto> hoteis = service.getAll();
		mostrarInfoHoteis(hoteis);

		HotelDto dto1 = new HotelDto(1, "1 classe", "Hotel localizado na serra da Mantiqueira", 200.00, "30/06/2022");
		service.create(dto1);
		
		System.out.println("");
		System.out.println("Mostrando informações dos hoteis depois de um create");
		HotelDto dto4 = service.getById(1l);
		mostrarInfoHotel(dto4);
		
		HotelDto dto2 = new HotelDto(2, "2 classe", "Hotel localizado na serra da Mantiqueira", 100.00, "30/06/2022");
		service.create(dto2);
	
		HotelDto dto3 = new HotelDto(2, "2 classe", "Hotel localizado na Serra da Mantiqueira", 150.00, "30/06/2022");
		service.update(2l, dto3);
		
		System.out.println("");
		System.out.println("Mostrando informações dos hoteis depois de um create e um update");
		hoteis = service.getAll();
		mostrarInfoHoteis(hoteis);
		
		System.out.println("");
		System.out.println("Mostrando informações dos hoteis depois de um delete");
		service.delete(2l);
		
		hoteis = service.getAll();
		hoteis.stream().forEach(hotel -> {
			mostrarInfoHotel(hotel);
		});
	}
	
	private void mostrarInfoHoteis(List<HotelDto> hoteis) {
		if(hoteis.isEmpty()) {
			System.out.println("Nenhum hotel foi encontado");
		} else {
			hoteis.stream().forEach(hotel -> {
				mostrarInfoHotel(hotel);
			});
		}
	}
	
	private void mostrarInfoHotel(HotelDto dto) {
		System.out.println("###############################################");
		System.out.println("Informações do hotel");
		System.out.println("Número do quarto: "+ dto.getNumeroQuarto());
		System.out.println("Classe: "+ dto.getClasse());
		System.out.println("Descrição: "+ dto.getDescricao());
		System.out.println("Valor diária: "+ dto.getValorDiaria());
		System.out.println("Data manutenção: "+ dto.getDataManutencao());
		System.out.println("###############################################");
		System.out.println("");
	}
}
