package pe.edu.cibertec.exament1_backend.service;

import pe.edu.cibertec.exament1_backend.dto.BuscarRequestDTO;

import java.io.IOException;

public interface AutenticacionService {

    String[] validarPlaca(BuscarRequestDTO buscarRequestDTO) throws IOException;

}
