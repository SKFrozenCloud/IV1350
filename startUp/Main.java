package se.kth.iv1350.startUp;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.AccountingSystem;
import se.kth.iv1350.integration.InventorySystem;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.view.View;

public class Main {
    public static void main(String[] args) {
        AccountingSystem accountSys = new AccountingSystem();
        InventorySystem inventorySys = new InventorySystem();
        Printer printer = new Printer();
        Controller contr = new Controller(accountSys, inventorySys, printer);
        View view = new View(contr);
        view.runFakeExecution();
    }
}
