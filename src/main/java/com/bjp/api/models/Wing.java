package com.bjp.api.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Wing implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = IDENTITY, generator = "uuid2")
    private String wingId;
    private String wingName;
    private String wingArea;
    private String wingMobileNumber;
    private String wingEmail;
    private String wingAddress;
    @ElementCollection
    @CollectionTable(name = "user_wingTeamMembers", joinColumns = @JoinColumn(name = "wing_id"))
    @Column(name = "wingTeamMembers")
    private Set<String> wingTeamMembers;
    private String wingTask;
    @CreatedDate
    private Date createAt;
    @LastModifiedDate
    private Date lastModified;
}
