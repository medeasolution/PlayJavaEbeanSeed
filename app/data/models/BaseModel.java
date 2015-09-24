package data.models;

import com.avaje.ebean.Model;

import javax.persistence.MappedSuperclass;

/**
 * Created by eric on 9/23/15.
 */

@MappedSuperclass
public abstract class BaseModel extends Model{
    public abstract Long getId();
}
