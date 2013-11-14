package org.datanucleus.test;

public class PersonDTO {

  private Long id;
  private String name;
  private Boolean createdInPast;

  public PersonDTO()
  {
  }
  
  public PersonDTO(Long id, String name, Boolean createdInPast)
  {
    this.id = id;
    this.name = name;
    this.createdInPast = createdInPast;
  }
  
  public Long getId()
  {
    return id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public Boolean getCreatedInPast()
  {
    return createdInPast;
  }
  
  public void setCreatedInPast(Boolean createdInPast)
  {
    this.createdInPast = createdInPast;
  }

  @Override
  public String toString()
  {
    return String.format("PersonDTO [id=%s, name=%s, hasName=%s, createdInPast=%s]", id, name, createdInPast);
  }
}
