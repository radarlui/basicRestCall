package com.tutorialspoint.model;

import java.util.ArrayList;
import java.util.List;


public class LongResponse {
	private List<RequestItem> listRequestItems = new ArrayList<RequestItem>();
	
	public LongResponse() {
		super();
	}

	public void addToList(RequestItem requestItem) {
		listRequestItems.add(requestItem);
		
	}

	public RequestItem [] getListRequestItems() {
		RequestItem[] requestItems = new RequestItem[listRequestItems.size()];
		requestItems = listRequestItems.toArray(requestItems);

		return requestItems;
	}

	public void setListRequestItems(List<RequestItem> listRequestItems) {
		this.listRequestItems = listRequestItems;
	}

	
}
