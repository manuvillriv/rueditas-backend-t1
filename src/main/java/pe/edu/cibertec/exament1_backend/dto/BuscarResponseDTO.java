package pe.edu.cibertec.exament1_backend.dto;

public record BuscarResponseDTO(String codigo, String mensaje, String marca, String modelo, Integer nroAsientos, Double precio, String color) {
}
