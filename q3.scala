class Account(var balance: Double) {

  // Method to deposit money into the account
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $$${amount}. New balance: $$${balance}")
    } else {
      println("Deposit amount must be positive.")
    }
  }

  // Method to withdraw money from the account
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $$${amount}. New balance: $$${balance}")
    } else if (amount > balance) {
      println(s"Insufficient funds to withdraw $$${amount}. Current balance: $$${balance}")
    } else {
      println("Withdrawal amount must be positive.")
    }
  }

  // Method to transfer money from this account to another account
  def transfer(amount: Double, target: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      target.deposit(amount)
      println(s"Transferred $$${amount} to target account.")
    } else {
      println("Insufficient balance or invalid transfer amount.")
    }
  }

  override def toString: String = f"Account balance: $$${balance}%.2f"
}

object AccountExample extends App {

  // Creating two accounts
  val account1 = new Account(1000.0)
  val account2 = new Account(500.0)

  // Display initial balances
  println(s"Initial Balance - Account 1: $account1")
  println(s"Initial Balance - Account 2: $account2")

  // Deposit money into account 1
  account1.deposit(200.0)

  // Withdraw money from account 2
  account2.withdraw(100.0)

  // Transfer money from account 1 to account 2
  account1.transfer(300.0, account2)

  // Display final balances after operations
  println(s"Final Balance - Account 1: $account1")
  println(s"Final Balance - Account 2: $account2")
}
