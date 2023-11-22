package cibertec.gestionequipo.controller;

import cibertec.gestionequipo.dao.entity.JugadorEntity;
import cibertec.gestionequipo.dto.JugadorDto;
import cibertec.gestionequipo.handler.response.SuccessResponse;
import cibertec.gestionequipo.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jugador")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @PostMapping("")
    public SuccessResponse<JugadorEntity> registar(@Valid @RequestBody JugadorDto jugador){
        return new SuccessResponse<>(HttpStatus.OK.value(), jugadorService.registrar(jugador));
    }
    @GetMapping("")
    public SuccessResponse<List<JugadorEntity>> listarTodos(){
        return new SuccessResponse<>(HttpStatus.OK.value(), jugadorService.obtenerTodos());
    }

    @GetMapping("{id}")
    public SuccessResponse<JugadorEntity> listarPorId(@PathVariable(value ="id") int idJugador){
        return new SuccessResponse<>(HttpStatus.OK.value(), jugadorService.obtenerPorId(idJugador));
    }
}
