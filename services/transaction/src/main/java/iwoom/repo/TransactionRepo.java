package iwoom.repo;

import org.springframework.data.repository.CrudRepository;

import iwoom.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface TransactionRepo extends CrudRepository<Transaction, String> {

}