package dictionary.vo;

public class DictionaryVO {

	 private String scientific_name;
	 private String plant_name;
	 private String plant_eng_name;
	 private String plant_country;
	 private String plant_content;
	 private String admin_id;
	public String getScientific_name() {
		return scientific_name;
	}
	public void setScientific_name(String scientific_name) {
		this.scientific_name = scientific_name;
	}
	public String getPlant_name() {
		return plant_name;
	}
	public void setPlant_name(String plant_name) {
		this.plant_name = plant_name;
	}
	public String getPlant_eng_name() {
		return plant_eng_name;
	}
	public void setPlant_eng_name(String plant_eng_name) {
		this.plant_eng_name = plant_eng_name;
	}
	public String getPlant_country() {
		return plant_country;
	}
	public void setPlant_country(String plant_country) {
		this.plant_country = plant_country;
	}
	public String getPlant_content() {
		return plant_content;
	}
	public void setPlant_content(String plant_content) {
		this.plant_content = plant_content;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	@Override
	public String toString() {
		return "DictionaryVO [scientific_name=" + scientific_name + ", plant_name=" + plant_name + ", plant_eng_name="
				+ plant_eng_name + ", plant_country=" + plant_country + ", plant_content=" + plant_content
				+ ", admin_id=" + admin_id + "]";
	}
	 
	 
}
