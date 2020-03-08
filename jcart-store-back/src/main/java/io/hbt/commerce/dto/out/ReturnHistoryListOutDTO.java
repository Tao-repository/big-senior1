package io.hbt.commerce.dto.out;

import java.util.Date;

public class ReturnHistoryListOutDTO {

    private Long timeTamp;
    private Byte returnStatus;
    private String comment;

    public Long getTimeTamp() {
        return timeTamp;
    }

    public void setTimeTamp(Long timeTamp) {
        this.timeTamp = timeTamp;
    }

    public Byte getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Byte returnStatus) {
        this.returnStatus = returnStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
