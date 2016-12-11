package utils;
/**
 * Interface to be implemented in XMLSerializer
 * @author ciaran
 * @version asparagus
 * @data 11/12/2016
 *
 */
public interface Serializer {

	  void push(Object o);
	  Object pop();
	  void write() throws Exception;
	  void read() throws Exception;
	  
}
