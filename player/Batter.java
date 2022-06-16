package baseball.player;
/**
 * バッターの情報を持ったクラス
 * @author akiyama
 *
 */
public class Batter extends Player{
	private int pa;
	private int atBat;
	private int hit;
	private int twoBaseHit;
	private int threeBaseHit;
	private int homerun;
	private int rbi;
	private int strikeOut;

	/**
	 *
	 * @param name 選手名
	 * @param teams　チーム名
	 * @param hand 利き手
	 * @param game 試合数
	 * @param pa 打席数
	 * @param atBat 打数
	 * @param hit 安打数
	 * @param twoBaseHit 二塁打数
	 * @param threeBaseHit 三塁打数
	 * @param homerun 本塁打数
	 * @param rbi 打点
	 * @param strikeOut 三振数
	 */
	public Batter(String name, String teams, String hand, String game, String pa, String atBat, String hit, String twoBaseHit,
			String threeBaseHit, String homerun, String rbi, String strikeOut) {
		super(name, teams, hand, game);
		this.pa = Integer.parseInt(pa);
		this.atBat = Integer.parseInt(atBat);
		this.hit = Integer.parseInt(hit);
		this.twoBaseHit = Integer.parseInt(twoBaseHit);
		this.threeBaseHit = Integer.parseInt(threeBaseHit);
		this.homerun = Integer.parseInt(homerun);
		this.rbi = Integer.parseInt(rbi);
		this.strikeOut = Integer.parseInt(strikeOut);
	}
	public int getPa() {
		return pa;
	}
	public int getAtBat() {
		return atBat;
	}
	public int getHit() {
		return hit;
	}
	public int getTwoBaseHit() {
		return twoBaseHit;
	}
	public int getThreeBaseHit() {
		return threeBaseHit;
	}
	public int getHomerun() {
		return homerun;
	}
	public int getRbi() {
		return rbi;
	}
	public int getStrikeOut() {
		return strikeOut;
	}
	/**
	 * 打率のゲッター
	 * @return 打率
	 */
	public double getAverage() {
		if(atBat==0) {
			//System.out.println("あほ");
			return 0;
		}
		else
			return (double)hit/(double)atBat;


	}
	/**
	 * 長打率のゲッター
	 * @return 長打率
	 */
	public double getSlg() {
		if(atBat==0)
			return 0;
		else
			return (double)(hit+twoBaseHit+threeBaseHit*2+homerun*3)/(double)atBat;

	}
	@Override
	/**
	 * Handに応じた利き手をStringで返す
	 */
	protected String toStringHand() {
		// TODO 自動生成されたメソッド・スタブ
		if(hand.equals(Hand.RIGHT))
			return "右打ち";
		else if(hand.equals(Hand.LEFT))
			return "左打ち";
		else
			return "両打ち";
	}
	@Override
	/**
	 * 成績をフォーマットして返す
	 */
	protected String toStringStatics() {
		// TODO 自動生成されたメソッド・スタブ
		 return game+"試合, 打率"+String.format("%1.3f",getAverage())+ ", "+pa+"打席, "+hit+"安打, "+homerun+"本塁打, "+rbi+"打点, "+strikeOut+"三振, 長打率"+String.format("%1.3f",getSlg());
	}





}
