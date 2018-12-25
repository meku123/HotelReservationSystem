package com.project.hotelreservation.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.time.LocalDate;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Future

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datefrom;
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateto;
   @OneToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "guest_id")
    private Guest guest;
  @OneToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "room_id")
    private Room room;

	public Booking() {
	}

	public Booking(@Future LocalDate datefrom, @Future LocalDate dateto, Guest guest, Room room) {
		this.datefrom = datefrom;
		this.dateto = dateto;
		this.guest = guest;
		this.room = room;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDatefrom() {
		return datefrom;
	}

	public void setDatefrom(LocalDate datefrom) {
		this.datefrom = datefrom;
	}

	public LocalDate getDateto() {
		return dateto;
	}

	public void setDateto(LocalDate dateto) {
		this.dateto = dateto;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
}
