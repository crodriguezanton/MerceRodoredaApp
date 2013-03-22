package com.mercerodoreda.app;

public class Usuari {

	int _id;
	String _name;
	String _surname1;
	String _surname2;
	String _email;
	String _password;
	String _emailpassword = _email + ":" + _password;  //utilitzat a LoginActivity.java
	String _type;
	
	public Usuari() {
		
	}
	
	public Usuari(int id, String name, String surname1, String surname2, String email, String password, String type){
		this._id = id;
		this._name = name;
		this._surname1 = surname1;
		this._surname2 = surname2;
		this._email = email;
		this._password = password;
		this._type = type;
	}
	
	public int getID(){
		return this._id;
	}
	
	public void setID(int id){
		this._id = id;
	}
	
	public String getName(){
		return this._name;
	}
	
	public void setName(String name){
		this._name = name;
	}
	
	public String getSurname1(){
		return this._surname1;
	}
	
	public void setSurname1(String surname1){
		this._surname1 = surname1;
	}
	
	public String getSurname2(){
		return this._surname2;
	}
	
	public void setSurname2(String surname2){
		this._surname2 = surname2;
	}
	
	public String getEmail(){
		return this._email;
	}
	
	public void setEmail(String email){
		this._email = email;
	}
	
	public String getPassword(){
		return this._password;
	}
	
	public void setPassword(String password){
		this._password = password;
	}
	public String getEmailPassword(){
		return this._emailpassword;
	}
	
	public String getType(){
		return this._type;
	}
	
	public void setType(String type){
		this._type = type;
	}
}
