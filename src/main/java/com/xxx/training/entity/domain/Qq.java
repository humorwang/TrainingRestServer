/**  
 * @Title: Qq.java
 * @Package com.xxx.training.entity.domain
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xxx
 * @date 2016-5-15 下午2:06:12
 * @version V1.0  
 */
package com.xxx.training.entity.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.xxx.training.core.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * 类描述： 类名称：com.xxx.training.entity.domain.Qq
 * 创建人：xxx
 * 创建时间：2016-5-15下午2:06:12
 */
@Entity
@Table(name = "qq")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@XmlRootElement(name="qq")
@JsonRootName("oicq")
public class Qq extends BaseEntity {

	@NotNull(message = "{qq.qq.null}")
	@Column(name="qq")
	@JsonProperty("qqNo")
	private Integer qq;
	
	public Qq(){}

	/**
	 * @return the qq
	 */
	@XmlElement(name="qqno")
	public Integer getQq() {
		return qq;
	}

	/**
	 * @param qq
	 *            the qq to set
	 */
	public void setQq(Integer qq) {
		this.qq = qq;
	}


}
