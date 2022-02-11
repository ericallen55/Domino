package com.company.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//I didn't use the new records because I like builders
public class Coordinate {
    Integer x;
    Integer y;
}
