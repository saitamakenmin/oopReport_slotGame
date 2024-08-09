/*
 ・symbolクラスを使ってゲーム開始時にスロットのシンボルを作成する
 ・プレイ中のスロット回転の挙動もここで書いちゃう
 */



import java.util.Random;

public class Reel {
    private Symbol currentSymbol;

    public Reel() {
        spin();
    }

    public void spin() {
        Symbol[] symbols = Symbol.values();
        Random random = new Random();
        currentSymbol = symbols[random.nextInt(symbols.length)];
    }

    public Symbol getCurrentSymbol() {
        return currentSymbol;
    }
}
