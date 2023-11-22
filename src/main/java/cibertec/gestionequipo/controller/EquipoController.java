package cibertec.gestionequipo.controller;

import cibertec.gestionequipo.dao.entity.EquipoEntity;
import cibertec.gestionequipo.dto.EquipoDto;
import cibertec.gestionequipo.dto.ErrorDto;
import cibertec.gestionequipo.handler.response.SuccessResponse;
import cibertec.gestionequipo.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equipo")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;
/*
    @ExceptionHandler(Exception.class)
    private ResponseEntity mensajeExcepciones(){
        ErrorDto errorDto = new ErrorDto(HttpStatus.CONFLICT.toString(), "Problemas","Ha ocurrido un error en la aplicación");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDto);
    }*/
    @GetMapping("")
    public SuccessResponse<List<EquipoEntity>> obtenerTodos(){
        return new SuccessResponse<>(HttpStatus.OK.value(), equipoService.obtenerTodos());
    }

    @PostMapping("")
    public EquipoEntity registrar( @Valid @RequestBody EquipoDto equipoDto){
        return  equipoService.registrar(equipoDto);
    }

    @PutMapping("{id}")
    public EquipoEntity editar(@RequestBody EquipoDto equipoDto, @PathVariable(value = "id") int idEquipo){
        equipoDto.setIdEquipo(idEquipo);
        return equipoService.editar(equipoDto);
    }

    @DeleteMapping("{id}")
    public void eliminar(@PathVariable(value="id") int idEquipo){
        equipoService.eliminar(idEquipo);
    }

    @GetMapping("{id}")
    public EquipoEntity obtenerEquipo(@PathVariable(value="id") int idEquipo){
        return equipoService.obtenerEquipo(idEquipo);
    }
}
