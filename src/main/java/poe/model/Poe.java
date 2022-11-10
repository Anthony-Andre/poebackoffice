package poe.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Poe {

    private String title;
    private LocalDate beginDate;
    private LocalDate endDate;
    private PoeType poeType;


    @Builder.Default
    private List<Trainee> trainees = new ArrayList<>();

    @Override
    public String toString() {
        return "POE : " +
               title + ", " +
                beginDate +
                " -> " + endDate +
                ", " + poeType + ", Liste des stagiaires : "
                + trainees
                ;
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void addAllTrainees(Collection<? extends Trainee> otherTrainees){
        trainees.addAll(otherTrainees);
    }

    public void addAllTrainees(Trainee... otherTrainees){
//        for(Trainee trainee: otherTrainees){
//            trainees.add(trainee);
//        }
        Collections.addAll(trainees, otherTrainees);
    }

}
