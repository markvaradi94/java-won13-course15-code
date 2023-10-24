package ro.fasttrackit.course15.homework;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@FieldNameConstants
public class Quote {
    private final int id;
    private final String author;
    private final String quote;
    private boolean favourite;
}
