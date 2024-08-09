/*
・抽象クラス、インタフェースと連携する。
・コンストラクタ：抽象クラスからsuperする。その後総称型でリストを作る。リストの中身は絵文字なのでstring型、そもそものクラスはjava.utilから持ってきたリスト型。
・抽象クラスのstartをオーバーライドする。概要を文章で説明し、isRunning(boolean型)かつ掛け金が0円以上ならずっと続ける。
・概要は関数で書いちゃう
・if文で次のラウンドに行くかどうか判別する関数を作る
・ラウンド続行の際掛け金入力する関数を作る
・リールの回転はReelクラスにSpin関数があるからそれ使える
・回転結果を表記する関数を作成
・掛け金計算
・再度プレイするかどうかプレイヤーに聞く
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SlotMachineGame extends AbstractGame {
    private final List<Reel> reels;
    private int bet;

    public SlotMachineGame(Player player) {
        super(player);
        this.reels = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            reels.add(new Reel());
        }
    }

    public void start() {
        super.start();
        displayIntro();
        while (isRunning && player.getBalance() > 0) {
            playRound();
            if (player.getBalance() <= 0) {
                System.out.println("残高がないのでゲームオーバーです。");
                end();
            }
        }
    }

    private void displayIntro() {
        System.out.println("スロットゲーム");
        System.out.println("各リールには果物または'7️⃣'のシンボルがあります。");
        System.out.println("ジャックポットは'7️⃣ 7️⃣ 7️⃣'です!");
        System.out.println("初期残高は " + player.getBalance() + " です。");
    }

    public void playRound() {
        placeBet();
        spinReels();
        int payout = calculatePayout();
        updateBalance(payout);
        if (payout > 0) {
            System.out.println("おめでとうございます! " + payout + " の賞金を獲得しました。");
        } else {
            System.out.println("外れ。。。");
        }
        System.out.println("現在の残高: " + player.getBalance());

        if (askToPlayAgain()) {
            System.out.println("次のラウンドに進みます。");
        } else {
            end();
        }
    }

    private void placeBet() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("残高: " + player.getBalance());
            System.out.print("賭け金を入力してください: ");
            bet = scanner.nextInt();
            if (bet > player.getBalance()) {
                System.out.println("残高を超える賭け金は設定できません。");
            } else if (bet <= 0) {
                System.out.println("賭け金は1以上でなければなりません。");
            } else {
                break;
            }
        }
    }

    private void spinReels() {
        System.out.println("リールが回転中...");
        for (Reel reel : reels) {
            reel.spin();
        }
        displayReels();
    }

    private void displayReels() {
        for (Reel reel : reels) {
            System.out.print(reel.getCurrentSymbol().getSymbol() + " | ");
        }
        System.out.println();
    }

    /*ジャックポットとかの倍率変更はこちら */
    private int calculatePayout() {
        Symbol firstSymbol = reels.get(0).getCurrentSymbol();
        boolean allMatch = reels.stream().allMatch(reel -> reel.getCurrentSymbol() == firstSymbol);
        if (allMatch) {
            if (firstSymbol == Symbol.SEVEN) {
                return bet * 10; 
            } else {
                return bet * 5; 
            }
        } else if (reels.stream().filter(reel -> reel.getCurrentSymbol() == Symbol.SEVEN).count() == 2) {
            return bet * 2; 
        } else {
            return 0; 
        }
    }

    private void updateBalance(int payout) {
        player.addBalance(payout - bet); 
    }

    private boolean askToPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("もう一度プレイしますか？ (y/n): ");
        return scanner.next().equalsIgnoreCase("y");
    }
}
