package br.com.brasilprev.provajavabrasilprev.usecase.dto;

import java.time.LocalDate;

public class CustomerDto {

    private Long id;

    private String name;
    
    private LocalDate birthDate;

    private String address;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }   

}
