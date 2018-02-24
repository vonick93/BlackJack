package com.example.android.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.concurrent.ThreadLocalRandom;

import com.example.android.blackjack.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayPlayerOneMoney(player1money);
        displayPlayerTwoMoney(player2money);
    }

    /**
     * Displays the player 1 information.
     */

    int player1money = 100;
    int player1bet = 0;
    int player1hand = 0;

    public void displayPlayerOneMoney(int money)
    {
        TextView moneyView = (TextView) findViewById(R.id.player_one_money);
        moneyView.setText(String.valueOf(money));
    }
    public void displayPlayerOneBet(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_one_bet);
        scoreView.setText(String.valueOf(score));
    }

    public void displayPlayerOneHand(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_one_hand);
        scoreView.setText(String.valueOf(score));
    }

    public void decrease1(View view)
    {
        player1bet = player1bet-1;
        displayPlayerOneBet(player1bet);
    }

    public void increase1(View view)
    {
        player1bet = player1bet+1;
        displayPlayerOneBet(player1bet);
    }

    public void playerOneHit(View view)
    {
        if (player1hand < 21 && player1hand > 1)
        {
            player1hand = player1hand + ThreadLocalRandom.current().nextInt(1, 10 + 1);
            displayPlayerOneHand(player1hand);
        }
        else
        {
            displayPlayerOneHand(player1hand);

        }
    }



    /**
     * Displays the player 2 information.
     */

    int player2money = 100;
    int player2bet = 0;
    int player2hand = 0;

    public void displayPlayerTwoMoney(int money)
    {
        TextView moneyView = (TextView) findViewById(R.id.player_two_money);
        moneyView.setText(String.valueOf(money));
    }

    public void displayPlayerTwoBet(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_two_bet);
        scoreView.setText(String.valueOf(score));
    }

    public void displayPlayerTwoHand(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_two_hand);
        scoreView.setText(String.valueOf(score));
    }

    public void decrease2(View view)
    {
        player2bet = player2bet-1;
        displayPlayerTwoBet(player2bet);
    }

    public void increase2(View view)
    {
        player2bet = player2bet+1;
        displayPlayerTwoBet(player2bet);
    }

    public void playerTwoHit(View view)
    {
        if (player2hand < 21 && player2hand > 1)
        {
            player2hand = player2hand + ThreadLocalRandom.current().nextInt(1, 10 + 1);
            displayPlayerTwoHand(player2hand);
        }
        else
        {
            displayPlayerTwoHand(player2hand);

        }
    }


    //Reset button code

    public void startButton(View view)
    {
        player1money = player1money - player1bet;
        player2money = player2money - player2bet;
        displayPlayerOneMoney(player1money);
        displayPlayerTwoMoney(player2money);
        player1hand = ThreadLocalRandom.current().nextInt(2, 21 + 1);
        player2hand = ThreadLocalRandom.current().nextInt(2, 21 + 1);
        displayPlayerOneHand(player1hand);
        displayPlayerTwoHand(player2hand);

    }

    public void resetButton(View view)
    {
        player1money = 100;
        player2money = 100;
        player2bet = 0;
        player1bet = 0;
        player1hand = 0;
        player2hand = 0;
    }

    public void calculateButton(View view)
    {
        if(player1hand < 22)
        {
          if (player2hand <22)
          {
              if (player1hand > player2hand) {
                  player1money = player1bet * 2 + player1money;
              } else {
                  player2money = player2money + player2bet * 2;
              }
          }
          else{
              player1money = player1money+player1bet*2;
          }

        }
        else
        {
            if(player2hand > 22)
            {
                player2bet = 0;
            }
            else
            {
                player2money = player2money + player2bet*2;
            }

        }
        displayPlayerOneMoney(player1money);
        displayPlayerTwoMoney(player2money);
        player2bet = 0;
        player1bet = 0;
        player1hand = 0;
        player2hand = 0;
        displayPlayerOneBet(player1bet);
        displayPlayerTwoBet(player2bet);
        displayPlayerOneHand(player1hand);
        displayPlayerTwoHand(player2hand);

    }


}
