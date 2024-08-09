/*
・始まり、ゲームプレイ、終わりを定義するインタフェース。
・抽象クラスとセットで他のプログラム制作にも使える(はず)
 */


public interface Game {
    void start();
    void playRound();
    void end();
}
