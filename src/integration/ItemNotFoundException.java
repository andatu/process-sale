package integration;

/**
 * This object is going to be thrown if some method in the Inventory system is
 * called and it does not work as intended, something went wrong.
 */

public class ItemNotFoundException extends Exception{
    /**
     * This method instantiates an object of this class. The object is
     * representative a representation of the error message that is sent to it.
     *
     * @param msg a description of what caused the exception.
     */
    ItemNotFoundException(String msg){
        super(msg);
    }
}