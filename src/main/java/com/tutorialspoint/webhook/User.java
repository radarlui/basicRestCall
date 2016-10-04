package com.tutorialspoint.webhook;

public class User
{
    private String id;

    private String first_name;

    private String username;

    private String updated_at;

    private String extra_fields;

    private String account_id;

    private String email;

    private String state;

    private String created_at;

    private String role;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getFirst_name ()
    {
        return first_name;
    }

    public void setFirst_name (String first_name)
    {
        this.first_name = first_name;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getExtra_fields ()
    {
        return extra_fields;
    }

    public void setExtra_fields (String extra_fields)
    {
        this.extra_fields = extra_fields;
    }

    public String getAccount_id ()
    {
        return account_id;
    }

    public void setAccount_id (String account_id)
    {
        this.account_id = account_id;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getRole ()
    {
        return role;
    }

    public void setRole (String role)
    {
        this.role = role;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", username="
				+ username + ", updated_at=" + updated_at + ", extra_fields="
				+ extra_fields + ", account_id=" + account_id + ", email="
				+ email + ", state=" + state + ", created_at=" + created_at
				+ ", role=" + role + "]";
	}
    
}
	
