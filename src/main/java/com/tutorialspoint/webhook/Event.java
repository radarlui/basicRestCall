package com.tutorialspoint.webhook;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Event
{
    private String action;

    private com.tutorialspoint.webhook.Object object;

    private String type;

    public String getAction ()
    {
        return action;
    }

    public void setAction (String action)
    {
        this.action = action;
    }

    public com.tutorialspoint.webhook.Object getObject ()
    {
        return object;
    }

    public void setObject (com.tutorialspoint.webhook.Object object)
    {
        this.object = object;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

	@Override
	public String toString() {
		return "Event [action=" + action + ", object=" + object + ", type="
				+ type + "]";
	}
}
			
			
