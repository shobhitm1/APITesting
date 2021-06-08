package pojo;

import java.util.List;

public class course {
	
	private List<webautomation> webautomation;
	private List<api> api;
	private List<mobile> mobile;
	public List<pojo.webautomation> getWebutomation() {
		return webautomation;
	}
	public void setWebAutomation(List<pojo.webautomation> webAutomation) {
		this.webautomation = webAutomation;
	}
	public List<pojo.api> getApi() {
		return api;
	}
	public void setApi(List<pojo.api> api) {
		this.api = api;
	}
	public List<pojo.mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<pojo.mobile> mobile) {
		this.mobile = mobile;
	}
	
}
