package integrador.com.atacado.model;
 
import integrador.com.atacado.dto.atacadoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class atacadomodel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	    private Long id;  
	    private String nome;
	    private Float preco;
	    private String imagem;
			
			public atacadomodel() {
            }

			public Long getId(Long id) {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getNome() {
				return nome;
			}

			public void setNome(String nome) {
				this.nome = nome;
			}

			public Float getPreco() {
				return preco;
			}

			public void setPreco(Float preco) {
				this.preco = preco;
			}

			public String getImagem() {
				return imagem;
			}

			public void setImagem(String imagem) {
				this.imagem = imagem;
			}

			public atacadomodel(Long id, String nome, Float preco, String imagem) {
				 
				this.id = id;
				this.nome = nome;
				this.preco = preco;
				this.imagem = imagem;
			}

			public void updatedDTO(atacadoDTO dto) {
			 
				this.id = dto.id();
				this.nome = dto.nome();
				this.preco = dto.preco();
				this.imagem = dto.imagem();
			}
			
			
			
}

