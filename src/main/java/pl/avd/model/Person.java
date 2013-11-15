package pl.avd.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Person
{
    @Id
    private Long id;

    private String name;
    
    private String surname;
    
    private Date created;
    
    public Person() {
    }

    public Person(long id, String name, String surname, Date created)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.created = created;
    }

    public String getName()
    {
        return name;
    }
    
    public String getSurname()
    {
      return surname;
    }

    public Long getId()
    {
        return id;
    }
    
    public Date getCreated()
    {
      return created;
    }
}
