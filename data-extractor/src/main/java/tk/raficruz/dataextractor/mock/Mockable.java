package tk.raficruz.dataextractor.mock;

import java.util.ArrayList;
import java.util.List;

public interface Mockable <T> {

	T getMockInstance();

	default List<T> getMockInstanceList(int size){
		List<T> instances = new ArrayList<T>();
		for( int index = 0; index < (size == 0 ? 1 : size) ; index++ ) {
			instances.add(getMockInstance());
		}
		return instances;
	}

}
