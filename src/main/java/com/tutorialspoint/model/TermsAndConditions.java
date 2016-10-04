package com.tutorialspoint.model;

public class TermsAndConditions {
	public enum TERMS_AND_CONDITIONS_STATUS{NOT_ACCEPTED, PENDING, DUPLICATE_OR_INVALID_EMAIL, ACCEPTED}
	
	private boolean accepted=false;
	//private String detailedTermsAndConditionsText="These are detailed Terms and Conditions curated by GSMA which need to be accepted to proceed";
	private String detailedTermsAndConditionsText="";
	private String acceptedUserEmail="";
	private TERMS_AND_CONDITIONS_STATUS statusMessage=TERMS_AND_CONDITIONS_STATUS.NOT_ACCEPTED;
	
	
	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public String getDetailedTermsAndConditionsText() {
		return detailedTermsAndConditionsText;
	}

	public void setDetailedTermsAndConditionsText(
			String detailedTermsAndConditionsText) {
		this.detailedTermsAndConditionsText = detailedTermsAndConditionsText;
	}

	public String getAcceptedUserEmail() {
		return acceptedUserEmail;
	}

	public void setAcceptedUserEmail(String acceptedUserEmail) {
		this.acceptedUserEmail = acceptedUserEmail;
	}

	public TERMS_AND_CONDITIONS_STATUS getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(TERMS_AND_CONDITIONS_STATUS statusMessage) {
		this.statusMessage = statusMessage;
	}

}
