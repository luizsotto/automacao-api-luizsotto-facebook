package br.com.luizcruz.commons.repositorio;

import java.util.HashMap;
import java.util.Map;

import br.com.luizcruz.commons.repositorio.interfaces.ICollectionService;
import br.com.luizcruz.commons.utils.StringUtils;


public class CollectionService implements ICollectionService {
	
	private static CollectionService instance = null;
	private static Map<String, Object> repository = null;
	
	private CollectionService () {
        
    }
    
   public static CollectionService getInstance() {
       if(instance == null) {
           try {
               instance = new CollectionService();
               repository = new HashMap<String, Object>();
           } catch (Exception e) {
               throw new IllegalArgumentException("Erro, ao inicializar o reposit�rio.");
           }
       }
       return instance;
   }

	public void setCollection(String key, Object value) {
		if (StringUtils.isEmptyOrNull(key)) 
			throw new NullPointerException("Chave não pode ser null ou vazio.");
		repository.put(key, value);
	}

	public Object getCollection(String key) {
		if (StringUtils.isEmptyOrNull(key)) 
			throw new NullPointerException("Chave não pode ser null ou vazio.");
		return getCollection(key, Object.class);
	}

	public <T> T getCollection(String key, Class<T> type) {
		return type.cast(repository.get(key));
	}

	public Object getCollectionDefault(String key) {
		return getCollection(key, String.class);
	}
	
	public static CollectionService clean() {
        try {
            instance = null;
            repository = null;
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro, ao inicializar o reposit�rio.");
        }
		return instance;
	}
	
}
