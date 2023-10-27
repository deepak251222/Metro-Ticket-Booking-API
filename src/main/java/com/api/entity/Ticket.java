package com.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="ticket_table")
public class Ticket {
    @Id
    private String ticketId;
    private String sourceStation;
    private String destinationStation;
    private LocalDateTime expirationTime;
    private int usagesLeft;
    private int price;
}
