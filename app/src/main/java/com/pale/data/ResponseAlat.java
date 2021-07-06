package com.pale.data;

import java.util.List;

public class ResponseAlat{
	private List<Alat> data;

	public void setData(List<Alat> data){
		this.data = data;
	}

	public List<Alat> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"ResponseAlat{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}