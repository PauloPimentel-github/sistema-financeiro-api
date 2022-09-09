package com.phpimentel.sistemafinanceiroapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.phpimentel.sistemafinanceiroapi.dtos.BankAccountDto;
import com.phpimentel.sistemafinanceiroapi.dtos.CustomerDto;
import com.phpimentel.sistemafinanceiroapi.enums.AccountType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "bank_accounts")
public class BankAccountModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name = "bank", nullable = false, length = 50)
    private String bank;

    @Column(name = "agency", nullable = false, length = 20)
    private String agency;

    @Column(name = "account", nullable = false, length = 25)
    private String account;

    @Column(name = "account_type", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "document", length = 20)
    private String document;

    @CreationTimestamp
    @Column(name="creation_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private OffsetDateTime creationDate;

    @UpdateTimestamp
    @Column(name="last_update_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private OffsetDateTime lastUpdateDate;

    public BankAccountDto convertBankAccountDto() {
        var bankAccountDto = new BankAccountDto();
        BeanUtils.copyProperties(this, bankAccountDto);
        return bankAccountDto;
    }
}
