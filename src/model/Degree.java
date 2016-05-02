package model;

public class Degree {
	private int id;
	private String codTitle;
	private Template template;
	private Boolean enable;
	
	public Degree(){
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCodTitle() {
		return codTitle;
	}

	public void setCodTitle(String codTitle) {
		this.codTitle = codTitle;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}	
	
}
