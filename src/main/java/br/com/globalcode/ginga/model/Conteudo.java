
package br.com.globalcode.ginga.model;

/**
 *Classe que representa o conteudo a ser enviado
 * @author otaviojava
 */
public class Conteudo {
   /**
	 * Descrição do conteúdo.
	 */
	private String descricao;

	/**
	 * Caminho da imagem relacionada ao conteúdo.
	 */
	private String imagem;

	/**
	 * Nome do conteúdo.
	 */
	private String nome;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        
        return  31 * 1 + (this.nome != null ? this.nome.hashCode() : 0);
        
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conteudo other = (Conteudo) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        return true;
    }
        
        
        
}
