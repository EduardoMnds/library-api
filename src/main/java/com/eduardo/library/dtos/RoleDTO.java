package com.eduardo.library.dtos;

import com.eduardo.library.enums.Status;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleDTO {

    @NotNull
    @Size(min = 1, max = 50)
    private Status statusUser;

}
