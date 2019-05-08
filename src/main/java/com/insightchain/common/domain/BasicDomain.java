package com.insightchain.common.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

//import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * the parent class of all the domain.
 * 
 * @author jianxunji
 *
 */
//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Data
@com.fasterxml.jackson.databind.annotation.JsonSerialize(include=com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_NULL)
public class BasicDomain implements Serializable, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6345452242993899863L;

	@Id
	@GeneratedValue
	protected Long uid;//the unique key in database

	protected Timestamp createdTime;

	protected Timestamp updatedTime;
	
	public BasicDomain() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !this.getClass().equals(obj.getClass())) {
			return false;
		}
		if (obj == this){
			return true;
		}
		if(this.getUid() == null && ((BasicDomain) obj).getUid() == null){
			return true;
		}else if(this.getUid() == null){
			return false;
		}
		return this.getUid().equals(((BasicDomain) obj).getUid());
	}

	/* 
	 * generate the hash code by id
	 */
	@Override
	public int hashCode() {
		if(this.getUid() == null){
			return Long.valueOf(0).hashCode();
		}
		return this.getUid().hashCode();
	}

}
