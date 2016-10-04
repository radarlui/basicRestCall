package com.tutorialspoint.webhook;

public class Object
{
    private User user;

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

	@Override
	public String toString() {
		return "Object [user=" + user + "]";
	}
}
