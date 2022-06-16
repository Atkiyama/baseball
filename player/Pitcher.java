package baseball.player;
/**
 * ピッチャーの情報を持つクラス
 * @author akiyama
 *
 */
public class Pitcher extends Player{
	private int win;
	private int loss;
	private int save;
	private int hp;
	private int out;
	private int er;
	/**
	 *
	 * @param name 選手名
	 * @param teams チーム名
	 * @param hand 利き手
	 * @param game 試合数
	 * @param win 勝利数
	 * @param loss 敗戦数
	 * @param save セーブ数
	 * @param hp ホールドポイント
	 * @param out アウト数
	 * @param er 自責点
	 */
	public Pitcher(String name, String teams, String hand, String game, String win, String loss, String save, String hp, String out,
			String er) {
		super(name, teams, hand, game);
		this.win =  Integer.parseInt(win);
		this.loss =  Integer.parseInt(loss);
		this.save =  Integer.parseInt(save);
		this.hp =  Integer.parseInt(hp);
		this.out =  Integer.parseInt(out);
		this.er =  Integer.parseInt(er);
	}
	public int getWin() {
		return win;
	}
	public int getLoss() {
		return loss;
	}
	public int getSave() {
		return save;
	}
	public int getHp() {
		return hp;
	}
	public int getOut() {
		return out;
	}
	public int getEr() {
		return er;
	}
	/**
	 * 防御率のゲッター
	 * @return 防御率
	 */
	public double getEra() {
		if(out==0)
			return -1;
		else
			return (double)er*27/(double)out;

	}
	/**
	 *勝率のゲッター
	 * @return 勝率
	 */
	public double getPercentage() {
		if(win+loss==0)
			return 0;
		else
			return (double)win/((double)win+(double)loss);
	}
	/**
	 * 利き手をStringで返す
	 */
	@Override
	protected String toStringHand() {
		// TODO 自動生成されたメソッド・スタブ
		if(hand.equals(Hand.RIGHT))
			return "右投げ";
		else if(hand.equals(Hand.LEFT))
			return "左投げ";
		else
			return "両投げ";
	}
	@Override
	/**
	 * 成績をフォーマットしてStringで返す
	 */
	protected String toStringStatics() {
		// TODO 自動生成されたメソッド・スタブ
		return game+"試合, "+win+"勝, "+loss+"敗, "+save+"セーブ, "+hp+"HP, 防御率"+String.format("%1.2f",getEra()) +", 勝率"+String.format("%1.3f", getPercentage() ); //toStringData();
	}


}
