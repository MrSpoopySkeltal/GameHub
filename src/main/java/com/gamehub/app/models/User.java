package com.gamehub.app.models;

public class User {
    private int Id;
    private String Name;
    private String Email;
    private String Password;
    private boolean Admin;

    public int getId() { return Id; }
    public void setId(int Id) { this.Id = Id; }

    public String getName() { return Name; }
    public void setName(String Name) { this.Name = Name; }

    public String getEmail() { return Email; }
    public void setEmail(String Email) { this.Email = Email; }

    public String getPassword() { return Password; }
    public void setPassword(String Password) { this.Password = Password; }

    public boolean Admin() { return Admin; }
    public void setAdmin(boolean Admin) { this.Admin = Admin; }
}


