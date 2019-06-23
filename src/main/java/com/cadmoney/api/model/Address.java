package com.cadmoney.api.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address 
{
	private String placePublic;
	private String addressNumber;
	private String complement;
	private String neighborhood;
	private String zipCode;
	private String city;
	private String state;
	
	public String getPlacePublic() 
	{
		return placePublic;
	}
	
	public void setPlacePublic(String placePublic) 
	{
		this.placePublic = placePublic;
	}
	
	public String getAddressNumber() 
	{
		return addressNumber;
	}
	
	public void setAddressNumber(String addressNumber) 
	{
		this.addressNumber = addressNumber;
	}
	
	public String getComplement() 
	{
		return complement;
	}
	
	public void setComplement(String complement)
	{
		this.complement = complement;
	}
	
	public String getNeighborhood() 
	{
		return neighborhood;
	}
	
	public void setNeighborhood(String neighborhood) 
	{
		this.neighborhood = neighborhood;
	}
	
	public String getZipCode() 
	{
		return zipCode;
	}
	
	public void setZipCode(String zipCode) 
	{
		this.zipCode = zipCode;
	}
	
	public String getCity() 
	{
		return city;
	}
	
	public void setCity(String city) 
	{
		this.city = city;
	}
	
	public String getState() 
	{
		return state;
	}
	
	public void setState(String state) 
	{
		this.state = state;
	}
	
}
