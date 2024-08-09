/*
・mainクラス
・コンパイル用
・playerクラスを用いて初期残高を設定
・終わるかどうかの判別はSlotMachineGameクラスらがしてくれるので始めるコードだけ書けばいいはず
 */

public class SlotMachine {
    public static void main(String[] args) {
        Player player = new Player(1000); 
        Game game = new SlotMachineGame(player);
        game.start();
    }
}
