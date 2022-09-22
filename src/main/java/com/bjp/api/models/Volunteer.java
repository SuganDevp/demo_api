package com.bjp.api.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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
public class Volunteer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = IDENTITY, generator = "uuid2")
    private String volunteerId;
    @NotBlank(message = "Volunteer name should not be null or empty")
    private String volunteerName;
    @Email(message = "Please provide valid email")
    @NotBlank(message = "Volunteer email should not be null or empty")
    private String volunteerEmail;
    private String volunteerAddress;
    @NotBlank(message = "Volunteer phone number should not be null or empty")
    private String volunteerPhone;
    @NotBlank(message = "Volunteer area should not be null or empty")
    private String volunteerArea;
    @NotBlank(message = "Volunteer profile should not be null or empty")
    private String volunteerProfile;
    @Lob
    private byte[] volunteerImage;
    @CreatedDate
    private Date createAt;
    @LastModifiedDate
    private Date lastModified;
}
