package integrador.com.atacado.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import integrador.com.atacado.dto.atacadoDTO;
import integrador.com.atacado.model.atacadomodel;
import integrador.com.atacado.repository.atacadaoRepository;
import integrador.com.atacado.service.atacadoserviceimagem;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("atacado")


public class Controller {

	@Autowired
	 private atacadaoRepository repo; 
	
	 @GetMapping("/listar")
	 public ResponseEntity<?> mostrar(){
		 List<atacadomodel> lista = repo.findAll()	;	
	    	return ResponseEntity.ok(lista);
   }
 
	 @PostMapping("/Criar")
		 public ResponseEntity<atacadoDTO>PostProduto (@RequestBody @Valid atacadoDTO produto) {
		        atacadomodel savedproduto = new atacadomodel();
		        System.out.println(produto);
		        repo.save(savedproduto);
		        return ResponseEntity.ok().build();
		 }

 
@PutMapping("/atualizar/{id}")
public ResponseEntity<?> atualizarCarro(@PathVariable Long id, @RequestBody atacadoDTO dto) {
    atacadomodel produto = repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

    
    produto.updatedDTO(dto);

    
    repo.save(produto);

    return ResponseEntity.ok(produto);  
}

          @DeleteMapping("/deletar/{id}")
           public ResponseEntity<Void> deletar(@PathVariable Long id) {
	       atacadoserviceimagem atacadoserviceimagem = new atacadoserviceimagem();
		   atacadoserviceimagem.deletar(id);
            return ResponseEntity.noContent().build();
}
}
