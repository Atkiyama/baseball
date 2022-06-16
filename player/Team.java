package baseball.player;
/**
 * 各選手においてチーム、リーグを判別するクラス
 * @author akiyama
 *
 */
public class Team {
	/**
	 * 選手のチームを判別するメソッド
	 * @param team チームの識別アルファベット
	 * @return チーム名(漢字)
	 */
	public static String toStringTeam(char team) {
		if(team=='f')
			return "日";
		else if(team=='h')
			return "ソ";
		else if(team=='m')
			return "ロ";
		else if(team=='l')
			return "西";
		else if(team=='e')
			return "楽";
		else if(team=='b')
			return "オ";
		else if(team=='c')
			return "広";
		else if(team=='g')
			return "巨";
		else if(team=='a')
			return "デ";
		else if(team=='t')
			return "神";
		else if(team=='s')
			return "ヤ";
		return "中";
	}
	/**
	 * Pacificリーグかを判別するメソッド
	 * @param team チームの識別アルファベット
	 * @return
	 */
	public static boolean isPacific(char team) {
		String strTeam=String.valueOf(team);
		if(strTeam.equals("f")||strTeam.equals("h")||strTeam.equals("m")||strTeam.equals("l")||strTeam.equals("e")||strTeam.equals("b"))
			return true;
		else
			return false;

	}
}
