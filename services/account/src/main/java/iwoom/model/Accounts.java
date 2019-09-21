package iwoom.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
public class Accounts {
    private List<Account> accounts;
}
