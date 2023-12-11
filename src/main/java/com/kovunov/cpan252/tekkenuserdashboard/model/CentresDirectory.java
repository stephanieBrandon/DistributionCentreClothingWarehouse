package com.kovunov.cpan252.tekkenuserdashboard.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CentresDirectory {
    private List<DistributionCentre> centres;
     public CentresDirectory(){this.centres = new ArrayList<>();
     }
     //-sb add same logic but for delete for 4. requirements Monday
    //change to items (not adding removing centres adding removing items from centers)
     public void add(DistributionCentre distributionCentre){ this.centres.add(distributionCentre);}
}
