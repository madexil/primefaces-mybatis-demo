package net.demo.mgbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import net.demo.domain.User;
import net.demo.service.IUserService;
import net.demo.service.UserService;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;

public class UserManaged implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7647831074897414061L;

	private User selected;

	private String idSearch = null;
	private String nameSearch = null;
	
	private List<User> resultSearch;
	IUserService service;
	private DataTable dtResult;

	public DataTable getDtResult() {
		return dtResult;
	}

	public void setDtResult(DataTable dtResult) {
		this.dtResult = dtResult;
	}

	public UserManaged() {
		super();

		service = new UserService();
	}

	public User getSelected() {
		return selected;
	}

	public void setSelected(User selected) {
		this.selected = selected;
	}

	public String getIdSearch() {
		return idSearch;
	}

	public void setIdSearch(String idSearch) {
		this.idSearch = idSearch;
	}

	public List<User> getResultSearch() {

		return resultSearch;
	}

	public String getNameSearch() {
		return nameSearch;
	}

	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}

	public void reset() {
		this.idSearch = null;		
		this.nameSearch = null;
		this.resultSearch = null;
		this.selected = null;

		dtResult.setFirst(0);
	}

	public void view(User user) {
		selected = user;
	}

	public void search() {

		User ctr = new User();
		ctr.setUserId(idSearch);
		ctr.setFirstName(nameSearch);
		

		resultSearch = service.search(ctr);

	}

	public void addAction() {
		selected = new User();

	}

	public boolean checkDupId(String id) {
		User item = new User();
		item.setUserId(id);
		if (service.search(item).size() == 0)
			return false;
		return true;
	}
	public void generateData(){
		for(int i=0;i<1000;i++){
			User row=new User();
			row.setUserId("UserId"+String.valueOf(i));
			row.setFirstName("John "+String.valueOf(i));
			row.setLastName("Doe "+String.valueOf(i));
			service.insert(row);
		}
	}
	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (selected.getId() != null)
			service.update(selected);
		else {
			if (checkDupId(selected.getUserId())) {
				RequestContext.getCurrentInstance().addCallbackParam("checkBusinessFail", true);
				context.addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Add Error", "Duplicate ID:"
						+ selected.getUserId()));
				return;
			}
			service.insert(selected);
		}
		context.addMessage("growl", new FacesMessage("Operation Success", "Save ID: " + selected.getUserId()));
		search();

	}

	public void delete() {
		int result = 0;
		result = service.delete(selected.getId());
		if (result != 0) {
			search();
			FacesContext.getCurrentInstance().addMessage("growl",
					new FacesMessage("Operation Success", "Delete ID: " + selected.getUserId()));
		} else {
			FacesContext.getCurrentInstance().addMessage("growl",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Delete Error", "Delete ID: " + selected.getUserId()));
		}

	}

}
