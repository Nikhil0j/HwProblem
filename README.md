Create a map to store the net balance of each person.
For every transaction [debtor, creditor, amount]:
Subtract amount from the debtor's balance.
Add amount to the creditor's balance.
After processing all transactions:
A negative balance means the person must pay money.
A positive balance means the person must receive money.
A zero balance means the person is already settled.
Divide all people into two groups:
Debtors (negative balance)
Creditors (positive balance)
Use two pointers:
One pointer for the current debtor.
One pointer for the current creditor.
At each step:
Transfer the minimum of:
Amount owed by the debtor.
Amount to be received by the creditor.
Record this optimized transaction.
Reduce the corresponding balances.
If a debtor's balance becomes zero, move to the next debtor.
If a creditor's balance becomes zero, move to the next creditor.
Continue until all debtors and creditors are settled.
The recorded transactions form the optimized cash flow where all balances become zero and unnecessary intermediate transfers are removed.
Example

If:

A = -700
B = -300
C = +500
D = +500

Then:

A → C : 500
A → D : 200
B → D : 300

After these transactions, every person's balance becomes zero and all debts are settled.

Time Complexity
Computing net balances: O(M), where M is the number of transactions.
Settling debtors and creditors: O(N), where N is the number of people.

Overall Time Complexity: O(M + N)
