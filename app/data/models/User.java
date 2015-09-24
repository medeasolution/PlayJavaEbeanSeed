package data.models;

import javax.persistence.*;

/**
 * Created by eric on 9/23/15.
 */
@Entity
@Table
public class User extends BaseModel{

    @Id
    @Column
    public Long id;

    @Column
    public String username;

    @Column
    private String password;

    public Boolean checkPassword(String passToCheck){
        return (this.password.equals(passToCheck));
    }

    @Override
    public Long getId() {
        return this.id;
    }
}
