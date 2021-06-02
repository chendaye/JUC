package top.chendaye666.pattern.structural.bridge;

/**
 * Created by geely
 */
public abstract class Bank {
    protected Account account;
    public Bank(Account account){
        this.account = account;
    }
    abstract Account openAccount();

}
