package com.aggrey.api.mpp.objects;

public class Publisher {

	public String filter, sort, fields;
	public int page, size;

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/*
	 * public Publisher(String filter, int page, int size, String sort, String
	 * fields) { super(); this.filter = filter; this.sort = sort; this.fields =
	 * fields; this.page = page; this.size = size; }
	 */

	public String getFilter() {
		return filter;
	}

	public String getSort() {
		return sort;
	}

	public String getFields() {
		return fields;
	}

	public int getPage() {
		return page;
	}

	public int getSize() {
		return size;
	}

	/*
	 * public static void main () { Publisher publisher = new Publisher ("", 0, 0,
	 * "", "");
	 * 
	 * }
	 */
}
