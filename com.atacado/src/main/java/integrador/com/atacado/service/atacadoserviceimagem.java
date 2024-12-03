package integrador.com.atacado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import integrador.com.atacado.model.atacadomodel;
import integrador.com.atacado.repository.atacadaoRepository;

@Service
public class atacadoserviceimagem {

	
    @Autowired
    private atacadaoRepository repo;

    public List<atacadomodel> listarTodos() {
        return repo.findAll();
    }

    public atacadomodel salvar(atacadomodel produto) {
        return repo.save(produto);
    }

    public atacadomodel buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deletar(Long id) {
    	repo.deleteById(id);
    }
}


