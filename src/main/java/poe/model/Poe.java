package poe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class Poe {

    private String title;
    private LocalDate beginDate;
    private LocalDate endDate;
    private PoeType poeType;



    @Override
    public String toString() {
        return "POE : " +
               title + ", " +
                beginDate +
                " -> " + endDate +
                ", " + poeType
                ;
    }
}
