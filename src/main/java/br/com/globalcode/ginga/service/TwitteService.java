/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.globalcode.ginga.service;

import br.com.globalcode.ginga.model.Conteudo;
import java.util.LinkedList;
import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *Classe serviço que realiza busca do twitter
 * @author otaviojava
 */
public class TwitteService {
    
    private static final int TAMANHO_MAXIMO=5;
    private static final String DATA_INICIAL="2013-03-08";
    private static final String USER = "GingaProduto";
    private static final String AND = "&";
    private static final String URL_IMAGEM="http://twitter.com/api/users/profile_image/";
    
    /**
     * método que busca informações no twitter
     * @param hashTag - hashtag
     * @param tamanho - quantidade de twitter à serem enviados no twitter
     * @return - número de twitter baseado nas hashtags
     */
     public List<Conteudo> buscaHashTag(String hashTag,int tamanho) {
         if(tamanho==0){
         tamanho=TAMANHO_MAXIMO;
         }
      
	        TwitterFactory twitterFactory = new TwitterFactory();
	        Twitter twitter = twitterFactory.getInstance();
                Query query = new Query(hashTag);
	        query.setRpp(tamanho);
	        query.setSince(DATA_INICIAL);
	        
                return get(query, twitter);
	    }
     
     public List<Conteudo> buscaHashTagTwette(String hashTag,int tamanho) {
         if(tamanho==0){
         tamanho=TAMANHO_MAXIMO;
         }
                TwitterFactory twitterFactory = new TwitterFactory();
	        Twitter twitter = twitterFactory.getInstance();
                StringBuilder stringQuery=new StringBuilder();
                stringQuery.append("from:");
                stringQuery.append(USER);
                stringQuery.append(AND);
                stringQuery.append(hashTag);
                Query query = new Query(stringQuery.toString());
	        query.setRpp(tamanho);
	        query.setSince(DATA_INICIAL);
	        
                return get(query, twitter);
	    }
     
        private List<Conteudo> get(Query query,Twitter twitter){
              try {
                   List<Conteudo> conteudos=new LinkedList<Conteudo>();
	           QueryResult resultadoBusca = twitter.search(query);
	            List<Tweet> listaTweets = resultadoBusca.getTweets();
	 
	            for(Tweet tweet:listaTweets){
                        conteudos.add(getConteudo(tweet));
                    }
	 
                    return conteudos;
	 
	        } catch (TwitterException e) {    
	            throw  new RuntimeException("Erro ao buscar informações do twitter");
	        }
    }

    private Conteudo getConteudo(Tweet tweet) {
        Conteudo conteudo=new Conteudo();
        conteudo.setDescricao(tweet.getText());
        conteudo.setNome(tweet.getFromUser());
        conteudo.setImagem(URL_IMAGEM.concat(tweet.getFromUser()));
        return conteudo;
    }
}
