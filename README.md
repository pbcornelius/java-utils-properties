# java-utils-properties
Simple `java.util.Properties` wrapper, which allows easy definition and retrieval of properties via an interface. The `Property` interface allows a straightforward definition of properties in an `enum`. For instance:

```
public enum Properties implements Property {
	INTEGER_PROPERTY("1");

	private final String def;

	private Properties(String def) {
		this.def = def;
	}

	{@literal @}Override
	public String getDefault() {
		return def;
	}
}
```

Now the property `INTEGER_PROPERTY` defined above can be accessed with `getInt(Properties.INTEGER_PROPERTY)` and set with `setInt(Properties.INTEGER_PROPERTY, 3)`.

Since this is a wrapper class for Java's default `java.util.Properties` class, all it's mechanisms and limitations apply.
