/*
    // A class for binding key/value pairs.
    // (c) 1998,2001 duane a. bailey

    Clase Association que almacena tendría los valores del árbol

    José Mariano Reyes 20074

*/
public class Association<K,V> {

    protected K theKey; // the key of the key-value pair

    protected V theValue; // the value of the key-value pair

    //Constructor 
    public Association(K key, V value)
    {       
        theKey = key;
        theValue = value;
    }

    //Constructor sin valor
    public Association(K key)
    {
        this(key,null);
    }

    //Comparacion de llaves
    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }
    
    /**
     * Standard hashcode function.
     *
     * @post return hash code association with this association
     * @return A hash code for association.
     * @see Hashtable
     */
    public int hashCode()
    {
        return getKey().hashCode();
    }
    
    /**
     * Fetch value from association.  May return null.
     *
     * @post returns value from association
     * @return The value field of the association.
     */
    public V getValue()
    {
        return theValue;
    }

    /**
     * Fetch key from association.  Should not return null.
     *
     * @post returns key from association
     * @return Key of the key-value pair.
     */
    public K getKey()
    {
        return theKey;
    }

    /**
     * Sets the value of the key-value pair.
     *
     * @post sets association's value to value
     * @param value The new value.
     */
    public V setValue(V value)
    {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }

    /**
     * Standard string representation of an association.
     *
     * @post returns string representation
     * @return String representing key-value pair.
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+getKey()+"="+getValue()+">");
        return s.toString();
    }
}
