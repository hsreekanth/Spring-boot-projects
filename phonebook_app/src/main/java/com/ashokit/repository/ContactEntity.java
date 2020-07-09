package com.ashokit.repository;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name="contact_dtls")
public class ContactEntity {
@Id
@Column(name="contact_id")
@SequenceGenerator(
		name="cid_seq_gen",
		sequenceName="contact_id_seq",
		allocationSize=1
		)
@GeneratedValue(generator="cid_seq_gen",
                  strategy=GenerationType.SEQUENCE)
private Integer contactId;
@Column(name="contact_name")
private String contactName;
@Column(name="contact_email")
private String contactEmail;
@Column(name="contact_number")
private Long phoneNumber;
@CreationTimestamp
@Temporal(TemporalType.DATE)
@Column(name="created_date",updatable=false)
private Date createdDate;
@UpdateTimestamp
@Temporal(TemporalType.DATE)
@Column(name="updated_date", insertable=false)
private Date updatedDate;


public Integer getContactId() {
	return contactId;
}
public void setContactId(Integer contactId) {
	this.contactId = contactId;
}
public String getContactName() {
	return contactName;
}
public void setContactName(String contactName) {
	this.contactName = contactName;
}
public String getContactEmail() {
	return contactEmail;
}
public void setContactEmail(String contactEmail) {
	this.contactEmail = contactEmail;
}
public Long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(Long phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public Date getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}
public Date getUpdatedDate() {
	return updatedDate;
}
public void setUpdatedDate(Date updatedDate) {
	this.updatedDate = updatedDate;
}
@Override
public String toString() {
	return "ContactEntity [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail=" + contactEmail
			+ ", phoneNumber=" + phoneNumber + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
}



}
