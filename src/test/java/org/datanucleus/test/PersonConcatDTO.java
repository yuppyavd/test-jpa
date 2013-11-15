package org.datanucleus.test;

public class PersonConcatDTO {

  private Long id;
  private String fullname;

  public PersonConcatDTO()
  {
  }
  
  public PersonConcatDTO(Long id, String fullname)
  {
    this.id = id;
    this.fullname = fullname;
  }
  
  public Long getId()
  {
    return id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
  
  public String getFullname()
  {
    return fullname;
  }
  
  public void setFullname(String fullname)
  {
    this.fullname = fullname;
  }

  @Override
  public String toString()
  {
    return String.format("PersonConcatDTO [id=%s, fullname=%s]", id, fullname);
  }
}
