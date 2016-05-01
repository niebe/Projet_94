package model;

public class Field {
	private int id;
	private String name;
	private String type;
	private Boolean alterable;
	private Template template;
	
	public Field(){
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAlterable() {
		return alterable;
	}

	public void setAlterable(boolean alterable) {
		this.alterable = alterable;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}
}
