/*
 * Copyright 2024 Apollo Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.ctrip.framework.apollo.portal.entity.po;

import com.ctrip.framework.apollo.audit.annotation.ApolloAuditLogDataInfluenceTable;
import com.ctrip.framework.apollo.audit.annotation.ApolloAuditLogDataInfluenceTableField;
import com.ctrip.framework.apollo.common.entity.BaseEntity;

import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@Entity
@Table(name = "`ServerConfig`")
@SQLDelete(sql = "Update `ServerConfig` set IsDeleted = true, DeletedAt = ROUND(UNIX_TIMESTAMP(NOW(4))*1000) where Id = ?")
@Where(clause = "`IsDeleted` = false")
@ApolloAuditLogDataInfluenceTable(tableName = "ServerConfig")
public class ServerConfig extends BaseEntity {
  @NotBlank(message = "ServerConfig.Key cannot be blank")
  @Column(name = "`Key`", nullable = false)
  @ApolloAuditLogDataInfluenceTableField(fieldName = "Key")
  private String key;

  @NotBlank(message = "ServerConfig.Value cannot be blank")
  @Column(name = "`Value`", nullable = false)
  @ApolloAuditLogDataInfluenceTableField(fieldName = "Value")
  private String value;

  @Column(name = "`Comment`", nullable = false)
  private String comment;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return toStringHelper().add("key", key).add("value", value).add("comment", comment).toString();
  }
}
