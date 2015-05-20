package de.barrett.utils.properties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Properties;

/**
 * <p>
 * Simple {@link Properties} wrapper, which allows easy definition and retrieval
 * of properties via an interface. See {@link Property} for how to use the
 * interface with an enum.
 * </p>
 * <p>
 * For instance, the property {@code INTEGER_PROPERTY} defined in an
 * {@code enum Properties} can be accessed with
 * {@code getInt(Properties.INTEGER_PROPERTY)} and set with
 * {@code setInt(Properties.INTEGER_PROPERTY, 3)}.
 * </p>
 * <p>
 * Since this is a wrapper class for Java's default {@link Properties} class,
 * all it's mechanisms and limitations apply.
 * </p>
 * 
 * @author Philipp Cornelius
 * @version 2015-05-20
 */
public class PropertiesWrapper {

	// VARIABLES ----------------------------------------------------- //

	protected final Properties properties = new Properties();

	private Path path;

	private String comment;

	// CONSTRUCTOR --------------------------------------------------- //

	public PropertiesWrapper() {

	}

	public PropertiesWrapper(Path path) {
		this.path = path;
	}

	public PropertiesWrapper(Path path, String comment) {
		this.path = path;
		this.comment = comment;
	}

	// PUBLIC -------------------------------------------------------- //

	public Path getPath() {
		return path;
	}

	public PropertiesWrapper setPath(Path path) {
		this.path = path;
		return this;
	}

	public String getComment() {
		return comment;
	}

	public PropertiesWrapper setComment(String comment) {
		this.comment = comment;
		return this;
	}

	public PropertiesWrapper load() throws IOException {
		Objects.requireNonNull(path);
		properties.loadFromXML(Files.newInputStream(path));
		return this;
	}

	public PropertiesWrapper store() throws IOException {
		Objects.requireNonNull(path);
		properties.storeToXML(Files.newOutputStream(path), comment);
		return this;
	}

	// PROPERTIES ---------------------------------------------------- //

	public String get(Property property) {
		return properties.getProperty(property.name(), property.getDefault());
	}

	public void set(Property property, String value) {
		properties.setProperty(property.name(), value);
	}

	public Integer getInt(Property property) {
		return Integer.valueOf(get(property));
	}

	public void setInt(Property property, Integer value) {
		set(property, value.toString());
	}

	public Long getLong(Property property) {
		return Long.valueOf(get(property));
	}

	public void setLong(Property property, Long value) {
		set(property, value.toString());
	}

	public Double getDouble(Property property) {
		return Double.valueOf(get(property));
	}

	public void setDouble(Property property, Double value) {
		set(property, value.toString());
	}

	public Boolean getBoolean(Property property) {
		return Boolean.valueOf(get(property));
	}

	public void setBoolean(Property property, Boolean value) {
		set(property, value.toString());
	}

}