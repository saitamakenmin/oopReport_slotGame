/*
・スロットに使うシンボルをクラス型で設定
・設定以降変更が加えられないようにfinalとprivateここで使う。
・絵文字無理そうだったら最悪数字で代替
 */

public enum Symbol {
    CHERRY("🍒"),
    LEMON("🍋"),
    ORANGE("🍊"),
    WATERMELON("🍉"),
    GRAPE("🍇"),
    BELL("🔔"),
    STAR("⭐"),
    SEVEN("7️⃣");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

