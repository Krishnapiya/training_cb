package com.imis.training_cb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.imis.training_cb.util.Status;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

	@Data
	@MappedSuperclass
	@EntityListeners(AuditingEntityListener.class)
	public abstract class AbstractEntity implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 3991306286865338290L;

		@CreatedBy
		@Column(name = "created_by")
		protected String createdBy;

		@CreatedDate
		@Column(name = "created_at")
		protected Timestamp createdAt;

		@LastModifiedBy
		@Column(name = "last_modified_by")
		protected String lastModifiedBy;

		@LastModifiedDate
		@Column(name = "last_modified_at")
		protected Timestamp lastModifiedAt;

		@Column(name = "status")
		protected Integer status = Status.ALLOWED;

		
	}

