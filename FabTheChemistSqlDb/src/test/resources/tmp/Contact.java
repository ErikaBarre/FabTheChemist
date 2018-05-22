package tmp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Contact")
public class Contact {

    @Id
    private Integer id;

    private Name name;

    private String notes;

    private URL website;

    private boolean starred;

    //Getters and setters are omitted for brevity
}
