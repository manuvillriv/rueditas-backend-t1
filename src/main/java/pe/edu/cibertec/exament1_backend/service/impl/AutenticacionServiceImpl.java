package pe.edu.cibertec.exament1_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.exament1_backend.dto.BuscarRequestDTO;
import pe.edu.cibertec.exament1_backend.service.AutenticacionService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validarPlaca(BuscarRequestDTO buscarRequestDTO) throws IOException {

        String[] datosVehiculo = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");
                if (buscarRequestDTO.numPlaca().equals(datos[1])) {

                    datosVehiculo = new String[5];
                    datosVehiculo[0] = datos[2];
                    datosVehiculo[1] = datos[3];
                    datosVehiculo[2] = datos[4];
                    datosVehiculo[3] = datos[5];
                    datosVehiculo[4] = datos[6];
                    break;
                }
            }

        } catch(IOException e) {

            datosVehiculo = null;
            throw new IOException(e);
        }

        return datosVehiculo;
    }
}
