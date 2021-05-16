package com.tangorabox.userstore.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Request for create or update an user
 */
@ApiModel(description = "Request for create or update an user")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-16T18:57:52.680333500+02:00[Europe/Paris]")
public class UserRequestDTO   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("birthdate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate birthdate;

  public UserRequestDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Size(min=3,max=256) 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserRequestDTO birthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  /**
   * Get birthdate
   * @return birthdate
  */
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserRequestDTO userRequest = (UserRequestDTO) o;
    return Objects.equals(this.name, userRequest.name) &&
        Objects.equals(this.birthdate, userRequest.birthdate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, birthdate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRequestDTO {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

