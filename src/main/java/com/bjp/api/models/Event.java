package com.bjp.api.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = IDENTITY, generator = "uuid2")
    @NotBlank(message = "Event id should not be null or empty")
    private String eventId;
    @NotBlank(message = "Event organizer should not be null or empty")
    private String eventOrganizer;
    @NotBlank(message = "Event location should not be null or empty")
    private String eventLocation;
    @NotBlank(message = "Event contact number should not be null or empty")
    private String eventContactNumber;
    @NotBlank(message = "Event date should not be null or empty")
    private String eventDate;
    @NotBlank(message = "Event subject should not be null or empty")
    private String eventSubject;
    private String eventDescription;
    @NotBlank(message = "Event guest should not be null or empty")
    private String guests;
    @CreatedDate
    private Date createAt;
    @LastModifiedDate
    private Date lastModified;
}
