/*
・ゲームの始まりと終わりを定義する抽象クラス
・playerを用意する
・プレイ中がどうかを判別するboolean型変数も用意しとく。別のクラスのif文でそのboolean型を使う
・他のゲームを作る際も使える(はず)
 */

public abstract class AbstractGame implements Game {
    protected Player player;
    protected boolean isRunning;

    public AbstractGame(Player player) {
        this.player = player;
        this.isRunning = true;
    }

    public void start() {
        System.out.println("ゲームが始まります！");
    }

    public void end() {
        System.out.println("ゲーム終了");
        isRunning = false;
    }
}
