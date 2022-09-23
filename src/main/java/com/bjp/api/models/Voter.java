package com.bjp.api.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Voter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = IDENTITY, generator = "uuid2")
    private String voterId;


    private String voterIdNo;

    private String voterMobileNumber;


    private String voterDiscriptons;

    private Boolean isPartyMember;

    @NotBlank(message = "Voter should not be null or empty")
    private String voterName;
    @Min(value = 18, message = "Voter age should be greater than 18")
    private Integer voterAge;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date voterDob;
    @Email(message = "Please provide valid email")
    private String voterEmail;
    @Length(min = 10, message = "Please provide valid mobile number")
    private String voterMobile;
    @NotBlank(message = "Voter area should not be null or empty")
    private String voterArea;
    @NotBlank(message = "Voter blood group should not be null or empty")
    private String voterBloodGroup;
    @NotBlank(message = "Voter gender should not be null or empty")
    private String voterGender;
    @Lob
    private byte[] voterImage;
    @CreatedDate
    private Date createAt;
    @LastModifiedDate
    private Date lastModified;

}
