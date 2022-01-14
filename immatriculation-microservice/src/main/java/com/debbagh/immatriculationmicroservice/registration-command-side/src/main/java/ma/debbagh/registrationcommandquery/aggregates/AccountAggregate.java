package ma.debbagh.exam.registration.commands.aggregates;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;
//@Entity
@Aggregate
@Slf4j
public class AccountAggregate {
    @AggregateIdentifier
    //@Id
    private String accountId;
    private BigDecimal balance;
    private String currency;
    private String status;

    public AccountAggregate() {
    }
/*
    @CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand) {
        log.info("CreateAccountCommand Received");
        AggregateLifecycle.apply(
                new VehicleCreatedEvent(
                        createAccountCommand.getId(),
                        createAccountCommand.getBalance(),
                        createAccountCommand.getCurrency(),
                        AccountStatus.CREATED
                        )
        );
    }
    @EventSourcingHandler
    public void on(VehicleCreatedEvent vehicleCreatedEvent){
        log.info("AccountCreatedEvent Occured");
        this.accountId= vehicleCreatedEvent.getId();
        this.balance= vehicleCreatedEvent.getBalance();
        this.currency= vehicleCreatedEvent.getCurrency();
        this.status=String.valueOf(vehicleCreatedEvent.getStatus());
        AggregateLifecycle.apply(new AccountActivatedEvent(this.accountId,AccountStatus.ACTIVATED));
    }

    @EventSourcingHandler
    public void on(AccountActivatedEvent accountActivatedEvent){
        log.info("AccountActivatedEvent Occured");
        this.status=String.valueOf(accountActivatedEvent.getStatus());
    }

    @CommandHandler
    public void on(DebitAccountCommand debitAccountCommand){
        if((this.balance.doubleValue()>0)&&(this.balance.subtract(debitAccountCommand.getAmount()).doubleValue()<0)){
            throw new InsufficientBalanceException("Insufficient Balance=>"+this.balance.doubleValue());
        } else
        AggregateLifecycle.apply(
                new AccountDebitedEvent(
                        debitAccountCommand.getId(),
                        debitAccountCommand.getAmount(),
                        debitAccountCommand.getCurrency()
                )
        );
    }

    @EventSourcingHandler
    public void on(AccountDebitedEvent accountDebitedEvent){
        log.info("AccountDebitedEvent Occured");
        this.balance=this.balance.subtract(accountDebitedEvent.getAmount());
        System.out.println(this.balance);
    }
    @EventSourcingHandler
    public void on(AccountHeldEvent accountHeldEvent){
        this.status=String.valueOf(accountHeldEvent.getStatus());
    }
    @CommandHandler
    public void on(CreditAccountCommand creditAccountCommand){
        AggregateLifecycle.apply(new AccountCreditedEvent(
           creditAccountCommand.getId(),
           creditAccountCommand.getAmount(),
           creditAccountCommand.getCurrency()
        ));
    }
    @EventSourcingHandler
    public void on(AccountCreditedEvent accountCreditedEvent){
        this.balance=this.balance.add(accountCreditedEvent.getAmount());
        log.info("==================");
        log.info(this.balance.toString());
        log.info("==================");
    }*/
}
