package com.ironhack.bankingsystem.DTO;

import com.ironhack.bankingsystem.classes.Money;
import lombok.Data;

@Data
public class TransferDTO {

    private Money transferAmount;
    private Long recipientAccountId;

    public TransferDTO(Money transferAmount, Long recipientAccountId) {
        this.transferAmount = transferAmount;
        this.recipientAccountId = recipientAccountId;
    }

    public Money getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Money transferAmount) {
        this.transferAmount = transferAmount;
    }

    public Long getRecipientAccountId() {
        return recipientAccountId;
    }

    public void setRecipientAccountId(Long recipientAccountId) {
        this.recipientAccountId = recipientAccountId;
    }
}
