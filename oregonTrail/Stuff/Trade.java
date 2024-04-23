package Stuff;

import java.util.Random;

public class Trade {

    private Inventory inventory = new Inventory();
    private static Random random = new Random();

    public String[] createTrade(){
        String tradeOutput[] = {"receive", "R_number", "give", "G_number"};
        String itemList[] = Inventory.itemNames;
        int number = random.nextInt(8);
        int number2 = random.nextInt(8);

        int randomNumber1, randomNumber2;

        while(number2 == number){
            number2 = random.nextInt(8);
        }

        tradeOutput[0] = itemList[number];
        tradeOutput[2] = itemList[number2];

        if(tradeOutput[0]==itemList[0]||tradeOutput[0]==itemList[2]||tradeOutput[0]==itemList[6]){
            randomNumber1 = random.nextInt(32) + 1;
        }
        else {
            randomNumber1 = random.nextInt(4) + 1;
        }

        if(tradeOutput[2]==itemList[0]||tradeOutput[2]==itemList[2]||tradeOutput[2]==itemList[6]){
            randomNumber2 = random.nextInt(32) + 1;
        }
        else {
            randomNumber2 = random.nextInt(4) + 1;
        }

        tradeOutput[1] = Integer.toString(randomNumber1);
        tradeOutput[3] = Integer.toString(randomNumber2);

        return tradeOutput;
    }

    public String acceptTrade(String tradeOutput[]){
        //String tradeOutput[] = {"receive", "R_number", "give", "G_number"};
        int itemOneCount = inventory.getItemCount(tradeOutput[0]);
        int itemTwoCount = inventory.getItemCount(tradeOutput[0]);

        if(Integer.parseInt(tradeOutput[3])>itemTwoCount){
            return "trade failed, not enough items";
        }

        inventory.addItem(tradeOutput[0], itemTwoCount);
        inventory.removeItem(tradeOutput[2], itemOneCount);
        return "Trade Success";
    }
}
