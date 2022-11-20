package com.jee.hello.modele;

public class User {

    private int idUser;
    private String login;
    private String password;
    private String email;
    
    
    public User() {
        this( 0, "john", "doe", "a.a@a.a" );
    }
    
    
    
    
    public User(int idUser, String login, String password, String email) {
		super();
		this.idUser = idUser;
		this.login = login;
		this.password = password;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdUser() {
        return idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }    
}