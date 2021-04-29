package com.example.project.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import com.example.project.model.Person;
import com.example.project.service.PersonService;

@Named
@RequestScoped
@FacesConfig
public class Bean {

	private String text;
	private String password;
	private String message;
	private String hidden;

	public void submit() {
		System.out.println("form has been submitted!");
		System.out.println("text: " + text);
		System.out.println("password: " + password);
		System.out.println("message: " + message);
		System.out.println("hidden: " + hidden);
	}

	private Part file;

	public void fsubmit() throws IOException {
		System.out.println("Form has been submitted!");
		System.out.println("file: " + file);
		if (file != null) {
			System.out.println("name: " + file.getSubmittedFileName());
			System.out.println("type: " + file.getContentType());
			System.out.println("size: " + file.getSize());
			InputStream inputStream = file.getInputStream();
			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
					.getContext();
			File outputFile = new File(servletContext.getRealPath("") + File.separator + "WEB-INF" + File.separator
					+ file.getSubmittedFileName());
			OutputStream outputStream = new FileOutputStream(outputFile);
			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			if (outputStream != null) {
				outputStream.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	private boolean checked;
	private String oneMenu;
	private String oneRadio;
	private String oneRadio1;
	private List<String> manyListbox;
	private List<String> manyCheckbox;
	private List<String> manyCheckboxb;
	private List<String> availableItems;
	private Map<String, Boolean> manyCheckboxMap = new LinkedHashMap<>();
	private String selectedItem;
	
	private Map<String, String> availableItems2;

	@PostConstruct
	public void init() {
		availableItems = Arrays.asList("one", "two", "three");
		availableItems2 = new LinkedHashMap<>();
		availableItems2.put("First item", "one");
		availableItems2.put("Second item", "two");
		availableItems2.put("Third item", "three");
	}

	public void collectCheckedValues() {
		manyCheckboxb = manyCheckboxMap.entrySet().stream().filter(e -> e.getValue()).map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}

	public void ssubmit() {
		System.out.println("Form has been submitted!");
		System.out.println("checked: " + checked);
		System.out.println("oneMenu: " + oneMenu);
		System.out.println("oneRadio: " + oneRadio);
		System.out.println("manyListbox: " + manyListbox);
		System.out.println("manyCheckbox: " + manyCheckbox);
		System.out.println("manyCheckboxb: " + manyCheckboxb);
		System.out.println("oneRadio: " + oneRadio1);
		System.out.println("selectedItem: " + selectedItem);
	}
	
	public void clsubmit() {
		System.out.println("command link submitted");
	}
	
	@Inject @ManagedProperty("#{param.id}")
	private Integer id;
	
	public void cbsubmit() {
		System.out.println("Submitted ID: " + id);
	}
	
	public void cbsubmit(int id) {
		System.out.println("Submitted ID: " + id);
	}
	
	@Inject @ManagedProperty("#{param.jsid}")
	private Integer jsid;
	
	@Inject @ManagedProperty("#{param.name}")
	private String name;
	
	@Inject @ManagedProperty("#{param.email}")
	private String email;
	
	public void ibsubmit() {
		System.out.println("Submitted ID: " + jsid);
		System.out.println("Submitted name: " + name);
		System.out.println("Submitted email: " + email);
	}
	
	private List<Person> lazyPersons;
	
	@Inject
	private PersonService personService;
	
	public void loadLazyPersons() {
		lazyPersons = personService.getAll();
	}
	
	public List<Person> getLazyPersons() {
		return lazyPersons;
	}
	
	public void delete() {
		System.out.println("pressed delete button");
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getOneMenu() {
		return oneMenu;
	}

	public void setOneMenu(String oneMenu) {
		this.oneMenu = oneMenu;
	}

	public String getOneRadio() {
		return oneRadio;
	}

	public void setOneRadio(String oneRadio) {
		this.oneRadio = oneRadio;
	}

	public List<String> getManyListbox() {
		return manyListbox;
	}

	public void setManyListbox(List<String> manyListbox) {
		this.manyListbox = manyListbox;
	}

	public List<String> getManyCheckbox() {
		return manyCheckbox;
	}

	public void setManyCheckbox(List<String> manyCheckbox) {
		this.manyCheckbox = manyCheckbox;
	}

	public List<String> getAvailableItems() {
		return availableItems;
	}

	public List<String> getManyCheckboxb() {
		return manyCheckboxb;
	}

	public void setManyCheckboxb(List<String> manyCheckboxb) {
		this.manyCheckboxb = manyCheckboxb;
	}

	public Map<String, Boolean> getManyCheckboxMap() {
		return manyCheckboxMap;
	}

	public String getOneRadio1() {
		return oneRadio1;
	}

	public void setOneRadio1(String oneRadio1) {
		this.oneRadio1 = oneRadio1;
	}

	public Map<String, String> getAvailableItems2() {
		return availableItems2;
	}

	public String getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}