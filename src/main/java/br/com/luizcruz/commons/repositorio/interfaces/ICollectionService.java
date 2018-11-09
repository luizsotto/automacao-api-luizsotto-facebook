package br.com.luizcruz.commons.repositorio.interfaces;


public interface ICollectionService {
	
	
	void setCollection(String key, Object value);

	Object getCollection(String key);

	<T> T getCollection(String key, Class<T> type);

	Object getCollectionDefault(String key);

}
