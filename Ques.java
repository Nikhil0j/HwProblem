import java.util.*;

public class Ques {

    static class PersonBalance {
        String name;
        long amount;

        PersonBalance(String name, long amount) {
            this.name = name;
            this.amount = amount;
        }
    }

    public static List<List<String>> minimizeCashFlow(
            List<List<String>> transactions) {

        Map<String, Long> balance = new HashMap<>();

        for (List<String> t : transactions) {

            String from = t.get(0);
            String to = t.get(1);
            long amount = Long.parseLong(t.get(2));

            balance.put(from,
                    balance.getOrDefault(from, 0L) - amount);

            balance.put(to,
                    balance.getOrDefault(to, 0L) + amount);
        }

        List<PersonBalance> debtors = new ArrayList<>();
        List<PersonBalance> creditors = new ArrayList<>();

        for (Map.Entry<String, Long> entry : balance.entrySet()) {

            long amt = entry.getValue();

            if (amt < 0) {
                debtors.add(
                        new PersonBalance(entry.getKey(), -amt));
            } else if (amt > 0) {
                creditors.add(
                        new PersonBalance(entry.getKey(), amt));
            }
        }

        List<List<String>> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < debtors.size() && j < creditors.size()) {

            PersonBalance debtor = debtors.get(i);
            PersonBalance creditor = creditors.get(j);

            long settled =
                    Math.min(debtor.amount, creditor.amount);

            result.add(Arrays.asList(
                    debtor.name,
                    creditor.name,
                    String.valueOf(settled)
            ));

            debtor.amount -= settled;
            creditor.amount -= settled;

            if (debtor.amount == 0) {
                i++;
            }

            if (creditor.amount == 0) {
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<List<String>> transactions = new ArrayList<>();

        transactions.add(
                Arrays.asList("Tom", "Jerry", "1000"));

        transactions.add(
                Arrays.asList("Jerry", "Spike", "1000"));

        transactions.add(
                Arrays.asList("Spike", "Tom", "500"));

        List<List<String>> ans =
                minimizeCashFlow(transactions);

        for (List<String> t : ans) {
            System.out.println(
                    t.get(0) + " pays " +
                    t.get(1) + " " +
                    t.get(2));
        }
    }
}