package homework3;

public enum ZhenFa {
    HEYI{
        @Override
        public void arrange(BattleField battleField) {
            battleField.heYi(leaderX,leaderY);
        }
    },
    YANXING{
        @Override
        public void arrange(BattleField battleField) {
            battleField.yanXing(leaderX,leaderY);
        }
    },
    CHONGE{
        @Override
        public void arrange(BattleField battleField) {
            battleField.chongE(leaderX,leaderY);
        }
    },
    YULIN{
        @Override
        public void arrange(BattleField battleField) {
            battleField.yuLin(leaderX,leaderY);
        }
    },
    FANGYUAN{
        @Override
        public void arrange(BattleField battleField) {
            battleField.fangYuan(leaderX,leaderY);
        }
    },
    YANYUE{
        @Override
        public void arrange(BattleField battleField) {
            battleField.yanYue(leaderX,leaderY);
        }
    },
    FENGSHI{
        @Override
        public void arrange(BattleField battleField) {
            battleField.fengShi(leaderX, leaderY);
        }
    };

    private static int leaderX = 10, leaderY = 9;

    public void setLeader(int x, int y){
        leaderX = x;
        leaderY = y;
    }
    public abstract void arrange(BattleField battleField);
}
