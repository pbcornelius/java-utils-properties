package de.pbc.utils.properties;

/**
 * 
 * Interface used to define and access properties in {@link PropertiesWrapper}.
 * This interface allows easy definition of properties in an {@code enum}. For
 * instance:
 * 
 * <pre>
 * <code>public enum Properties implements Property {
 * 	EXAMPLE_PROPERTY("default value");
 * 
 * 	private final String def;
 * 
 * 	private Properties(String def) {
 * 		this.def = def;
 * 	}
 * 
 * 	{@literal @}Override
 * 	public String getDefault() {
 * 		return def;
 * 	}
 * }
 * </code>
 * </pre>
 * 
 * @author Philipp B. Cornelius
 * @version 2015-05-20
 */
public interface Property {

	// PUBLIC -------------------------------------------------------- //

	/**
	 * Return the uniquely identifying name of this property. This method's
	 * header is equal to every {@code enum}'s {@code name()} method. Thus, if a
	 * property is defined as an {@code enum}, this method will not need to be
	 * implemented.
	 * 
	 * @return unique property name
	 */
	public String name();

	/**
	 * Return the default value of this property. May be {@code null}.
	 * 
	 * @return the default value of this property
	 */
	public String getDefault();

}