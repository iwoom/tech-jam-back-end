package iwoom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Accounts {
    private List<BankAccount> bankAccounts;
    private List<CreditAccount> creditAccounts;
}
