package com.ashokit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.models.Contact;
import com.ashokit.repository.ContactDtlsRepository;
import com.ashokit.repository.ContactEntity;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDtlsRepository contactRepo;
	
	@Override
	public boolean save(Contact contact) {
		ContactEntity entity=new ContactEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactEntity contactEntity = contactRepo.save(entity);
		return contactEntity.getContactId()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {
          List<ContactEntity> entities = contactRepo.findAll();
          return entities.stream().map(entity->{
        	  Contact contact=new Contact();
        	  BeanUtils.copyProperties(entity, contact);
        	  return contact;
          }).collect(Collectors.toList());
		
	}

	@Override
	public Contact getContactById(Integer contactId) {
		ContactEntity entity = contactRepo.findById(contactId).get();
		if(entity.getContactId()!=null) {
			Contact c=new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		
		return null;
	}

	@Override
	public boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContact(Integer contactId) {
		if(contactId!=null) {
		contactRepo.deleteById(contactId);
		return true;
		}
		return false;
	}

}
