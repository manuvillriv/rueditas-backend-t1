package pe.edu.cibertec.exament1_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.exament1_backend.dto.BuscarRequestDTO;
import pe.edu.cibertec.exament1_backend.dto.BuscarResponseDTO;
import pe.edu.cibertec.exament1_backend.service.AutenticacionService;

import java.io.IOException;
import java.util.Arrays;


@RestController
@RequestMapping("/autenticacion")
public class AutenticarController {

    @Autowired
    AutenticacionService autenticacionService;

    @PostMapping("/buscar")
    public BuscarResponseDTO buscar(@RequestBody BuscarRequestDTO buscarRequestDTO) {

        try {
            String[] datosVehiculo = autenticacionService.validarPlaca(buscarRequestDTO);
            System.out.println("Resultado: " + Arrays.toString(datosVehiculo));
            if (datosVehiculo == null) {
                return new BuscarResponseDTO("01", "No se encontró un vehículo para la placa ingresada", "", "", null, null, "");
            }
            return new BuscarResponseDTO("00", "", datosVehiculo[0], datosVehiculo[1], Integer.parseInt(datosVehiculo[2]), Double.parseDouble(datosVehiculo[3]), datosVehiculo[4]);

        } catch (IOException e) {
            return new BuscarResponseDTO("99", "Ocurio un problema", "", "", null, null, "");
        }

    }
}
