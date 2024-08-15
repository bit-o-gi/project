package bit.dday.dto;

import java.time.LocalDate;

public class CoupleDdayDto {
    private String partner1;
    private String partner2;
    private LocalDate ddayDate;

    // Getters and Setters
    public String getPartner1() {
        return partner1;
    }

    public void setPartner1(String partner1) {
        this.partner1 = partner1;
    }

    public String getPartner2() {
        return partner2;
    }

    public void setPartner2(String partner2) {
        this.partner2 = partner2;
    }

    public LocalDate getDdayDate() {
        return ddayDate;
    }

    public void setDdayDate(LocalDate ddayDate) {
        this.ddayDate = ddayDate;
    }
}

