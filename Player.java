/*
 ・player型のクラスを作成。
 ・持ち金作成
 ・持ち金増やす関数作成
 */

public class Player {
    private int balance;

    public Player(int initialBalance) {
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int amount) {
        balance += amount;
    }
}
