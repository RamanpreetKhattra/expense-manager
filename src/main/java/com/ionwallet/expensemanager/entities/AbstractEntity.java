package com.ionwallet.expensemanager.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.util.StringUtils;

@Entity
@MappedSuperclass
public class AbstractEntity {

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TS")
	protected Date createdTime;

	@CreatedBy
	@Column(name = "CREATED_BY")
	protected String createdBy;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_TS")
	protected Date updatedTime;

	@LastModifiedBy
	@Column(name = "UPDATED_BY")
	protected String updatedBy;

	@Version
	@Column(name = "VERSION", nullable = false)
	protected Long version;

	@PrePersist
	public void beforeCreate() {
		String authenticatedUser = "2";
		if (null != authenticatedUser) {
			this.createdBy = authenticatedUser;
		} else if (StringUtils.isEmpty(this.createdBy)) {
			this.createdBy = "1";
		}
		this.createdTime = new Date();
		this.updatedBy = null;
		this.updatedTime = null;
		}

	@PreUpdate
	public void beforeUpdate() {
		String authenticatedUser = "2";
		if(null!=authenticatedUser){
				this.updatedBy = authenticatedUser;
			}
		else if (StringUtils.isEmpty(this.updatedBy)) {
			this.updatedBy = "1";
		}
		this.updatedTime = new Date();
	}

	public Date getCreatedTs() {
		return createdTime;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTime = createdTs;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedTs() {
		return updatedTime;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTime = updatedTs;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Long getVersion() {
		return version;
	}

	/**
	 * Performs optimistic locking
	 *
	 * @param version
	 */
	public void setVersion(Long version) {
		this.version = version;
	}
	
}
