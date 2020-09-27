package dataStructure.BasketballPlayerDemo;

/*
模拟上场球员:
    1、初始容量为 5 的先行列表，准备用来存储用场上的 5 个球衣号码。
    2、安排 5 个球员上场：【13，22，23，45，51】。
    3、查询指定位置的球员的球衣号码是多少。
    4、根据球衣号码查询该球员在场上的索引位置。
    5、替换场上某个位置的的球员，并且修改该位置对应的球衣号码。
    6、替换场上某号球员。
    7、把场上某个位置的球员罚下（注意：罚下，没有补位）。
    8、按照球员在场上的位置，打印出球衣号码。
*/
public class BasketballPlayerDemo {

    // 记录上场球员
    private static Integer[] players = null;
    // 记录上场球员的数量
    private static int quantity = 0;

    /**
     * 初始化方法，设置线性列表的初始化容量，用来存储上场的球员的球衣号码
     *
     * @param initialCapacity 初始化容量
     */
    private static void init(int initialCapacity) {
        players = new Integer[initialCapacity];
    }

    /**
     * 安排球员上场
     *
     * @param playNum 球员号码
     */
    public void addPlayer(Integer playNum) {
        // 判断和扩容
        if (quantity == players.length) {
            players = copyPlayers(players.length * 2);
        }
        players[quantity] = playNum;
        // 插入后球员数量自增
        quantity++;
    }

    /**
     * 复制并扩容上场球员数量
     *
     * @param newQuantity 扩容数量
     * @return 扩容后的上场队列
     */
    private Integer[] copyPlayers(int newQuantity) {
        Integer[] newPlayers = new Integer[newQuantity];
        System.arraycopy(players, 0, newPlayers, 0, Math.min(players.length, newQuantity));
        return newPlayers;
    }

    /**
     * 查询指定位置的球员的球衣号码是多少
     *
     * @param index 位置下表
     * @return 球衣号码
     */
    public Integer getPlayerNum(int index) {
        if (0 > index || index >= quantity) {
            throw new IllegalArgumentException("索引越界");
        }
        return players[index];
    }

    /**
     * 根据球衣号码查询该球员在场上的索引位置
     *
     * @param playerNum 球衣号码
     * @return 场上位置（若为 -1，则该号码球员没有上场）
     */
    public int getIndexByPlayerNum(Integer playerNum) {
        for (int index = 0; index < 5; index++) {
            if (playerNum.equals(players[index])) {
                return index;
            }
        }
        return -1;
    }

    /**
     * 替换场上某个位置的的球员，并且修改该位置对应的球衣号码
     *
     * @param index 需要更换球员的位置
     * @param playerNum 更换的球员的号码
     */
    public void changePlayerByIndex(int index, Integer playerNum) {
        players[index] = playerNum;
    }

    /**
     * 替换场上某号球员
     *
     * @param oldPlayerNum 被替换的球员号码
     * @param newPlayerNum 替换后的球员号码
     */
    public void changePlayerByPlayNum(Integer oldPlayerNum, Integer newPlayerNum) {
        int index = getIndexByPlayerNum(oldPlayerNum);
        if (index > -1) {
            changePlayerByIndex(index, newPlayerNum);
        }
    }

    /**
     * 把场上某个位置的球员罚下（注意：罚下，没有补位）
     *
     * @param index 指定位置
     */
    public void deleteByIndex(int index) {
        for (int i = index; i < 5; i++) {
            players[i] = players[i + 1];
        }
        // 把最后一个位置设为 null
        players[quantity - 1] = null;
        // 减少上场队员数量
        quantity--;
    }

    /**
     * 打印上场球员号码
     */
    public void printPlayers() {
        if (players == null) {
            System.out.println("null");
            return;
        }
        if (quantity == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int index = 0; index < quantity; index++) {
            sb.append(players[index]);
            if (index == quantity - 1) {
                sb.append("]");
            } else {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}
