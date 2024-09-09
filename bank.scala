class Account(var balance: Double) {
  def deposit(amount: Double): Unit = balance += amount
  def withdraw(amount: Double): Unit = balance -= amount
  override def toString: String = f"Account balance: $$${balance}%.2f"
}

class Bank(val accounts: List[Account]) {
  
  // 4.1 List of Accounts with negative balances
  def accountsWithNegativeBalances: List[Account] = {
    accounts.filter(_.balance < 0)
  }

  // 4.2 Calculate the sum of all account balances
  def totalBalance: Double = {
    accounts.map(_.balance).sum
  }

  // 4.3 Calculate the final balances after applying interest
  def applyInterest(): Unit = {
    accounts.foreach { account =>
      if (account.balance > 0) {
        account.deposit(account.balance * 0.05)  // Apply 5% interest to positive balance
      } else {
        account.withdraw(account.balance.abs * 0.1)  // Apply 10% overdraft interest to negative balance
      }
    }
  }
}


object BankExample extends App {
  
  // Create some accounts
  val acc1 = new Account(100.0)   // Positive balance
  val acc2 = new Account(-50.0)   // Negative balance
  val acc3 = new Account(200.0)   // Positive balance
  val acc4 = new Account(-150.0)  // Negative balance

  // Create a bank with these accounts
  val bank = new Bank(List(acc1, acc2, acc3, acc4))

  // 4.1 List of Accounts with negative balances
  val negativeAccounts = bank.accountsWithNegativeBalances
  println("Accounts with negative balances:")
  negativeAccounts.foreach(acc => println(acc))  // Should list acc2 and acc4

  // 4.2 Calculate the sum of all account balances
  val total = bank.totalBalance
  println(s"Total sum of balances: $$${total}")  // Output: Total sum of balances

  // 4.3 Apply interest to all accounts
  println("Applying interest...")
  bank.applyInterest()

  // Print the final balances after interest
  println("Final balances after interest:")
  bank.accounts.foreach(acc => println(acc))
}
