package br.com.globalcode.ginga.resource;

import br.com.globalcode.ginga.model.Conteudo;
import br.com.globalcode.ginga.service.TwitteService;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author otaviojava
 */
@Path("/produto")
@RequestScoped
public class ProdutoResource {
     @Inject
    private TwitteService twitteService;

    private static final String HASH_TAG="#";
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON+ ";charset=utf-8")
    public List<Conteudo> getConteudos(@PathParam("id") String id, @QueryParam("quantidade") int quantidade) {

        return twitteService.buscaHashTagTwette(HASH_TAG + id, quantidade);
    }
    
}
