import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class BasicAuthService implements AuthService {
    private final Set<Record> records;

    public BasicAuthService() {
        records = new HashSet<>();
        records.add(new Record( "Barboss", "l1", "p1"));
        records.add(new Record( "Kelvin", "l2", "p2"));
        records.add(new Record( "Nicky", "l3", "p3"));
        records.add(new Record( "Klaus", "l4", "p4"));
    }

    @Override
    public Record findRecord(String login, String password) {
        for (Record record : records) {
            if (record.getLogin().equals(login) && record.getPassword().equals(password)) {
                return record;
            }
        }
        return null;
    }
}
