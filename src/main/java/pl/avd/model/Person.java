package pl.avd.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Person
{
    @Id
    private Long id;

    private String name;
    
    private Date created;
    
    public Person() {
    }

    public Person(long id, String name, Date created)
    {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    public String getName()
    {
        return name;
    }

    public Long getId()
    {
        return id;
    }
    
    public Date getCreated()
    {
      return created;
    }
    
    public void setCreated(Date created)
    {
      this.created = created;
    }
}
