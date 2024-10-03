package br.edu.uniara.api.projetoApi.controller;

import br.edu.uniara.api.projetoApi.model.Dto;
import br.edu.uniara.api.projetoApi.model.DtoUsuario;
import br.edu.uniara.api.projetoApi.model.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {
    @Autowired
    Repository repository;

    @GetMapping
    public List<Dto> selcionaFilmes(){
        final List<Dto> listEmployee = repository.findAll();
        return listEmployee;
    }

    @GetMapping("/testaUsuario")
    public ResponseEntity<String> selcionaFilmes(@RequestParam String usuario, @RequestParam String senha){
        if(usuario.equals("Daniel") && senha.equals("123")){
            return ResponseEntity.ok("Usuário autenticado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos.");
    }

    @PostMapping
    public ResponseEntity<Dto> insereFilme(
            @RequestBody Dto filme
    ) {
        var filmeSalvo = repository.save(filme);
        return ResponseEntity.ok(filmeSalvo);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<Dto> atualizaFilmes(@PathVariable Long id, @RequestBody Dto clienteAtualizado) {
        Dto clienteExistente = repository.findById(id);

        if (clienteExistente == null) {
            return ResponseEntity.notFound().build();
        }

        // Atualize os campos relevantes do clienteExistente com os dados do clienteAtualizado
        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setEmail(clienteAtualizado.getEmail());
        // Adicione outros campos conforme necessário

        Dto clienteSalvo = repository.save(clienteExistente); // Salve as alterações no banco de dados

        return ResponseEntity.ok(clienteSalvo);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaFilmes(@PathVariable Long id) {
        boolean filmeExistente = repository.existsById(id);
        if (!filmeExistente) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok(id + "was removed");
    }
}
