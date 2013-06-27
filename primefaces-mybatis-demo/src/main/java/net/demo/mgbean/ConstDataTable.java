package net.demo.mgbean;

import java.io.Serializable;

public class ConstDataTable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2096519122620641219L;
	private String paginatorTemplate="{CurrentPageReport}  {FirstPageLink} {PreviousPageLink} {PageLinks} {NextPageLink} {LastPageLink} {RowsPerPageDropdown}";
	private String pageRows="50";
	private String rowsPerPageTemplate="50,100,200";
	private String scrollHeight="380";
	public ConstDataTable() {
		super();
	}
	private String style="width: 700";
	public String getPaginatorTemplate() {
		return paginatorTemplate;
	}
	public void setPaginatorTemplate(String paginatorTemplate) {
		this.paginatorTemplate = paginatorTemplate;
	}
	public String getPageRows() {
		return pageRows;
	}
	public void setPageRows(String pageRows) {
		this.pageRows = pageRows;
	}
	public String getRowsPerPageTemplate() {
		return rowsPerPageTemplate;
	}
	public void setRowsPerPageTemplate(String rowsPerPageTemplate) {
		this.rowsPerPageTemplate = rowsPerPageTemplate;
	}
	public String getScrollHeight() {
		return scrollHeight;
	}
	public void setScrollHeight(String scrollHeight) {
		this.scrollHeight = scrollHeight;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
}
